package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import com.tutorialsninja.pa.LoginPage;
import com.tutorialsninja.pa.RegistrationPage;
import org.testng.Assert;
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


    }

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.enterEmailAddress(expectedResult("EmailAddress"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isHomeLogoDisplayed());
        log.info("Test Case Passed: Login using valid email and password.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.enterInvalidEmailAddress(expectedResult("InvalidEmailAddress"));
        loginPage.enterInvalidPassword(expectedResult("InvalidPassword"));
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        Assert.assertTrue(loginPage.isErrorLoginMessageDisplayed());
        log.info("Test Case Passed: Login using invalid email and password.");
    }

    @Test
    public void testLoginWithEmptyFields() {
        loginPage.clearEmailField();
        loginPage.clearPasswordField();
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        Assert.assertTrue(loginPage.isErrorLoginMessageDisplayed());
        log.info("Test Case Passed: Login with empty fields failed as expected.");
    }

    @Test
    public void testLoginWithInvalidEmailFormat() {
        loginPage.enterEmailAddress(expectedResult("InvalidEmailFormat"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        loginPage.errorLogin();
        Assert.assertTrue(loginPage.isErrorLoginMessageDisplayed());
        log.info("Test Case Passed: Login with invalid email format failed as expected.");
    }

    @Test
    public void testLogout() {
        loginPage.enterEmailAddress(expectedResult("EmailAddress"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        loginPage.clickLogoutBtn();
        loginPage.logoutText();
        Assert.assertTrue(loginPage.isLogoutMessageDisplayed());
        log.info("Test Case Passed: Logout session validated.");
    }

    @Test
    public void testForgottenPasswordWithValidCredentials() {
        loginPage.forgottenPassword();
        loginPage.validEmailForgottenPassword(expectedResult("EmailAddress"));
        loginPage.continueBtnForgottenPassword();
        loginPage.successAlert();
        Assert.assertTrue(loginPage.isSuccessMessageDisplayed());
        log.info("Test Case Passed: Forgotten password using valid credentials.");
    }

    @Test
    public void testForgottenPasswordWithInvalidCredentials() {
        loginPage.forgottenPassword();
        loginPage.invalidEmailForgottenPassword(expectedResult("InvalidEmailAddress"));
        loginPage.continueBtnForgottenPassword();
        loginPage.warningAlert();
        Assert.assertTrue(loginPage.isWarningMessageDisplayed());
        loginPage.backBtn();
        log.info("Test Case Passed: Forgotten password using invalid credentials.");
    }

    @Test
    public void testLoginUsingNewRegisteredAccountCredentials() {
        String getGeneratedEmail;
        homePage.clickMyAccountButton();
        homePage.clickRegisterButton();
        registrationPage.enterFirstName(expectedResult("FirstName"));
        registrationPage.enterLastName(expectedResult("LastName"));
        registrationPage.enterEmail(registrationPage.generateEmail());
        log.debug("Generated Email: {}", registrationPage.getEmail());
        getGeneratedEmail = registrationPage.getEmail();
        registrationPage.enterTelephone(expectedResult("PhoneNumber"));
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
        Assert.assertTrue(loginPage.isHomeLogoDisplayed());
        log.info("Test Case Passed: Login using new registered account credentials.");
    }

    @Test
    public void testValidateLoginPageUIElements() {
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        log.info("Test Case Passed: UI elements validation passed.");
    }

    @Test
    public void testSessionPersistenceAfterLogin() {
        loginPage.enterEmailAddress(expectedResult("EmailAddress"));
        loginPage.enterPassword(expectedResult("PassKey"));
        loginPage.clickLoginBtn();
        driver.navigate().refresh();
        Assert.assertTrue(loginPage.isUserLoggedIn());
        log.info("Test Case Passed: Session persistence validated after login.");
    }
}
