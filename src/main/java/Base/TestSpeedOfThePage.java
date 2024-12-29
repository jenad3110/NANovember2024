package Base;

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

public class TestSpeedOfThePage {

    private static final long RECOMMENDED_PAGE_LOAD_TIME = 2000; // 2000 milliseconds (2 seconds)

    public static void main(String[] args) {

        // Initialize WebDriver with headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
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

            // Measure the speed of a specific page load
            measurePageSpeed(httpClient, "https://tutorialsninja.com/demo/");  // Replace with the target URL

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

    private static void measurePageSpeed(CloseableHttpClient httpClient, String url) {

        /**
         * measure loading speed of the page
         *
         * **/
        try {
            HttpGet request = new HttpGet(url);

            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                long endTime = System.currentTimeMillis();
                long loadTime = endTime - startTime;

                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    System.out.println("Page load time for " + url + ": " + loadTime + " milliseconds");

                    // Check if the load time exceeds the recommended speed
                    if (loadTime > RECOMMENDED_PAGE_LOAD_TIME) {
                        System.out.println("Error: Page load time exceeds the recommended speed of " + RECOMMENDED_PAGE_LOAD_TIME + " milliseconds.");
                    }
                } else {
                    System.out.println("Failed to load " + url + ". Status code: " + statusCode);
                }

                EntityUtils.consume(response.getEntity());
            }
        } catch (IOException e) {
            System.out.println("Error loading " + url + ". Error: " + e.getMessage());
        }
    }
}
