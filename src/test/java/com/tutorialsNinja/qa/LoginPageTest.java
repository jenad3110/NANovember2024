package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.HomePage;
import com.tutorialsninja.pa.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonApiTest {



    LoginPage loginPage;


    @Test
    public void test(){



    }



    @BeforeMethod
    public void accessRegisterPage(){
        HomePage homePage = new HomePage(driver);
        homePage.accessLoginPage();
        loginPage = new LoginPage(driver);
        System.out.println("Before Method in LoginPage test accessed ");

    }



}
