package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonApiTest {


    public RegisterPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }


    @FindBy(name = "firstname")
    WebElement firstNameField;



    public void setFirstNameField(String FirstName){

        firstNameField.sendKeys(FirstName);


    }



}
