package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    // Constructor to initialize PageFactory
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "Checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement cartPageTitle;


    // Methods
    public boolean isCartPageDisplayed() {
        return cartPageTitle.isDisplayed();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }


}
