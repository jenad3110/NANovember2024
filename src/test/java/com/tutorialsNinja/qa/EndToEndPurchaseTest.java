package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndPurchaseTest extends CommonApiTest {


    HomePage homePage;
    DesktopsCategoryPage desktopsCategoryPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {


        // Initialize page objects
        homePage = new HomePage(driver);
        desktopsCategoryPage = new DesktopsCategoryPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testEndToEndPurchaseAsAGuest() {
        // Step 1: Navigate to Desktops category
        homePage.navigateToDesktopsCategory(driver);
        homePage.clickShowAllDesktops();
        waitFor(1);
        // Step 2: Select HP LP3065 product
        desktopsCategoryPage.selectHP_LP3065();
        // Step 3: Add product to cart and verify success
        productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCart(), "Product was not added to cart");
        productPage.clickShoppingCartButton();

        // Step 4: Verify Cart and proceed to checkout
        cartPage.proceedToCheckout();
        //Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed");
        waitFor(1);
        // Step 5: Verify checkout page and complete checkout
        checkoutPage.clickGuestCheckout();
        waitFor(1);
        checkoutPage.clickContinueButton();
        waitFor(2);
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        waitFor(50);
        checkoutPage.enterEmail(generateEmail());
        checkoutPage.enterPhoneNumber("12345678");
        checkoutPage.enterCompany("Example Company");
        checkoutPage.enterAddress1("123 Example Street");
        checkoutPage.enterCity("Example City");
        checkoutPage.enterPostcode("12345");
        checkoutPage.selectRegion("Bristol");
        checkoutPage.clickContinueButtonUnderPaymentSection();
        waitFor(2);
        checkoutPage.clickContinueButtonUnderDeliveryMethod();
        checkoutPage.clickContinueButtonUnderPaymentMethod();
        checkoutPage.completeCheckout();

        //Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout page is not displayed");
        waitFor(30);
        // Additional checkout flow verification can be added here

        // Close browser
        driver.quit();
    }

    @Test
    public void testEnterPaymentAddressInformation() {
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterCompany("Example Company");
        checkoutPage.enterAddress1("123 Example Street");
        checkoutPage.enterCity("Example City");
        checkoutPage.enterPostcode("12345");
        checkoutPage.selectRegion("Bristol");
        checkoutPage.clickContinueButtonUnderPaymentSection();

        // Add assertions as needed to verify the input
    }

}
