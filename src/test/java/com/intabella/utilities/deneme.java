package com.intabella.utilities;

import com.intabella.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class deneme {

    String currentUrl;

    @Test
    public void deneme() {

        Driver.get().get(ConfigurationReader.get("url"));

        new LoginPage().login("user1","UserUser123");

        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

        currentUrl = Driver.get().getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        Driver.closeDriver();

        Driver.get().get(currentUrl);

        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

        System.out.println("Driver.get().getTitle().equals(\"Dashboard\") = " + Driver.get().getTitle().equals("Dashboard"));

    }

    @Test
    public void test2() {

        Driver.get().get(ConfigurationReader.get("url"));

        System.out.println("Driver.get().toString() = " + Driver.get().toString());

        Driver.closeDriver();

        System.out.println("Driver.get().toString() = " + Driver.get().toString());

        System.out.println("Driver.get().getWindowHandle() = " + Driver.get().getWindowHandle());

        System.out.println("Driver.get().toString().contains(\"null\") = " + Driver.get().toString().contains("null"));
    }
}
