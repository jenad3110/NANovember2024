package com.tutorialsNinja.qa;

import com.tutorialsninja.pa.ContactUsPage;
import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsTest extends CommonApiTest {

    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void setUp() {
        // ARRANGE: Initialize the page object
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(priority = 1)
    public void testContactUsFormSubmission() {
        // ARRANGE: Prepare test data
        String name = "John Doe";
        String email = "john.doe@example.com";
        String message = "This is a test message bla bla bla ";

        // ACT: Submit the form using the page object method
        contactUsPage.clickContactUs(); // Navigate to the Contact Us page
        contactUsPage.submitContactUsForm(name, email, message); // Fill the form and submit it

        // ASSERT: Verify the confirmation message after form submission
        String confirmationMessage = contactUsPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Contact Us", "The confirmation message is incorrect.");
    }

    @Test(priority = 2)
    public void testContactUsFormWithoutRequiredFields() {
        // ARRANGE: Prepare empty test data (to simulate invalid submission)
        String emptyName = "";
        String emptyEmail = "";
        String emptyMessage = "";

        // ACT: Submit the form with empty fields
        contactUsPage.clickContactUs(); // Navigate to the Contact Us page
        contactUsPage.submitContactUsForm(emptyName, emptyEmail, emptyMessage); // Fill the form with empty values

        // ASSERT: Verify the error message after invalid form submission
        String errorMessage = driver.findElement(By.cssSelector(".text-danger")).getText();
        Assert.assertTrue(errorMessage.contains("Name must be between 3 and 32 character!"), "Error message is not as expected.");
    }

    @Test(priority = 3)
    public void tearDown() {
        // Cleanup after test execution
        driver.quit();
    }
}
