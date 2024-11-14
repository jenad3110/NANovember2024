package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageM2 extends CommonApiTest{
    //@Test
    public void clickOnCurrencyPoundSign() throws InterruptedException {

        String expectedPoundSign= "£";

        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();
        Thread.sleep(2000);

        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);

    }


    //@Test
    public void clickOnCurrencyEuroSign() throws InterruptedException {

        String expectedPoundSign= "€";

        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[1]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();
        Thread.sleep(2000);

        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);

    }

    @Test
    public void clickOnCurrencyDollarSign() throws InterruptedException {

        String expectedPoundSign= "$";

        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[3]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();
        Thread.sleep(2000);

        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);

    }


}
