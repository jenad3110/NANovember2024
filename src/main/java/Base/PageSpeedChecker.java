package Base;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Properties;

public class PageSpeedChecker {

    private static final long RECOMMENDED_PAGE_LOAD_TIME = 2000; // 2000 milliseconds (2 seconds)

    public static void measurePageSpeed(String url, Properties config) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {

            HttpGet request = new HttpGet(url);
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                long endTime = System.currentTimeMillis();
                long loadTime = endTime - startTime;
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    System.out.println("Page load time for " + url + ": " + loadTime + " milliseconds");
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
