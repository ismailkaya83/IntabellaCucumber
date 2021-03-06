package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.ConfigurationReader;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

public class LogStepdefs {

    String currentUrl;

    @Given("the user opens the login page")
    public void theUserLoggedInAs() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);
    }

    @Then("the user copies the url and logs out")
    public void theUserCopiesTheUrlAndLogsOut() {
        BrowserUtils.waitFor(3);
        currentUrl = Driver.get().getCurrentUrl();
        new DashboardPage().logOut();
    }

    @Then("the user tries to login by pasting the same url in the browser")
    public void theUserTriesToLoginByPastingTheSameUrlInTheBrowser() {
        BrowserUtils.waitFor(3);
        System.out.println(currentUrl);
        Driver.get().navigate().to(currentUrl);
    }

    @And("the user is also on the login page")
    public void theUserShouldNotBeAbleToLogin() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains("Login"));
    }

    @Then("the user tries to login by clicking back button")
    public void theUserTriesToLoginByClickingBackButton() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();
    }


    @Then("the following {string} should be displayed")
    public void theFollowingShouldBeDisplayed(String expectedMessage) {
        String actualMessage = Driver.get().findElement(By.cssSelector(".alert.alert-error")).getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user clicks on the Forgot your password? link")
    public void theUserClicksOnTheLink() {

        new LoginPage().forgotPassword.click();
    }

    @When("the user can click link")
    public void theUserCanSeeLink() {
        new LoginPage().setRememberClick();
    }

    @And("the link should be clickable")
    public void theLinkShouldBeClickable() {
        Assert.assertTrue(new LoginPage().rememberClick.isSelected());
    }

    @When("write a valid {string} in username inputbox and hit Enter button")
    public void writeAValidInUsernameInputboxAndHitEnterButton(String username) {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(username);
        loginPage.userName.sendKeys(Keys.ENTER);
    }

    @Then("write a valid {string} in password inputbox and hit Enter button")
    public void writeAValidInPasswordInputboxAndHitEnterButton(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.passWord.sendKeys(password);
        loginPage.passWord.sendKeys(Keys.ENTER);
    }

    @When("write anything in password inputbox")
    public void writeAnythingInPasswordInputbox() {
        LoginPage loginPage = new LoginPage();
        loginPage.passWord.sendKeys("password");
    }

    @And("verify it is masked or not")
    public void verifyItIsMaskedOrNot() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals("password", loginPage.passWord.getAttribute("type"));
    }

    @And("click the back button")
    public void clickTheBackButton() {
        Driver.get().navigate().back();
    }



    @When("close all tabs")
    public void closeAllTabs() {
        currentUrl = Driver.get().getCurrentUrl();
        Driver.closeDriver();
    }

    @And("open browser again with same url")
    public void openBrowserAgainWithSameUrl() {
        System.out.println("currentUrl = " + currentUrl);

        Driver.get().get(currentUrl);
    }

    @Then("verify it is not dashboard page")
    public void verifyItIsDashboardPageOrNot() {

        Assert.assertFalse("Dashboard",Driver.get().getTitle().equals("Dashboard"));

    }

    @Then("verify it is login page")
    public void verifyItIsLoginPage() {

        Assert.assertTrue("Login",Driver.get().getTitle().equals("Login"));

    }
}
