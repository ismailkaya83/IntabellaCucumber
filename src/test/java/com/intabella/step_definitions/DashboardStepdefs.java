package com.intabella.step_definitions;

import com.intabella.pages.DashboardPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DashboardStepdefs {

    @Then("the title contains {string}")
    public void theTitleContains(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualSubTitle = new DashboardPage().pageSubTitle.getText();
        Assert.assertEquals(expectedTitle,actualSubTitle);
    }

    @And("the user can see own {string} in profile menu")
    public void theUserCanSeeOwnInProfileMenu(String expectedName) {
        BrowserUtils.waitFor(2);
        String actualName = new DashboardPage().getUserName();
        Assert.assertEquals(expectedName,actualName);
    }
}
