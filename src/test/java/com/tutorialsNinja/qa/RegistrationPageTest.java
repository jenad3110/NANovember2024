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
    String actualResult;
    String expectedResult;
    /*


    @Test
    public void registerNewUser() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterEmail("johndoe@example.com");
        registrationPage.enterTelephone("1234567890");
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password123");
        registrationPage.agreeToPrivacyPolicy();
        registrationPage.clickContinue();

        waitFor(10);
    }


    @Test
    public void testRightColumnDisplayed() {
        assertTrue(rightColumnPage.isColumnRightDisplayed());
    }

    @Test
    public void testMyAccountLink() {
        assertTrue(rightColumnPage.isMyAccountLinkDisplayed());
        rightColumnPage.clickMyAccountLink();
        // Add additional assertions to verify the result after clicking
    }


    @Test
    public void testPasswordLink() {
        assertTrue(rightColumnPage.isForgottenPasswordLinkDisplayed());
        rightColumnPage.clickPasswordLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testAddressBookLink() {
        assertTrue(rightColumnPage.isAddressBookLinkDisplayed());
        rightColumnPage.clickAddressBookLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testWishListLink() {
        assertTrue(rightColumnPage.isWishListLinkDisplayed());
        rightColumnPage.clickWishListLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testOrderHistoryLink() {
        assertTrue(rightColumnPage.isOrderHistoryLinkDisplayed());
        rightColumnPage.clickOrderHistoryLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testDownloadsLink() {
        assertTrue(rightColumnPage.isDownloadsLinkDisplayed());
        rightColumnPage.clickDownloadsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testRecurringPaymentsLink() {
        assertTrue(rightColumnPage.isRecurringPaymentsLinkDisplayed());
        rightColumnPage.clickRecurringPaymentsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testRewardPointsLink() {
        assertTrue(rightColumnPage.isRewardPointsLinkDisplayed());
        rightColumnPage.clickRewardPointsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testReturnsLink() {
        assertTrue(rightColumnPage.isReturnsLinkDisplayed());
        rightColumnPage.clickReturnsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testTransactionsLink() {
        assertTrue(rightColumnPage.isTransactionsLinkDisplayed());
        rightColumnPage.clickTransactionsLink();
        // Add additional assertions to verify the result after clicking
    }

    @Test
    public void testNewsletterLink() {
        assertTrue(rightColumnPage.isNewsletterLinkDisplayed());
        rightColumnPage.clickNewsletterLink();
        // Add additional assertions to verify the result after clicking
    }
*/

    // testing firstName Field

    @Test
    public void testValidFirstName() {
        registrationPage.enterFirstName("John");
        registrationPage.submitForm();
        assertTrue(registrationPage.isFirstNameAccepted());
    }

    @Test
    public void testFirstNameWithNumbers() {
        registrationPage.enterFirstName("John123");
        registrationPage.submitForm();
        actualResult= registrationPage.getErrorMessageForInvalidFirstName();
        expectedResult = expectedResult("FirstNameErrorMessage");
        assertEquals(actualResult,expectedResult);
        // bug must return error message


    }

    @Test
    public void testFirstNameWithSpecialCharacters() {
        registrationPage.enterFirstName("John@Doe");
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForFirstName());
    }

    @Test
    public void testFirstNameWithSpaces() {
        registrationPage.enterFirstName("John Doe");
        registrationPage.submitForm();
        assertEquals(registrationPage.getErrorMessageForInvalidFirstName(),expectedResult("FirstNameErrorMessage"));
        assertTrue(registrationPage.isFirstNameAccepted()); // must return false
        // BUG
    }

    @Test
    public void testEmptyFirstNameField() {
        registrationPage.enterFirstName("");
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForFirstName());
        assertEquals(registrationPage.getErrorMessageForInvalidFirstName(),expectedResult("FirstNameErrorMessage"));
        //BUG
    }

    @Test
    public void testValidLastName() {
        registrationPage.enterLastName("Doe");
        registrationPage.submitForm();
        assertTrue(registrationPage.isLastNameAccepted());
    }

    @Test
    public void testLastNameWithNumbers() {
        registrationPage.enterLastName("Doe123");
        registrationPage.submitForm();
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        assertEquals(actualResult, expectedResult);
        //BUG
    }

    @Test
    public void testLastNameWithSpecialCharacters() {
        registrationPage.enterLastName("Doe@Doe");
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForLastName());
        //BUG
    }

    @Test
    public void testLastNameWithSpaces() {
        registrationPage.enterLastName("Doe Smith");
        registrationPage.submitForm();
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = "Last Name must be between 1 and 32 characters!";
        assertEquals(actualResult, expectedResult);
        assertFalse(registrationPage.isLastNameAccepted()); // must return false
        //BUG
    }

    @Test
    public void testEmptyLastNameField() {
        registrationPage.enterLastName("");
        registrationPage.submitForm();
        assertTrue(registrationPage.isErrorDisplayedForLastName());
        String actualResult = registrationPage.getErrorMessageForInvalidLastName();
        String expectedResult = expectedResult("LastNameErrorMessage");
        assertEquals(actualResult, expectedResult);
    }




















    @BeforeMethod
    public void accessRegisterPage(){
        HomePage homePage = new HomePage(driver);
        homePage.accessRegisterPage();
        registrationPage = new RegistrationPage(driver);
        rightColumnPage = new RegistrationPage(driver);

        System.out.println("Before Method in Register page test accessed ");
    }



}
