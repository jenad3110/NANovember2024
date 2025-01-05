package com.tutorialsninja.pa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    // Constructor to initialize PageFactory
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"product-product\"]/div[1]")
    WebElement successMessage;

    @FindBy(xpath="//*[@id=\"cart\"]/button")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[5]/a/span")
    WebElement checkoutButton;

    // Methods
    public void addToCart() {
        addToCartButton.click();
    }

    public void clickShoppingCartButton(){

        shoppingCartButton.click();
    }

    public boolean isProductAddedToCart() {
        return successMessage.isDisplayed();
    }
    public void clickCheckoutButton(){
        checkoutButton.click();


    }
}
