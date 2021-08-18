package com.pageObjectLog;

import static org.testng.Assert.*;

import com.loglearn.utility.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1_LoginPage extends BaseClassTest {

    LoginBook lb;

    @BeforeMethod
    void initingTestCase () {
        Log.info("Navigating to PageLogin");
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        lb = new LoginBook(driver);
    }

    @Test (priority = 1)
    void loginWithoutRegister () {
        Log.initTestCase("loginWithoutRegister");
        //Invalid username and password
        sessionLogin("user", "admin");

        String urlFailed = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/login", urlFailed);
        Log.finishTestCase("loginWithoutRegister");
    }

    //carlin - Admin3212# (Register created earlier)
    @Test (priority = 2)
    void loginSuccessful ()  {
        Log.initTestCase("loginSuccessful");
        sessionLogin("carlin", "Admin3212#");

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains("/profile"));

        String urlSuccess = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/profile", urlSuccess);
        Log.finishTestCase("loginSuccessful");
    }

    private void sessionLogin (String us, String pas) {
        Log.info("Writing the input user");
        lb.writeUser(us);
        Log.info("Writing the input pass");
        lb.writePass(pas);
        Log.info("Clicking in the login button");
        lb.clickBtnLogin();
    }

}
