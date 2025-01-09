package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends CommonApiTest {
    WebDriver driver;

    // Using PageFactory to locate elements
    @FindBy(linkText = "Contact Us")  // Locator for the Contact Us button
    private WebElement contactUsButton;

    @FindBy(id = "input-name")  // Correct locator for 'name' field
    private WebElement nameField;

    @FindBy(css = "#input-email") // Correct locator for 'email' field
    private WebElement emailField;

    @FindBy(id = "input-enquiry") // Correct locator for 'message' field
    private WebElement messageField;

    @FindBy(css = "input[value='Submit']")
    private WebElement submitButton;

    // Constructor to initialize elements
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action: Click on "Contact Us" link to navigate to the Contact Us page
    public void clickContactUs() {
        contactUsButton.click();
    }

    // New method to fill the form and submit it
    public void submitContactUsForm(String name, String email, String message) {
        enterName(name);
        enterEmail(email);
        enterMessage(message);
        submitForm();
    }

    // Helper methods for each action (entering data and submitting)
    private void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    private void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
    }

    private void submitForm() {
        submitButton.click();
    }

    // Helper method to get any confirmation message after form submission
    public String getConfirmationMessage() {
        // Assuming there's a confirmation message after submission
        return driver.findElement(By.linkText("Contact Us")).getText();
    }
}
