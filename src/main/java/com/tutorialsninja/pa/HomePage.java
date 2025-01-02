
package com.tutorialsninja.pa;

import Base.CommonApiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends CommonApiTest {


    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    // Web Elements
    @FindBy(xpath = "//*[@id='form-currency']/div/button/span")
    WebElement currencySection;

    @FindBy(xpath = "//*[@id='form-currency']/div/button/strong")
    WebElement currencyLogo;

    @FindBy(xpath = "//*[@class='hidden-xs hidden-sm hidden-md']")
    WebElement hiddenCurrencyMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[2]/button")
    WebElement poundSign;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[1]/button")
    WebElement euroSign;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[3]/button")
    WebElement dollarSign;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[1]/a")
    WebElement phoneLogo;

    @FindBy(tagName = "a")
    List<WebElement> links;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[1]/span")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id='logo']")
    WebElement logo;

    @FindBy(xpath = "//*[@class='list-inline']/li[3]/a/i")
    WebElement wishListLogo;

    @FindBy(xpath = "//*[@class='list-inline']/li[3]/a")
    WebElement wishListText;

    @FindBy(xpath = "//*[@class='list-inline']/li[4]/a/i")
    WebElement shoppingCartLogo;

    @FindBy(xpath = "//*[@class='list-inline']/li[4]/a")
    WebElement shoppingCartText;

    @FindBy(xpath = "//*[@class='list-inline']/li[5]/a/i")
    WebElement checkOutLogo;

    @FindBy(xpath = "//*[@class='list-inline']/li[5]/a")
    WebElement checkOutText;

    @FindBy(xpath = "//*[@id='menu']/div[2]/ul")
    WebElement navigationBar;

    @FindBy(xpath = "//*[@class='dropdown']/a/span")
    WebElement myAccountText;

    @FindBy(xpath = "//*[@class='btn-group']/button/strong")
    WebElement currentCurrency;

    @FindBy(xpath = "//*[@id='form-currency']/div/ul/li[3]/button")
    WebElement usDollarSection;

    @FindBy(linkText = "Register")
    WebElement registerButton;

    @FindBy(xpath = "//*[@class='dropdown']/a/i")
    WebElement myAccountButton;

    @FindBy(linkText = "Login")
    WebElement loginButton;

    @FindBy(linkText = "Desktops")
    WebElement desktopsDropdown;

    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDesktops;


    // Methods to interact with elements

    public void clickCurrencySection() {
        currencySection.click();

    }

    public void clickCurrencyLogo() {
        currencyLogo.click();

    }

    public void clickPhoneLogo() {
        phoneLogo.click();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickWishListLogo() {
        wishListLogo.click();
    }

    public String getWishListText() {
        return wishListText.getText();
    }

    public void clickShoppingCartLogo() {
        shoppingCartLogo.click();
    }

    public String getShoppingCartText() {
        return shoppingCartText.getText();
    }

    public void clickCheckOutLogo() {
        checkOutLogo.click();
    }

    public String getCheckOutText() {
        return checkOutText.getText();
    }

    public void clickNavigationBar() {
        navigationBar.click();
    }

    public String getMyAccountText() {
        return myAccountText.getText();
    }

    public String getLogoText() {
        return logo.getText();
    }

    public String getDollarSign() {
        return dollarSign.getText();
    }

    public void clickCurrentCurrency() {
        currentCurrency.click();
    }

    public String getCurrencyText() {
        return currencySection.getText();
    }

    public void clickPoundSIgn() {
        poundSign.click();
    }

    public void clickUsDollarSection() {
        usDollarSection.click();
    }

    public void clickRegisterButton() {

        registerButton.click();
    }

    public void clickMyAccountButton() {

        myAccountButton.click();
    }

    public void clickLoginButton() {

        loginButton.click();
    }

    public void getAllLinksOnHomePage() {

        for (WebElement element : links)
            System.out.println(element.getAttribute("href"));
    }


    public void hoverOverElementsOnNavigationBar(WebDriver driver) {

        Actions action = new Actions(driver);

        List<WebElement> allElements = navigationBar.findElements(By.tagName("li"));

        for (WebElement element : allElements) {
            System.out.println(element.getText());
            action.moveToElement(element).build().perform();
        }
    }


    public void accessRegistrationPage() {
        clickMyAccountButton();
        clickRegisterButton();
    }


    public void hoverOverCurrenciesAndClickUsingActionClass(WebDriver driver) {

        Actions action = new Actions(driver);
        action.moveToElement(currencySection);
        action.click();
        action.build().perform();
        waitFor(5);

    }

    public void accessLoginPage() {
        clickMyAccountButton();
        clickLoginButton();
    }


    public void hoverOverDesktopSection(WebDriver driver) {


        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsDropdown).build().perform();

    }

    public void clickShowAllDesktops() {

        showAllDesktops.click();

    }


    public void navigateToDesktopsCategory(WebDriver driver) {
        hoverOverDesktopSection(driver);
        //  showAllDesktops.click();
    }


}