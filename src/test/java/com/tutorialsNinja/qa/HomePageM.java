package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageM extends CommonApiTest {

    @Test
    public void hoverOverCurrenciesAndClickUsingActionClass() {
        WebElement currencySection = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span"));
        Actions action = new Actions(driver);
        action.moveToElement(currencySection);
        action.click().build().perform();

  }

  public void clickElement(String xpath){

        driver.findElement(By.xpath(xpath)).click();

  }

    @Test
    public void clickOnCurrencyText() {
        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();

        clickElement("//*[@class='hidden-xs hidden-sm hidden-md']");
    }

    @Test
    public void clickOnCurrencyLogo() {
        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).click();
    }

    @Test
    public void clickOnPhoneLogo() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/a")).click();
    }

    @Test
    public void clickOnMyAccountLogo() {
        driver.findElement(By.xpath("//*[@class='dropdown']/a/i")).click();
    }

    @Test
    public void clickOnMyAccountText() {
        driver.findElement(By.xpath("//*[@class='dropdown']/a/span")).click();
    }

    @Test
    public void clickOnWishListLogo() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[3]/a/i")).click();
    }

    @Test
    public void clickOnWishListText() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[3]/a")).click();
    }

    @Test
    public void clickOnShoppingCartLogo() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[4]/a/i")).click();
    }

    @Test
    public void clickOnShoppingCartText() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[4]/a")).click();
    }

    @Test
    public void clickOnCheckOutLogo() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[5]/a/i")).click();
    }

    @Test
    public void clickOnCheckOutText() {
        driver.findElement(By.xpath("//*[@class='list-inline']/li[5]/a")).click();
    }



    @Test
    public void hoverOverElementOnNavigationBar() {
        Actions action = new Actions(driver);
        WebElement navigationBar = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul"));
        List<WebElement> allElements = navigationBar.findElements(By.tagName("li"));

        for (WebElement element : allElements) {
            System.out.println(element.getText());
            action.moveToElement(element).build().perform();
        }
    }

    @Test
    public void phoneNumberIsDisplayed() {
        String actualResult = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/span")).getText();
        System.out.println(actualResult.equals(expectedResult("ExpectedPhoneNumber")));
    }

    @Test
    public void phoneNumberIsDisplayedUsingConfigFile() {
        String actualResult = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/span")).getText();
        String expectedPhoneNumber = expectedResult("expectedPhoneNumber");
        Assert.assertEquals(actualResult, expectedPhoneNumber);
    }

    @Test
    public void LogoIsDisplayedAndClickable () {

        WebElement logo = driver.findElement(By.id("logo"));
        logo.click();
        String actualLogo = logo.getText();
        Assert.assertEquals(actualLogo,expectedResult("websiteLogo"));

    }

    @Test
    public void clickOnCurrencyPoundSign() {
        String expectedPoundSign = expectedResult("expectedPoundSign");
        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();

        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

    @Test
    public void clickOnCurrencyEuroSign() {

        String expectedEuroSign = expectedResult("expectedEuroSign");
        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[1]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();

        System.out.println(expectedEuroSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

    @Test
    public void clickOnCurrencyDollarSign() {

        String expectedDollarSign = expectedResult("expectedDollarSign");

        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[3]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();

        System.out.println(expectedDollarSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

}
