package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

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

    @Test
    public void sendTextInSearchBarAndPressEnter() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("test");
        driver.findElement(By.xpath("//*[@class='input-group-btn']/button")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


}
