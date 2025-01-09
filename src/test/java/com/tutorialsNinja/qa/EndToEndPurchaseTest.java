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
    public void initializePageObjects() {

        homePage = new HomePage(driver);
        desktopsCategoryPage = new DesktopsCategoryPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testGuestUserEndToEndPurchaseFlow() {
        // Step 1: Navigate to Desktops category
        homePage.navigateToDesktopsCategory(driver);
        homePage.clickShowAllDesktops();

        // Step 2: Select HP LP3065 product
        desktopsCategoryPage.selectHP_LP3065();
        // Step 3: Add product to cart and verify success
        productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCart(), "Product was not added to cart");
        productPage.clickShoppingCartButton();
        // Step 4: Verify Cart and proceed to checkout
        cartPage.proceedToCheckout();
        //Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed");

        // Step 5: Verify checkout page and complete checkout
        checkoutPage.clickGuestCheckout();

        checkoutPage.clickContinueButton();

        checkoutPage.enterFirstName(expectedResult("FirstName"));
        checkoutPage.enterLastName(expectedResult("LastName"));

        checkoutPage.enterEmail(generateEmail());
        checkoutPage.enterPhoneNumber(expectedResult("PhoneNumber"));
        checkoutPage.enterCompany(expectedResult("Company"));
        checkoutPage.enterAddress1(expectedResult("Address1"));
        checkoutPage.enterCity(expectedResult("City"));
        checkoutPage.enterPostcode(expectedResult("Postcode"));
        checkoutPage.selectRegion(expectedResult("Region"));
        checkoutPage.clickContinueButtonUnderPaymentSection();

        checkoutPage.clickContinueButtonUnderDeliveryMethod();

        checkoutPage.checkAgreeToTermsAndConditionsBox();
        checkoutPage.clickContinueButtonUnderPaymentMethod();

        checkoutPage.clickConfirmOrderButton();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout page is not displayed");
        Assert.assertTrue(checkoutPage.isCheckoutComplete());
        checkoutPage.completeCheckout();

    }


}
