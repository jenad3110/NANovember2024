package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RegistrationPage extends CommonApiTest {

    String getGeneratedEmail;

    public RegistrationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // WebElements on the Registration Page


    // Personal Details
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    // Password
    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    // Privacy Policy
    @FindBy(name = "agree")
    WebElement privacyPolicyCheckbox;

    // Continue Button
    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    WebElement continueButton;


    @FindBy(css = "input[type='submit']")
    WebElement submitButton;

    @FindBy(css = ".text-danger")
    WebElement errorAlert;

    @FindBy(css = ".text-danger")
    List<WebElement> errorsAlert;
    // Right Column Elements
    @FindBy(id = "column-right")
    WebElement columnRight;

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(linkText = "Edit Account")
    WebElement editAccountLink;

    @FindBy(linkText = "Forgotten Password")
    WebElement forgottenPasswordLink;

    @FindBy(linkText = "Address Book")
    WebElement addressBookLink;

    @FindBy(linkText = "Wish List")
    WebElement wishListLink;

    @FindBy(linkText = "Order History")
    WebElement orderHistoryLink;

    @FindBy(linkText = "Downloads")
    WebElement downloadsLink;

    @FindBy(linkText = "Recurring payments")
    WebElement recurringPaymentsLink;

    @FindBy(linkText = "Reward Points")
    WebElement rewardPointsLink;

    @FindBy(linkText = "Returns")
    WebElement returnsLink;

    @FindBy(linkText = "Transactions")
    WebElement transactionsLink;

    @FindBy(linkText = "Newsletter")
    WebElement newsletterLink;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@id='account']/div[2]/div/div")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//*[@id='account']/div[2]/div/div")
    WebElement lastNameErrorMessage;

    @FindBy(xpath = "//*[@id='account']/div[2]/div/div")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id='account']/div[2]/div/div")
    WebElement telephoneErrorMessage;

    @FindBy(css = ".text-danger")
    List<WebElement> errorMessages; // Using a list to check for multiple error messages


    // Methods to interact with the elements

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
        System.out.println("first name " + fName + " entered");
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterEmail(String emailAddress) {
        email.sendKeys(emailAddress);

    }


    public void enterTelephone(String phone) {
        telephone.sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        confirmPassword.sendKeys(confirmPwd);
    }

    public void agreeToPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void clickEditAccountLink() {
        editAccountLink.click();
    }

    public void clickPasswordLink() {
        forgottenPasswordLink.click();
    }

    public void clickAddressBookLink() {
        addressBookLink.click();
    }

    public void clickWishListLink() {
        wishListLink.click();
    }

    public void clickOrderHistoryLink() {
        orderHistoryLink.click();
    }

    public void clickDownloadsLink() {
        downloadsLink.click();
    }

    public void clickRecurringPaymentsLink() {
        recurringPaymentsLink.click();
    }

    public void clickRewardPointsLink() {
        rewardPointsLink.click();
    }

    public void clickReturnsLink() {
        returnsLink.click();
    }

    public void clickTransactionsLink() {
        transactionsLink.click();
    }

    public void clickNewsletterLink() {
        newsletterLink.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean isColumnRightDisplayed() {
        return columnRight.isDisplayed();
    }

    public boolean isMyAccountLinkDisplayed() {
        return myAccountLink.isDisplayed();
    }

    public boolean isEditAccountLinkDisplayed() {
        return editAccountLink.isDisplayed();
    }

    public boolean isForgottenPasswordLinkDisplayed() {
        return forgottenPasswordLink.isDisplayed();
    }

    public boolean isAddressBookLinkDisplayed() {
        return addressBookLink.isDisplayed();
    }

    public boolean isWishListLinkDisplayed() {
        return wishListLink.isDisplayed();
    }

    public boolean isOrderHistoryLinkDisplayed() {
        return orderHistoryLink.isDisplayed();
    }

    public boolean isDownloadsLinkDisplayed() {
        return downloadsLink.isDisplayed();
    }

    public boolean isRecurringPaymentsLinkDisplayed() {
        return recurringPaymentsLink.isDisplayed();
    }

    public boolean isRewardPointsLinkDisplayed() {
        return rewardPointsLink.isDisplayed();
    }

    public boolean isReturnsLinkDisplayed() {
        return returnsLink.isDisplayed();
    }

    public boolean isTransactionsLinkDisplayed() {
        return transactionsLink.isDisplayed();
    }

    public boolean isNewsletterLinkDisplayed() {
        return newsletterLink.isDisplayed();
    }

    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }


    public void submitForm() {
        submitButton.click();
    }


    public boolean isErrorDisplayedForFirstName() {
        return getErrorMessageForInvalidFirstName() != null;
    }


//    public String getErrorMessageForInvalidFirstName(){
    //        return firstNameErrorMessage.getText();
    //  }


    public String getErrorMessageForInvalidEmail() {
        return emailErrorMessage.getText();
    }

    public String getErrorMessageForInvalidTelephone() {
        return telephoneErrorMessage.getText();
    }


    public String getErrorMessageForInvalidFirstName() {
        for (WebElement errorMessage : errorMessages) {
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("First Name")) {
                return errorMessage.getText();
            }
        }
        return ""; // Return an empty string if no relevant error message is found
    }

    public boolean isFirstNameAccepted() {
        return getErrorMessageForInvalidFirstName().isEmpty();
    }

    public boolean isLastNameAccepted() {
        // This method should check if there are no error messages for the last name
        for (WebElement errorMessage : errorMessages) {
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("Last Name")) {
                return false;
            }
        }
        return true;
    }

    public String getErrorMessageForInvalidLastName() {
        for (WebElement errorMessage : errorMessages) {
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("Last Name")) {
                return errorMessage.getText();
            }
        }
        return "";
    }

    public boolean isErrorDisplayedForLastName() {
        for (WebElement errorMessage : errorMessages) {
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("Last Name")) {
                return true;
            }
        }
        return false;
    }


    public void getAllerrorMessageDisplayed() {

        for (WebElement element : errorMessages)


            System.out.println(element.getText());

    }

    @FindBy(xpath = "//*[@id=\"account\"]/div[2]/div/div")
    WebElement erormsgforfirstname;


    public String returnErrorMessageForFirstName() {

        System.out.println("");
        return erormsgforfirstname.getText();
    }


    public String getEmail() {
        return getGeneratedEmail;

    }

    public String generateEmail() {

        DateFormat df = new SimpleDateFormat("MMddyyyyHHmmssa");
        Date date = new Date();
        df.format(date);
        getGeneratedEmail = "JohnDoe" + df.format(date) + "@gmail.com";
        return getGeneratedEmail;


    }


}

