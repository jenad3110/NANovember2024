package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class OrderPlacedSuccessPage {


    public OrderPlacedSuccessPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    //    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    WebElement orderPlaceSuccessMessage;


    public boolean isOrderSuccessMessageDisplayed() {

        return orderPlaceSuccessMessage.isDisplayed();
    }

    public String getSuccessMessageText() {

        return orderPlaceSuccessMessage.getText();
    }

    public boolean checkSuccessUrl(WebDriver driver) {

        String url = driver.getCurrentUrl();

        return url.contains("success");

//        return Objects.requireNonNull(url).contains("success");
    }
}
