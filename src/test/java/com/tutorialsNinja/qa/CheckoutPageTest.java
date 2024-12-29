package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.sun.source.tree.AssertTree;
import com.tutorialsninja.pa.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest extends CommonApiTest {



    HomePage homePage;
    DesktopsCategoryPage desktopsCategoryPage;
   // PhonesAndPdaCategoryPage phonesAndPdaCategoryPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    OrderPlacedSuccessPage orderPlacedSuccessPage;

    @BeforeMethod
    public void setup2() {
        homePage = new HomePage(driver);
        desktopsCategoryPage = new DesktopsCategoryPage(driver);
       // phonesAndPdaCategoryPage = new PhonesAndPdaCategoryPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage  = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderPlacedSuccessPage = new OrderPlacedSuccessPage(driver);
    }
    @Test
    public void Homepage(){
        homePage.getLogoText();


    }

        @Test
         public void registerNewAccount() {
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
      @Test
       public void login(){
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
          waitFor(40);

      }
     @Test
    public void productPage(){
         homePage.navigateToDesktopsCategory(driver);
         homePage.clickShowAllDesktops();
         desktopsCategoryPage.selectHP_LP3065();
        // phonesAndPdaCategoryPage.selectIphone();
         productPage.addToCart();
         Assert.assertTrue(productPage.isProductAddedToCart());
         productPage.clickShoppingCartButton();
         waitFor(50);


      }
     @Test
    public void cartPage() {
         cartPage.proceedToCheckout();
         Assert.assertTrue(cartPage.isCartPageDisplayed());
         waitFor(2);



     }
     @Test
     public void CheckoutPage() {
         homePage.navigateToDesktopsCategory(driver);
         homePage.clickShowAllDesktops();
         desktopsCategoryPage.selectHP_LP3065();
         // phonesAndPdaCategoryPage.selectIphone();
         productPage.addToCart();
         Assert.assertTrue(productPage.isProductAddedToCart());
         productPage.clickShoppingCartButton();
         productPage.clickChechoutButton();
         waitFor(1);
         checkoutPage.clickGuestCheckout();
         checkoutPage.clickContinueButton();
         checkoutPage.enterFirstName("John");
         checkoutPage.enterLastName("Doe");
         checkoutPage.enterEmail(generateEmail());
         checkoutPage.enterPhoneNumber("12345678");
         checkoutPage.enterCompany("Example Company");
         checkoutPage.enterAddress1("123 Example Street");
         checkoutPage.enterCity("Example City");
         checkoutPage.enterPostcode("12345");
         checkoutPage.selectRegion("Bristol");
         checkoutPage.clickContinueButtonUnderPaymentSection();
        // waitFor(3);
         checkoutPage.clickContinueButtonUnderDeliveryMethod();
         // waitFor(3);
         checkoutPage.checkAgreeToTermsAndConditionsBox();
         checkoutPage.clickContinueButtonUnderPaymentMethod();
         Assert.assertTrue(checkoutPage.isCheckoutComplete(), "Checkout was not completed successfully.");
        // waitFor(50);
         checkoutPage.clickComfirmOrderButton();

         waitFor(05);

         Assert.assertTrue(orderPlacedSuccessPage.isOrderSuccessMessageDisplayed());

         System.out.println(orderPlacedSuccessPage.getSuccessMessageText());

         System.out.println(orderPlacedSuccessPage.checkSuccessUrl(driver));

         Assert.assertTrue(orderPlacedSuccessPage.checkSuccessUrl(driver),"success key word does not exist in the url");


         // Finalize checkout
         //
     }

        }

                    








