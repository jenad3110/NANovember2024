package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class HomePageM extends CommonApiTest {

    String ExpectedPhoneNumber = "123456789";

    //@Test
    public void clickOnCurrencyText(){

        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();

    }
  //  @Test
    public void clickOnCurrencyLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).click();
        Thread.sleep(2000);

    }

    @Test
    public void hoverOverCurrencies() throws InterruptedException {
        WebElement currencySection = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span"));
        WebElement listOfCurrencies = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));

        Actions action = new Actions(driver);

        action.moveToElement(currencySection).build().perform();
        action.click();

        List<WebElement> allSug = listOfCurrencies.findElements(By.tagName("button"));
        for(int i=0; i< allSug.size();i++) {
            allSug.get(i).click();
            System.out.println(allSug.get(i).getText());
            driver.navigate().back();

            //driver.findElements(By.className("dropdown-menu")).size();
            //String xpathForListOfCurrencies = "//ul[@class='dropdown-menu']/li";
/*
            WebElement listOfCurrencies = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));

            List<WebElement> allSug = listOfCurrencies.findElements(By.tagName("button"));

            int numberOfCurrencies = allSug.size();

            //System.out.println(allSug.get(2).getAttribute("name"));
            //System.out.println(numberOfCurrencies);


            for (int i = 0; i < numberOfCurrencies; i++) {

                System.out.println(allSug.get(i).getAttribute("name"));
            }
            */
        }
    }



   // @Test
    public void clickOnPhoneLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/a")).click();
        Thread.sleep(2000);

    }

    //@Test
    public void phoneNumberIsDisplayed(){

       String ActualResult = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[1]/span")).getText();

        System.out.println(ActualResult.equals(ExpectedPhoneNumber));


    }
//@Test
    public void clickOnMyAccountLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='dropdown']/a/i")).click();
        Thread.sleep(2000);

    }

  //  @Test
    public void clickOnMyAccountText() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='dropdown']/a/span")).click();
        Thread.sleep(2000);

    }

   // @Test
    public void clickOnWishListLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[3]/a/i")).click();
        Thread.sleep(2000);

    }

    //@Test
    public void clickOnWishListText() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[3]/a")).click();
        Thread.sleep(2000);

    }

   // @Test
    public void clickOnShoppingCartLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[4]/a/i")).click();
        Thread.sleep(2000);

    }

    //@Test
    public void clickOnShoppingCartText() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[4]/a")).click();
        Thread.sleep(2000);

    }


  //  @Test
    public void clickOnCheckOUtLogo() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[5]/a/i")).click();
        Thread.sleep(2000);

    }

    //@Test
    public void clickOnCheckOutText() throws InterruptedException {

        driver.findElement(By.xpath("//*[@class='list-inline']/li[5]/a")).click();
        Thread.sleep(2000);

    }

    //@Test
    public void sendTextInSearchBar() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("test");
        Thread.sleep(2000);
    }


   // @Test
    public void sendTextInSearchBarAndClickButtonSearch() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("test");
        driver.findElement(By.xpath("//*[@class='input-group-btn']/button")).click();
        Thread.sleep(2000);
    }

    //@Test
    public void sendTextInSearchBarAndPressEnter() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("test");
        driver.findElement(By.xpath("//*[@class='input-group-btn']/button")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }



    @Test
    public void hoverOverNavigationBar(){


      WebElement navigationBar =  driver.findElement(By.xpath("//ul[@class='nav navbar-nav']"));

        System.out.println(navigationBar.findElements(By.tagName("a")).get(1).getText());
    }

}
