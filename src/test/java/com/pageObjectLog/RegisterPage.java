package com.pageObjectLog;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * In this model, we have the use of annotations
 * FindBy, FindBys of page factory, to find the page elements
 * and return to us.
 *
 * @author Ezequias Ferreira
 */
public class RegisterPage {

    WebDriverWait wait;

    @FindBy (id = "firstname")
    private WebElement inputFirst;

    @FindBy (id = "lastname")
    private WebElement inputLast;

    @FindBy (id = "userName")
    private WebElement inputUser;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (id = "register")
    private WebElement btnRegister;

    @FindBy (id = "gotologin")
    private WebElement btnBackLogin;

    RegisterPage (WebDriver drv) {
        PageFactory.initElements(drv, this);
        wait = new WebDriverWait(drv,5);
    }

    public void writeFirstName (String first) {
        inputFirst.sendKeys(first);
    }

    public void writeLastName (String last) {
        inputLast.sendKeys(last);
    }

    public void writeUser (String user) {
        inputUser.sendKeys(user);
    }

    public void writePass (String pass) {
        inputPass.sendKeys(pass);
    }

    public void clickBtnRobot () {
        ExpectedCondition<WebElement> conditionRobot = drv -> {
            WebElement labelRobot = drv.findElement(By.id("g-recaptcha"));

            if (labelRobot!=null){
                return labelRobot;
            }
            return null;
        };
        WebElement btnRobot = wait.until(conditionRobot);
        if (btnRobot!=null) {
            btnRobot.click();
        }
    }

    public void clickBtnRegister () {
        btnRegister.click();
    }

    public void clickBtnBack () {
        btnBackLogin.click();
    }
}
