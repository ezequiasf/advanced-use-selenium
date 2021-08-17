package com.pageObjectLog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * In this page object model, i make in a more directly way
 * utilizing the By object.
 *
 * @author Ezequias Ferreira
 */
public class LoginBook {

    WebDriver driver;

    private By inputUser = By.id("userName");
    private By inputPass = By.id("password");
    private By btnLogin = By.id("login");
    private By btnRegister = By.id("newUser");

    public LoginBook (WebDriver drv) {
        driver = drv;
    }

    public void writeUser (String username) {
        driver.findElement(inputUser).sendKeys(username);
    }

    public void writePass (String pass) {
        driver.findElement(inputPass).sendKeys(pass);
    }

    public void clickBtnLogin () {
        driver.findElement(btnLogin).click();
    }

    public void clickBtnRegister () {
        driver.findElement(btnRegister).click();
    }
}
