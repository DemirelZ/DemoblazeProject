package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{


    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_loc;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    public WebElement addToCart_loc;


    public void verifLogin_mtd(String expectedUsername){

        String actualUsername = welcomeUsername_loc.getText();
        Assert.assertEquals("User does NOT match",expectedUsername,actualUsername);
        System.out.println(expectedUsername);
        System.out.println(actualUsername);


    }

    public void addProduct_mtd(String product, String categorie){

        WebElement categoryModul = Driver.get().findElement(By.xpath("//a[.='" + categorie + "']"));
        BrowserUtils.waitForClickablility(categoryModul,5).click();
        WebElement productItem = Driver.get().findElement(By.xpath("//a[.='" + product + "']"));
        BrowserUtils.scrollToElement(productItem);
        BrowserUtils.waitForClickablility(productItem,5).click();
        BrowserUtils.waitFor(2);
        addToCart_loc.click();
        BrowserUtils.waitFor(2);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
        BrowserUtils.waitForClickablility(homeLink_loc,5).click();
        BrowserUtils.waitFor(2);
    }

}
