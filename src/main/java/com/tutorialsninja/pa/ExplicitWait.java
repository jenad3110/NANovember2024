package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ExplicitWait extends CommonApiTest {

    public ExplicitWait(WebDriver driver){
        //super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/footer")
    WebElement footer;

    @FindBy(linkText = "Sell")
    WebElement sell;

    @FindBy(linkText = "Newsletter")
    WebElement newsLetter;

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open website
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_loading/1");


        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
/*
        // Use explicit wait to wait for the Hello World! message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
*/

        String actualR = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();

        String expectedR = "Hello World!";

        System.out.println(actualR);
        System.out.println(actualR.equalsIgnoreCase(expectedR));



        // Your test steps here

        // Close the browser
        //driver.quit();
    }



    public void scrollToBottomOnTHeHomePage(){


        scrollIntoView(footer);
    }

    public void clickNewsLetter(){

        clickElement(newsLetter);
    }


    public void navigateToSwappaAndScrollToTheBottomOfThePage(){

        driver.navigate().to("https://www.swappa.com");


        scrollIntoView(sell);

        waitFor(5);
        clickElement(sell);

    }



}
