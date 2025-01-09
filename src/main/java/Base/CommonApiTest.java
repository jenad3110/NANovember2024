package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class CommonApiTest {


    /**
     * Log4J setup
     **/
    public static final Logger log = LogManager.getLogger(CommonApiTest.class);


    public Properties properties;
    public WebDriver driver;
    String browserName;
    String url;
    ExtentTest extentTest;
    ExtentReports extentReport;


    public CommonApiTest(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * declare the constructor
     **/
    public CommonApiTest() {
    }

    /**
     * get method for the driver variable
     **/
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * before suite
     **/
    @BeforeSuite
    public void initializeTestSuite() {

        setUpConfigFile();
        log.debug("Test Suite Initialized.");

    }

    /**
     * before method
     **/
    @BeforeMethod
    public void SetUp() {


        initializeBrowser();

        setUrl();

        driver.get(url);


        driver.manage().window().maximize();

        log.info("Browser launched and navigated to URL: {}", url);

        log.debug("Before Method in common API accessed");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    /**
     * initialization of browser
     **/
    public void initializeBrowser() {
        browserName = properties.getProperty("browserName");
        log.debug("Browser name from config: {}", browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome Browser launched.");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("Firefox Browser launched.");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.info("Edge Browser launched.");
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            log.info("Safari Browser launched.");
        } else {
            driver = new ChromeDriver();
            log.warn("Browser name is invalid or missing in config, defaulting to Chrome.");
        }
    }

    /**
     * set up the URL
     **/
    public void setUrl() {
        url = properties.getProperty("url");
        log.info("Navigating to URL: {}", url);
    }





    @AfterMethod
    public void tearDown(ITestResult result) {


        log.info("AfterMethod opened");
        log.info("The test case  '{}' has been executed", result.getName());
        takeSCForFailedTest(result);
        driver.quit();
        log.info("driver.quit() method executed ");
        log.info("AfterMethod closed");


        driver.close();
    }

    }

    /**
     * set the properties to use in Config.Properties file
     **/
    public void setUpConfigFile() {
        properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("config.properties");
            log.debug("Config file loaded.");
        } catch (FileNotFoundException e) {
            log.error("Config file not found.", e);
            throw new RuntimeException(e);
        }

        try {
            properties.load(fileInputStream);
            log.debug("Properties loaded successfully.");
        } catch (IOException e) {
            log.error("Failed to load properties.", e);
            throw new RuntimeException(e);
        }
    }

    public String expectedResult(String expectedValue) {
        return properties.getProperty(expectedValue);
    }

    public void waitFor(int waitTime) {
        try {
            log.debug("Waiting for {} seconds...", waitTime);
            Thread.sleep(waitTime * 1000L);
            log.debug("Wait completed.");
        } catch (InterruptedException e) {
            log.error("Error during wait.", e);
            throw new RuntimeException(e);
        }
    }

    public String generateEmail() {
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmmssa");
        Date date = new Date();
        df.format(date);
        String email = "JohnDoe" + df.format(date) + "@gmail.com";
        log.debug("Generated email: {}", email);
        return email;
    }

    public void clickElement(WebElement element) {
        log.debug("Clicking on element: {}", element);
        element.click();
    }

    public void typeText(WebElement element, String text) {
        log.debug("Typing text into element: {} with value: {}", element, text);
        element.sendKeys(text);
    }

    public void explicitlyWait(By byLocator) {
        log.debug("Waiting for element to be visible: {}", byLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        log.debug("Element is visible.");
    }

    public void scrollIntoView(WebElement element) {
        log.debug("Scrolling to element: {}", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<WebElement> getDropDownOptions(WebElement dropdown) {
        log.debug("Getting dropdown options for element: {}", dropdown);
        Select select = new Select(dropdown);
        return select.getOptions();
    }

    public void selectFromDropdown(WebElement dropdown, String option) {
        log.debug("Selecting option: {} from dropdown: {}", option, dropdown);
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(option);
            log.info("Selected option by visible text: {}", option);
        } catch (Exception e) {
            select.selectByValue(option);
            log.info("Selected option by value: {}", option);
        }
    }

    public void takeScreenShot(ITestResult result) {
        log.info("Method takeScreenShot opened");

        DateFormat df = new SimpleDateFormat("MMddyyyy");
        Date date = new Date();

        File file;
        String name = result.getName();
        file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\screenshots\\screenshotsFailedTest\\" + name + " " + df.format(date) + ".jpeg"));
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        log.info("Screenshot taken");
        log.info("Method takeScreenShot closed ");
    }

    public void takeSCForFailedTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenShot(result);

            extentTest.log(Status.INFO, result.getName() + " Started Executing");

        }
    }
}
