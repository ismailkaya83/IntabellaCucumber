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

public class DashboardStepdefs {

    @Then("the title contains {string}")
    public void theTitleContains(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualSubTitle = new DashboardPage().pageSubTitle.getText();
        Assert.assertEquals(expectedTitle, actualSubTitle);
    }

    @And("the user can see own {string} in profile menu")
    public void theUserCanSeeOwnInProfileMenu(String expectedName) {
        BrowserUtils.waitFor(2);
        String actualName = new DashboardPage().getUserName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Given("the user is on the Dashboard page")
    public void theUserIsOnTheDashboardPage() {

        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login("user1","UserUser123");

    }

    @When("click the profile menu button")
    public void clickTheProfileMenuButton() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.userMenu.click();

    }

    @Then("click the logout button")
    public void clickTheLogoutButton() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.logOutLink.click();

    }


    @When("close all tabs")
    public void closeAllTabs() {

        Driver.closeDriver();
    }
}


