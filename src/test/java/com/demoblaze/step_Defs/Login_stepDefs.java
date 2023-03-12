package com.demoblaze.step_Defs;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_stepDefs {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        loginPage.login_mtd();

    }

    @Then("Verify {string}")
    public void verify(String accountName) {

        productPage.verifLogin_mtd(accountName);

    }

    @When("The user enters {string} and {string} and click login button")
    public void the_user_enters_and_and_click_login_button(String username, String password) {


        loginPage.login_mtd(username, password);

    }

    @When("The user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword(Map<String, String> info) {

        loginPage.login_mtd(info.get("username"), info.get("password"));

    }

    @Then("Verify that invalid {string}")
    public void verifyThatInvalid(String invalidMessage) {

        loginPage.verifyNegativePopUpMessage(invalidMessage);

    }
}
