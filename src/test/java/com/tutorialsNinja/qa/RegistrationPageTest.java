package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import com.tutorialsninja.pa.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class RegistrationPageTest extends CommonApiTest {


    RegistrationPage registrationPage;
    RegistrationPage rightColumnPage;
    HomePage homePage;
    String actualResult;
    String expectedResult;


    @Test(groups = "end to end")
    public void registerNewUser() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("FirstName"));
        registrationPage.enterLastName(expectedResult("LastName"));
        registrationPage.enterEmail(registrationPage.generateEmail());
        System.out.println(registrationPage.getEmail());
        registrationPage.enterTelephone(expectedResult("Telephone"));
        registrationPage.enterPassword(expectedResult("Password"));
        registrationPage.enterConfirmPassword(expectedResult("Password"));
        registrationPage.agreeToPrivacyPolicy();
        registrationPage.clickContinue();
        waitFor(30);

    }

    @Test(groups = "end to end")
    public void accessAccountAfterRegistration() {
        homePage.accessRegistrationPage();
        homePage.clickMyAccountButton();
        homePage.accessRegistrationPage();
        registerNewUser();
        registrationPage.clickOrderHistoryLink();
    }

    @Test
    public void testRightColumnDisplayed() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isColumnRightDisplayed());
    }

    @Test
    public void testMyAccountLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isMyAccountLinkDisplayed());
        rightColumnPage.clickMyAccountLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testPasswordLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isForgottenPasswordLinkDisplayed());
        rightColumnPage.clickPasswordLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testAddressBookLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isAddressBookLinkDisplayed());
        rightColumnPage.clickAddressBookLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testWishListLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isWishListLinkDisplayed());
        rightColumnPage.clickWishListLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testOrderHistoryLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isOrderHistoryLinkDisplayed());
        rightColumnPage.clickOrderHistoryLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testDownloadsLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isDownloadsLinkDisplayed());
        rightColumnPage.clickDownloadsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testRecurringPaymentsLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isRecurringPaymentsLinkDisplayed());
        rightColumnPage.clickRecurringPaymentsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testRewardPointsLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isRewardPointsLinkDisplayed());
        rightColumnPage.clickRewardPointsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testReturnsLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isReturnsLinkDisplayed());
        rightColumnPage.clickReturnsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testTransactionsLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isTransactionsLinkDisplayed());
        rightColumnPage.clickTransactionsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testNewsletterLink() {
        homePage.accessRegistrationPage();
        assertTrue(rightColumnPage.isNewsletterLinkDisplayed());
        rightColumnPage.clickNewsletterLink();
        // Add additional assertions to verify the result after clicking
    }

    // testing firstName Field

    @Test
    public void testValidFirstName() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("FirsName"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isFirstNameAccepted());
    }

    @Test
    public void testFirstNameWithNumbers() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("FirstNameWithNumbers"));
        registrationPage.submitForm();
        String actualResult = registrationPage.returnErrorMessageForFirstName();
        String expectedResult = "First Name must be between 1 and 32 characters!";
        assertEquals(actualResult, expectedResult);
        // bug must return error message
    }

    @Test
    public void testFirstNameWithSpecialCharacters() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("FirstNameWithSpecialCharacters"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForFirstName());
    }

    @Test
    public void testFirstNameWithSpaces() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("FirstNameWithSpaces"));
        registrationPage.submitForm();
        assertEquals(registrationPage.getErrorMessageForInvalidFirstName(), expectedResult("FirstNameErrorMessage"));
        assertTrue(registrationPage.isFirstNameAccepted()); // must return false
        // BUG
    }

    @Test
    public void testEmptyFirstNameField() {
        homePage.accessRegistrationPage();
        registrationPage.enterFirstName(expectedResult("EmptyFirstNameField"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForFirstName());
        assertEquals(registrationPage.getErrorMessageForInvalidFirstName(), expectedResult("FirstNameErrorMessage"));
        // BUG
    }

    @Test
    public void testValidLastName() {
        homePage.accessRegistrationPage();
        registrationPage.enterLastName(expectedResult("LastName"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isLastNameAccepted());
    }

    @Test
    public void testLastNameWithNumbers() {
        homePage.accessRegistrationPage();
        registrationPage.enterLastName(expectedResult("LastNameWithNumbers"));
        registrationPage.submitForm();
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        assertEquals(actualResult, expectedResult);
        // BUG
    }

    @Test
    public void testLastNameWithSpecialCharacters() {
        homePage.accessRegistrationPage();
        registrationPage.enterLastName(expectedResult("LastNameWithSpecialCharacters"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForLastName());
        // BUG
    }

    @Test
    public void testLastNameWithSpaces() {
        homePage.accessRegistrationPage();
        registrationPage.enterLastName(expectedResult("LastNameWithSpaces"));
        registrationPage.submitForm();
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        assertEquals(actualResult, expectedResult);
        assertFalse(registrationPage.isLastNameAccepted()); // must return false
        // BUG
    }

    @Test
    public void testEmptyLastNameField() {
        homePage.accessRegistrationPage();
        registrationPage.enterLastName(expectedResult("EmptyLastNameField"));
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForLastName());
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = expectedResult("LastNameErrorMessage");
        assertEquals(actualResult, expectedResult);
    }


    @BeforeMethod
    public void accessRegisterPage() {
        homePage = new HomePage(driver);

        registrationPage = new RegistrationPage(driver);
        rightColumnPage = new RegistrationPage(driver);

        System.out.println("Before Method in Register page test accessed ");
    }


    @Test
    public void printAllErrorMessages() {

        registrationPage.submitForm();
        registrationPage.getAllerrorMessageDisplayed();
    }

}
