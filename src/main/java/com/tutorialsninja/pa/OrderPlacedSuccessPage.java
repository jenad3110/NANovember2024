package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedSuccessPage {


    WebDriver driver;

    public OrderPlacedSuccessPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement orderPlaceSuccessMessage;



    public boolean isOrderSuccessMessageDisplayed(){

        return orderPlaceSuccessMessage.isDisplayed();
    }

    public String getSuccessMessageText(){

        return orderPlaceSuccessMessage.getText();
    }

    public boolean checkSuccessUrl(WebDriver driver){

        String url = driver.getCurrentUrl();


        return  url.contains("success");
    }
}
