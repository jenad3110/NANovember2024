package Base;
import Base.CommonApiTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;

public class BrokenLinksChecker extends CommonApiTest {

    public static void main(String[] args) {


        // Initialize WebDriver with headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
        options.addArguments("--no-sandbox");  // Add this if you're running in a Docker container
        options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
        WebDriver driver = new ChromeDriver(options);


        // Open the webpage
        driver.get("https://tutorialsninja.com/demo/");  // Replace with the target URL

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Initialize HttpClient with timeouts
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {
            // Check each link
            for (WebElement link : links) {
                String url = link.getAttribute("href");
                if (url != null && !url.isEmpty()) {
                    checkLink(httpClient, url);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the WebDriver
        driver.quit();
    }

    private static void checkLink(CloseableHttpClient httpClient, String url) {
        try {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode >= 400) {
                    System.out.println(url + " is a broken link. Status code: " + statusCode);
                } else {
                    System.out.println(url + " is a valid link. Status code: " + statusCode);
                }
                EntityUtils.consume(response.getEntity());
            }
        } catch (IOException e) {
            System.out.println(url + " is a broken link. Error: " + e.getMessage());
        }
    }
}