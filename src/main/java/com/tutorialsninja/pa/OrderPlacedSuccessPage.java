package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedSuccessPage {


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
}
