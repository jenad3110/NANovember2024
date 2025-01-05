package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsCategoryPage extends CommonApiTest {

    // Constructor to initialize PageFactory
    public DesktopsCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[1]")
    private WebElement addToCartButton;

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    // Locators
    @FindBy(linkText = "HP LP3065")
    private WebElement hpLp3065Product;

    // Methods

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean isProductAddedToCart() {
        return successMessage.isDisplayed();
    }

    public void selectHP_LP3065() {
        hpLp3065Product.click();
    }

}
