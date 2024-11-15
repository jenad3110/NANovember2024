package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleChallenge extends CommonApiTest {

    @Test
    public void googleChallenge() throws InterruptedException {

        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(3000);


        WebElement list = driver.findElement(By.xpath("//*[@ role ='listbox']"));
        List<WebElement> allSug2 = list.findElements(By.tagName("span"));
        List<WebElement> allSug = list.findElements(By.tagName("b"));


        System.out.println(allSug2.size());
        System.out.println(allSug.size());

        for (int i = 0; i < allSug.size(); i++) {
            String a = allSug2.get(0).getText();
            String b = allSug.get(i).getText();

            System.out.println(a+" "+b);
        }


    }
}
