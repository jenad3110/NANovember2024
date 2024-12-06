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
    public void initializeObjectsInTheClass() {

        homepage = new HomePage(driver);
        System.out.println("Before Method in HomePage test accessed ");
        System.out.println(getClass().getName());
    }

    @Test
    public void getAllLinks(){

        homepage.getAllLinksOnHomePage();

    }



    @Test
    public void hoverOverCurrencies() {

        homepage.hoverOverCurrenciesAndClickUsingActionClass(driver);
  }


    @Test
    public void clickOnCurrencyText() {

        homepage.clickCurrencySection();
    }

    @Test
    public void clickOnCurrencyLogo() {

       homepage.clickCurrencyLogo();
    }

    @Test
    public void clickOnPhoneLogo() {

        homepage.clickPhoneLogo();

    }

    @Test
    public void clickOnMyAccountLogo() {

        homepage.clickMyAccountButton();
    }

    @Test
    public void clickOnMyAccountText() {

        homepage.clickMyAccountButton();
    }

    @Test
    public void clickOnWishListLogo() {

        homepage.clickWishListLogo();
    }

    @Test
    public void clickOnShoppingCartLogo() {

        homepage.clickShoppingCartLogo();
    }

    @Test
    public void clickOnShoppingCartText() {

        homepage.clickShoppingCartLogo();
    }

    @Test
    public void clickOnCheckOutLogo() {

        homepage.clickCheckOutLogo();
    }


    @Test
    public void hoverOverElementOnNavigationBar() {

        homepage.hoverOverElementsOnNavigationBar(driver);
    }


    @Test
    public void phoneNumberIsDisplayed() {

        String actualPhoneNumber;
        String expectedPhoneNumber = expectedResult("expectedPhoneNumber");
        actualPhoneNumber = homepage.getPhoneNumber();
        Assert.assertEquals(actualPhoneNumber,expectedPhoneNumber );
    }


    @Test
    public void LogoIsDisplayedAndClickable () {

        homepage.clickLogo();
        String actualLogo = homepage.getLogoText();
        Assert.assertEquals(actualLogo,expectedResult("websiteLogo"));

    }

    @Test
    public void clickOnCurrencyPoundSign() {

        String expectedPoundSign = expectedResult("expectedPoundSign");
        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();
        System.out.println(expectedPoundSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

    @Test
    public void clickOnCurrencyEuroSign() {

        String expectedEuroSign = expectedResult("expectedEuroSign");
        driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[1]/button")).click();
        String actualSign = driver.findElement(By.xpath("//*[@class='btn-group']/button/strong")).getText();
        System.out.println(expectedEuroSign.equalsIgnoreCase(actualSign));
        System.out.println(actualSign);
    }

    @Test
    public void clickOnCurrencyDollarSign() {


        String actualDollarSign = homepage.getDollarSign();
        String expectedDollarSign = expectedResult("expectedDollarSign");
        homepage.clickCurrencyLogo();
        homepage.clickUsDollarSection();
        Assert.assertEquals(actualDollarSign,expectedDollarSign);
    }


    @Test
    public void accessRegisterPage(){

        homepage.accessRegistrationPage();
    }

    @Test
    public void hoverOverDesktopSection(){

        homepage.hoverOverDesktopSection(driver);

    }

    @Test
    public void clickShowAllDesktopsUnderDesktopSection(){

        homepage.hoverOverDesktopSection(driver);
        homepage.clickShowAllDesktops();

        //---> next page desktop product page
    }

}
