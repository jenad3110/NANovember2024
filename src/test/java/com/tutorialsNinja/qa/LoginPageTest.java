package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import com.tutorialsninja.pa.LoginPage;
import com.tutorialsninja.pa.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends CommonApiTest {


    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;


    @BeforeMethod
    public void accessLoginPageTest() {
        homePage = new HomePage(driver);
        homePage.accessLoginPage();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        System.out.println("Before Method in LoginPage test accessed ");

    }

    @Test
    public void validCredentialLogin() {
        loginPage.enterEmailAddress();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        loginPage.homeLogo();
        System.out.println("Test Case: login using valid email and password ");

    }

    @Test
    public void invalidCredentialLogin() {
        loginPage.enterFalseEmailAddress();
        loginPage.enterFalsePassword();
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        System.out.println("Test Case: login using invalid email and password ");

    }

    @Test
    public void emptyFieldsLogin() {
        loginPage.clearEmailField();
        loginPage.clearPasswordField();
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        System.out.println("Test Case: Login with empty fields failed as expected.");
    }

    @Test
    public void invalidEmailFormatLogin() {
        loginPage.enterEmailAddress(expectedResult("InvalidEmailFormat"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        System.out.println("Test Case: Login with invalid email format failed as expected.");

    }

    @Test
    public void Logout() {
        loginPage.enterEmailAddress();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        loginPage.clickLogoutBtn();
        loginPage.logoutText();
        System.out.println("Test Case: login out session ");

    }


    @Test
    public void validCredentialForgottenPassword() {
        loginPage.forgottenPassword();
        loginPage.validEmailForPass();
        loginPage.continueBtnForPass();
        loginPage.successAlert();
        System.out.println("Test Case:forgotten password using valid credentials");

    }

    @Test
    public void invalidCredentialForgottenPassword() {
        loginPage.forgottenPassword();
        loginPage.falseEmailForPass();
        loginPage.continueBtnForPass();
        loginPage.warningAlert();
        loginPage.backBtn();
        System.out.println("Test Case:forgotten password using invalid credentials");
    }

    @Test
    public void loginUsingValidNewRegisteredAccountCredentials() {

        // register new account 
        // email is generated automatically 
        // login using the email and password from the registered account

        String getGeneratedEmail;
        homePage.clickMyAccountButton();
        homePage.clickRegisterButton();
        registrationPage.enterFirstName(expectedResult("FirstName"));
        registrationPage.enterLastName(expectedResult("LastName"));
        registrationPage.enterEmail(registrationPage.generateEmail());
        System.out.println(registrationPage.getEmail());
        getGeneratedEmail = registrationPage.getEmail();
        registrationPage.enterTelephone(expectedResult("Telephone"));
        registrationPage.enterPassword(expectedResult("Password"));
        registrationPage.enterConfirmPassword(expectedResult("Password"));
        registrationPage.agreeToPrivacyPolicy();
        registrationPage.clickContinue();
        loginPage.clickLogoutBtn();
        loginPage.clickContinueButtonToLogOut();
        homePage.accessLoginPage();
        loginPage.enterEmailAddress(getGeneratedEmail);
        loginPage.enterPassword(expectedResult("Password"));
        loginPage.clickLoginBtn();
        System.out.println("Test Case: Login Using valid new registered account credentials");


    }


    @Test
    public void validateUIElements() {
        assert loginPage.isEmailFieldDisplayed();
        assert loginPage.isPasswordFieldDisplayed();
        assert loginPage.isLoginButtonDisplayed();
        System.out.println("Test Case: UI elements validation passed.");
    }


    @Test
    public void sessionPersistenceAfterLogin() {
        loginPage.enterEmailAddress(expectedResult("EmailAddress"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        driver.navigate().refresh();
        assert loginPage.isUserLoggedIn();
        System.out.println("Test Case: Session persistence passed.");

    }


}
