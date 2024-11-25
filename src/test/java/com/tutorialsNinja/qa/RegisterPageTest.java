package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import com.tutorialsninja.pa.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends CommonApiTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void accessRegisterPage(){
        HomePage homePage = new HomePage(driver);
        homePage.accessRegisterPage();
        registerPage = new RegisterPage(driver);
        System.out.println("Before Method in Register page test accessed ");
    }

    @Test
    public void setUFirstName(){
        registerPage.setFirstNameField("mohamed");
    }
}
