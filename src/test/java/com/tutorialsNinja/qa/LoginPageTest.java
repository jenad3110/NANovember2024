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

    }

    @Test
    public void invalidCredentialLogin() {
        loginPage.enterFalseEmailAddress();
        loginPage.enterFalsePassword();
        loginPage.clickLoginBtn();
        loginPage.errorLogin();


    }


    @Test
    public void Logout() {
        loginPage.enterEmailAddress();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
        loginPage.clickLogoutBtn();
        loginPage.logoutText();

    }

    @Test
    public void validCredentialForPassword() {
        loginPage.forgottenPassword();
        loginPage.validEmailForPass();
        loginPage.continueBtnForPass();
        loginPage.successAlert();

    }

    @Test
    public void invalidCredentialForPassword() {
        loginPage.forgottenPassword();
        loginPage.falseEmailForPass();
        loginPage.continueBtnForPass();
        loginPage.warningAlert();
        loginPage.backBtn();
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


    }
}


