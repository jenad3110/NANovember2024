package com.tutorialsninja.pa;


import Base.CommonAPI;
import Base.CommonApiTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonApiTest {

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "input-email")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id='account-account']/ul/li[1]/a/i")
    WebElement homeLogo;


    @FindBy(id = "input-email")
    WebElement invalidEmailAddress;

    @FindBy(xpath = "//*[@id='input-password']")
    WebElement invalidPassword;

    @FindBy(xpath = "//*[@id='account-login']/div[1]")
    WebElement errorLoginMessage;


    @FindBy(linkText = "Logout")
    WebElement logoutBtn;

    @FindBy(xpath = "//*[@id='content']/p[1]")
    WebElement logoutText;

    @FindBy(linkText = "Forgotten Password")
    WebElement forgottenPassword;

    @FindBy(id = "input-email")
    WebElement emailForgottenPassword;

    @FindBy(xpath = "//*[@id='content']/form/div/div[2]/input")
    WebElement continueBtnForPass;

    @FindBy(xpath = "//*[@id='account-login']/div[1]")
    WebElement successAlert;

    @FindBy(xpath = "//*[@id='account-forgotten']/div[1]")
    WebElement warningAlert;

    @FindBy(linkText = "Back")
    WebElement backBtn;

    @FindBy(linkText = "Continue")
    WebElement continueBtnForLogOut;


    public void enterEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String passKey) {
        password.sendKeys(passKey);
    }


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean isHomeLogoDisplayed() {
        return homeLogo.isDisplayed();
    }

    public void enterInvalidEmailAddress(String email) {
        invalidEmailAddress.sendKeys(email);
    }

    public void enterInvalidPassword(String password) {
        invalidPassword.sendKeys(password);
    }

    public void errorLogin() {
        System.out.println(errorLoginMessage.getText());

    }

    public boolean isErrorLoginMessageDisplayed() {
        return errorLoginMessage.isDisplayed();
    }


    public void clickLogoutBtn() {
        logoutBtn.click();
    }

    public void logoutText() {
        System.out.println(logoutText.getText());
    }

    public boolean isLogoutMessageDisplayed() {
        return logoutText.isDisplayed();
    }

    public void forgottenPassword() {
        forgottenPassword.click();
    }

    public void validEmailForgottenPassword(String email) {
        emailForgottenPassword.sendKeys(email);

    }

    public void invalidEmailForgottenPassword(String email) {
        emailForgottenPassword.sendKeys(email);
    }

    public void continueBtnForgottenPassword() {
        continueBtnForPass.click();
    }

    public void successAlert() {
        System.out.println(successAlert.getText());
    }

    public boolean isSuccessMessageDisplayed() {
        return successAlert.isDisplayed();
    }

    public void warningAlert() {
        System.out.println(warningAlert.getText());
    }

    public boolean isWarningMessageDisplayed(){
        return warningAlert.isDisplayed();
    }

    public void backBtn() {
        backBtn.click();
    }

    public void clickContinueButtonToLogOut() {
        continueBtnForLogOut.click();
    }

    public void clearEmailField() {
        emailAddress.clear();
    }

    public void clearPasswordField() {
        password.clear();
    }

    public boolean isEmailFieldDisplayed() {

        if (emailAddress.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordFieldDisplayed() {

        if (password.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {

        if (loginBtn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserLoggedIn() {

        if (homeLogo.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}



