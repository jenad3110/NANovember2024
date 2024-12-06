package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends CommonApiTest {

    WebDriver driver;

    // Constructor to initialize PageFactory
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "button-account")
    WebElement continueButton;

    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutPageTitle;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
    WebElement guestButton;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
    WebElement lastNameInput;

    @FindBy(name = "company")
    WebElement companyInput;

    @FindBy(name = "address_1")
    WebElement address1Input;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name="country_id")
    WebElement countryDropDown;

    @FindBy(name="zone_id")
    WebElement stateRegion;

    @FindBy(xpath = "//*[@id='button-guest']")
    WebElement continueButtonUnderPaymentSection;

    @FindBy(xpath="//*[@id='input-payment-email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='input-payment-telephone']")
    WebElement telephoneField;

    @FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
    WebElement continueButtonUnderDeliveryMethod;

    @FindBy(xpath = "//*[@id='button-payment-method']")
    WebElement continueButtonUnderPaymentMethod;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[3]/div/input[1]")
    WebElement agreeToTermsAndCondCheckBox;

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

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void enterAddress1(String address1) {
        address1Input.clear();
        address1Input.sendKeys(address1);
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterPostcode(String postcode) {
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
    }

    public void clickContinueButton(){

        continueButton.click();

    }


    public void selectRegion(String regionState){


        Select select = new Select(stateRegion);
        select.selectByVisibleText(regionState);
    }

    public void clickContinueButtonUnderPaymentSection(){


        continueButtonUnderPaymentSection.click();
    }

    public void enterEmail(String email){

       emailField.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber){


        telephoneField.sendKeys(phoneNumber);
    }

    public void clickContinueButtonUnderDeliveryMethod(){

        continueButtonUnderDeliveryMethod.click();
    }

    public void clickContinueButtonUnderPaymentMethod(){

        continueButtonUnderPaymentMethod.click();
    }

}
