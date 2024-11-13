package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class HomePageM extends CommonApiTest {

@Test
    public void sendTextInSearchBar()
    {
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("test");
    }
}
