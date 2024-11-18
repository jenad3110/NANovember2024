package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class CommonApiTest {

    public  WebDriver driver;
    @BeforeMethod
    public void SetUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");

    }

    @AfterMethod
    public void CloseTheBrowser(){

        driver.close();
    }
}
