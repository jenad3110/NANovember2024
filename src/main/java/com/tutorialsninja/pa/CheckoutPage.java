package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    // Constructor to initialize PageFactory
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "button-payment-method")
    private WebElement continueButton;

    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    private WebElement checkoutPageTitle;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
    WebElement guestButton;

    // Methods
    public boolean isCheckoutPageDisplayed() {
        return checkoutPageTitle.isDisplayed();
    }

    public void completeCheckout() {
        continueButton.click();
    }

    public void clickGuestCheckout(){

        guestButton.click();
    }
}
