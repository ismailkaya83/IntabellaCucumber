package com.intabella.utilities;

import com.intabella.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class test {
    @Test
    public void test(){

        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login("user1","UserUser123");
        Driver.closeDriver();

        Driver.get().get(ConfigurationReader.get("url"));
    }


}
