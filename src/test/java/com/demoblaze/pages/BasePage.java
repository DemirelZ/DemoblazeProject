package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//a[@id='login2']")
    public WebElement homeLoginBtn_loc;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement homeLink_loc;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    public WebElement cart_loc;





}


/*

kendisinden bir obje olluşturulmasın diye abstract yaptık

 */