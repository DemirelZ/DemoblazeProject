package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    public WebElement inputUsername_loc;

    @FindBy(id = "loginpassword")
    public WebElement inputPassword_loc;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn_loc;






    public void login_mtd(){

        homeLoginBtn_loc.click();
        BrowserUtils.waitFor(2);
        inputUsername_loc.sendKeys(ConfigurationReader.get("username"));
        inputPassword_loc.sendKeys(ConfigurationReader.get("password"));
        loginBtn_loc.click();
        BrowserUtils.waitFor(2);


    }

    public void login_mtd(String username, String password){
        homeLoginBtn_loc.click();
        BrowserUtils.waitFor(2);
        inputUsername_loc.sendKeys(username);
        inputPassword_loc.sendKeys(password);
        loginBtn_loc.click();
        BrowserUtils.waitFor(2);


    }

    public void verifyNegativePopUpMessage(String expectedMessage){

        Alert alert= Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals("Negative Test Message DOES NOT match",expectedMessage,actualMessage);

    }




}
