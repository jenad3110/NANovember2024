package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HomePageTest extends CommonApiTest {


    HomePage homepage;

    @BeforeMethod
    public void initializePageObjects() {

        homepage = new HomePage(driver);
        System.out.println("Before Method in HomePage test accessed ");
        System.out.println(getClass().getName());
//        System.out.println(HomePageTest.class.getName());
    }

    @Test
    public void testRetrieveAllLinksOnHomePage() {

        homepage.getAllLinksOnHomePage();

    }


    @Test
    public void testHoverOverCurrenciesAndClickUsingActionClass() {

        homepage.hoverOverCurrenciesAndClickUsingActionClass(driver);
    }


    @Test
    public void testClickOnCurrencySection() {

        homepage.clickCurrencySection();
    }

    @Test
    public void testClickOnCurrencyLogo() {

        homepage.clickCurrencyLogo();
    }

    @Test
    public void testClickOnPhoneLogo() {

        homepage.clickPhoneLogo();

    }

    @Test
    public void testClickOnMyAccountLogo() {

        homepage.clickMyAccountButton();
    }

    @Test
    public void testClickOnMyAccountText() {

        homepage.clickMyAccountButton();
    }

    @Test
    public void testClickOnWishListLogo() {

        homepage.clickWishListLogo();
    }

    @Test
    public void testClickOnShoppingCartLogo() {

        homepage.clickShoppingCartLogo();
    }

    @Test
    public void testClickOnShoppingCartText() {

        homepage.clickShoppingCartLogo();
    }

    @Test
    public void testClickOnCheckOutLogo() {

        homepage.clickCheckOutLogo();
    }


    @Test
    public void testHoverOverNavigationBarElements() {

        homepage.hoverOverElementsOnNavigationBar(driver);
    }


    @Test
    public void testPhoneNumberDisplay() {

        String actualPhoneNumber;
        String expectedPhoneNumber = expectedResult("expectedPhoneNumber");
        actualPhoneNumber = homepage.getPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
    }


    @Test
    public void testLogoIsDisplayedAndClickable() {

        homepage.clickLogo();
        String actualLogo = homepage.getLogoText();
        Assert.assertEquals(actualLogo, expectedResult("websiteLogo"));

    }

    @Test
    public void testClickOnCurrencyPoundSign() {

        String expectedPoundSign = expectedResult("expectedPoundSign");
        homepage.clickHiddenCurrencyMenu();
        homepage.clickPoundSIgn();
        String actualSign = homepage.getCurrentCurrency();
        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);


    }

    @Test
    public void testClickOnCurrencyEuroSign() {

        String expectedEuroSign = expectedResult("expectedEuroSign");
        homepage.clickHiddenCurrencyMenu();
        homepage.clickEuroSign();
        String actualSign = homepage.getCurrentCurrency();
        System.out.println(expectedEuroSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

    @Test
    public void testClickOnCurrencyDollarSign() {

        String actualDollarSign = homepage.getDollarSign();
        String expectedDollarSign = expectedResult("expectedDollarSign");
        homepage.clickCurrencyLogo();
        homepage.clickUsDollarSection();
        Assert.assertEquals(actualDollarSign, expectedDollarSign);
    }


    @Test
    public void testAccessRegistrationPage() {

        homepage.accessRegistrationPage();
        Assert.assertTrue(homepage.isRegisterAccountDisplayed());

    }

    @Test
    public void testHoverOverDesktopSection() {

        homepage.hoverOverDesktopSection(driver);
        Assert.assertTrue(homepage.isShowAllDesktopIsDisplayed());


    }

    @Test
    public void testClickShowAllDesktopsUnderDesktopSection() {

        homepage.hoverOverDesktopSection(driver);
        Assert.assertTrue(homepage.isShowAllDesktopIsClickable());
        homepage.clickShowAllDesktops();
        Assert.assertTrue(homepage.desktopsIsDisplayed());


    }
}