package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class CommonApiTest {


    public Properties properties;
    public WebDriver driver;

    public CommonApiTest(WebDriver driver){
        this.driver = driver;
    }

    public CommonApiTest(){}




    public WebDriver getDriver(){
        return driver;
    }


    @BeforeMethod
    public void SetUp() {

        setUpConfigFile();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo");

        System.out.println("Before Method in common API accessed ");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }



    @AfterMethod
    public void CloseTheBrowser(){

        driver.close();
    }


    public void setUpConfigFile()  {

        properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("config.properties");
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



   public void waitFor(int waitTime){

       try {
           Thread.sleep(waitTime* 1000L);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }



    public  String generateEmail(){

        DateFormat df = new SimpleDateFormat("MMddyyyyHHmmssa");
        Date date = new Date();
        df.format(date);

        return "JohnDoe"+df.format(date) +"@gmail.com";



    }


    public void clickElement(WebElement element){

        element.click();

    }

    public void typeText(WebElement element,String text){

        element.sendKeys(text);
    }


    public  void explicitlyWait(By byLocator){


        // Use explicit wait to wait for the Hello World! message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }


    public void scrollIntoView(WebElement element){

        // Scroll the element into view using JavaScriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }






}
