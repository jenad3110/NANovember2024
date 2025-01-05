package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest extends CommonApiTest {


    HomePage homePage;
    DesktopsCategoryPage desktopsCategoryPage;
    //    PhonesAndPdaCategoryPage phonesAndPdaCategoryPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderPlacedSuccessPage orderPlacedSuccessPage;

    @BeforeMethod
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        desktopsCategoryPage = new DesktopsCategoryPage(driver);
//        phonesAndPdaCategoryPage = new PhonesAndPdaCategoryPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderPlacedSuccessPage = new OrderPlacedSuccessPage(driver);
    }

    @Test
    public void testRetrieveHomePageLogoText() {
        homePage.getLogoText();
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());


    }

    @Test
    public void testRegisterNewAccount() {
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
        Assert.assertTrue(checkoutPage.isRegistrationSucceed());


    }

    @Test
    public void testLoginWithNewlyRegisteredAccount() {
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
        Assert.assertTrue(homePage.isAccountTextDisplayed());


    }

    @Test
    public void testProductPageAddToCartFunctionality() {
        homePage.navigateToDesktopsCategory(driver);
        homePage.clickShowAllDesktops();
        desktopsCategoryPage.selectHP_LP3065();
        // phonesAndPdaCategoryPage.selectIphone();
        productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCart());
        productPage.clickShoppingCartButton();

    }

    @Test
    public void testCartPageDisplayAndProceedToCheckout() {
        cartPage.proceedToCheckout();
        Assert.assertTrue(cartPage.isCartPageDisplayed());


    }

    @Test
    public void testCheckoutProcess() {
        homePage.navigateToDesktopsCategory(driver);
        homePage.clickShowAllDesktops();
        desktopsCategoryPage.selectHP_LP3065();
        // phonesAndPdaCategoryPage.selectIphone();
        productPage.addToCart();
        Assert.assertTrue(productPage.isProductAddedToCart());
        productPage.clickShoppingCartButton();
        productPage.clickCheckoutButton();

        checkoutPage.clickGuestCheckout();
        checkoutPage.clickContinueButton();

        checkoutPage.enterFirstName(expectedResult("FirstName"));
        checkoutPage.enterLastName(expectedResult("LastName"));
        checkoutPage.enterEmail(generateEmail());
        checkoutPage.enterPhoneNumber(expectedResult("PhoneNumber"));
        checkoutPage.enterCompany(expectedResult("Company"));
        checkoutPage.enterAddress1(expectedResult("Address1"));
        checkoutPage.enterCity("Example City");
        checkoutPage.enterPostcode(expectedResult("Postcode"));
        checkoutPage.selectRegion(expectedResult("Region"));
        checkoutPage.clickContinueButtonUnderPaymentSection();

        checkoutPage.clickContinueButtonUnderDeliveryMethod();

        checkoutPage.checkAgreeToTermsAndConditionsBox();
        checkoutPage.clickContinueButtonUnderPaymentMethod();

        Assert.assertTrue(checkoutPage.isCheckoutComplete(), "Checkout was not completed successfully.");
        checkoutPage.clickConfirmOrderButton();

        Assert.assertTrue(orderPlacedSuccessPage.isOrderSuccessMessageDisplayed());

        System.out.println(orderPlacedSuccessPage.getSuccessMessageText());

        System.out.println(orderPlacedSuccessPage.checkSuccessUrl(driver));

        //Assert.assertTrue(orderPlacedSuccessPage.checkSuccessUrl(driver), "success key word does not exist in the url");
        Assert.assertTrue(orderPlacedSuccessPage.checkSuccessUrl(driver), "success key word exist in the url");


    }

}

                    








