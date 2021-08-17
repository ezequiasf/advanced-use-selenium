package com.pageObjectLog;

import com.loglearn.utility.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC2_RegisterPage extends BaseClassTest{

    RegisterPage rp;

    @BeforeMethod
    void initSetupRegister () {
        driver.get("https://demoqa.com/register");
        driver.manage().window().maximize();
        rp = new RegisterPage(driver);
    }

    @Test
    void verifyPasswordIsRight () {
        Log.initTestCase("verifyPasswordIsRight");
        Log.info("Writing the first name");
        rp.writeFirstName("xerox");
        Log.info("Writing the last name");
        rp.writeLastName("paper");
        Log.info("Writing the user");
        rp.writeUser("xerocado");

        //Writing password that is doesn't accept
        Log.info("Writing a password wrong");
        rp.writePass("admin5");

        //Scrolling the page using javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        //Click in recaptcha button
        rp.clickBtnRobot();
        Log.info("Btn robot clicked");

        rp.clickBtnRegister();
        Log.info("Btn register clicked");

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/register", url);
        Log.finishTestCase("verifyPasswordIsRight");
    }
}
