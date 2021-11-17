package com.intabella.step_definitions;

import com.intabella.pages.ForgotPasswordPage;
import com.intabella.pages.LoginPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class ForgotStepdefs {

    @And("the user should be able to login Forgot Password page")
    public void theUserShouldBeOnThePage() {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Forgot Password",actualTitle);

    }

}
