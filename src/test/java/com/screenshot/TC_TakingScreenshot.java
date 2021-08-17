package com.screenshot;

import com.pageObjectLog.BaseClassTest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TC_TakingScreenshot {

    WebDriver driver;

    @Test
    void takingScreen () {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        takingScreenshot("homepage.png");
        driver.findElement(By.cssSelector(".banner-image")).click();

        takingScreenshot("clickBanner.png");
        driver.quit();
    }

    private void takingScreenshot(String nameFile) {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot, new File("C:\\temp\\"+nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
