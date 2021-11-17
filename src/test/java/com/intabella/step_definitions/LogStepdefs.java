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

public class LogStepdefs {

    String currentUrl;

    @Given("the user is on the login page")
    public void theUserLoggedInAs() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
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

    @And("the user should not be able to login")
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
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("the user clicks on the Forgot your password? link")
    public void theUserClicksOnTheLink() {
        new LoginPage().forgotPassword.click();
    }

    @When("the user can see link")
    public void theUserCanSeeLink() {
        Assert.assertEquals("Remember me on this computer",new LoginPage().rememberClick.getText());
    }

    @And("the link should be clickable")
    public void theLinkShouldBeClickable() {
        Assert.assertTrue(new LoginPage().rememberClick.isEnabled());
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
        Assert.assertEquals("password",loginPage.passWord.getAttribute("type"));
    }

    @Then("click the back button")
    public void clickTheBackButton() {
        Driver.get().navigate().back();
    }

    @Then("open browser again with same url")
    public void openBrowserAgainWithSameUrl() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
}
