package com.tutorialsNinja.qa;

import Base.CommonApiTest;
import com.tutorialsninja.pa.ExplicitWait;
import org.testng.annotations.Test;

public class ExplicitWaitTest extends CommonApiTest {



    @Test
    public void scrollToFooterOfThePage(){

        ExplicitWait explicitWait = new ExplicitWait(driver);
        explicitWait.scrollToBottomOnTHeHomePage();
        //explicitWait.clickNewsLetter();
        waitFor(5);
    }


    @Test
    public void scrollToTheEnd(){
        ExplicitWait explicitWait = new ExplicitWait(driver);
        explicitWait.navigateToSwappaAndScrollToTheBottomOfThePage();

    }



}
