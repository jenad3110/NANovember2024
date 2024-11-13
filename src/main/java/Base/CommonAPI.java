package Base;





public class CommonAPI  {
/*
    public static WebListener webListener;
    EventFiringWebDriver e_driver;
    public WebDriver driver;

    public CommonAPI(WebDriver driver) {
        this.driver = driver;
    }

    public CommonAPI() {
    }

    public WebDriver getDriver() {

        return driver;
    }

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void SetUp(String browser, String url) {

        launchWebBrowser(browser);
        setWebListener();
        setUrlPath(url);
        setMaximizeBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(duration)));

    }

    private void setMaximizeBrowser() {

        if (maximizeBrowser.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();

        }
    }

    private void setUrlPath(String url) {
        if (setUrl.equalsIgnoreCase("true")) {
            driver.get(Url);
        } else {
            driver.get(url);
        }
    }

    private void launchWebBrowser(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    private void setWebListener() {

        e_driver = new EventFiringWebDriver(driver);
        webListener = new WebListener();
        e_driver.register(webListener);
        driver = e_driver;
    }

    public void setLogin(String UserName, String Password) {

        driver.findElement(By.id("user-name")).sendKeys(UserName);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.name("login-button")).click();

    }


    @AfterMethod
    public void tearDown(ITestResult result) {

        // new ScreenShot().ScreenShot(result);
       // driver.quit();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

*/
}
