package Base;

import com.tutorialsninja.pa.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonApiTest {


    public Properties properties;


    public  WebDriver driver;
    @BeforeMethod
    public void SetUp() {

        setUpConfigFile();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");

        System.out.println("Before Method in common API accessed ");


    }

    @AfterMethod
    public void CloseTheBrowser(){

        driver.close();
    }


    public void setUpConfigFile()  {

        properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("expectedResults.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String expectedResult(String expectedValue){
        return properties.getProperty(expectedValue);
    }


    public void waitFor(int seconds)  {

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }





}
