package com.pageObjectLog;

import com.loglearn.utility.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassTest {

    public WebDriver driver;

    //In other samples, i will make models more generics than that!
    @BeforeClass
    void initSetup () {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        //Configuring the log file
        DOMConfigurator.configure("log4j.xml");
        Log.info("File log4j.xml configured");
    }

    @AfterClass
    void tearDown () {
        Log.info("Tear down.....");
        driver.quit();
    }
}
