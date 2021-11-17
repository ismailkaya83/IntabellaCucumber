package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".oro-subtitle")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu")
    public WebElement userMenu;

    @FindBy(xpath ="//a[normalize-space()='Logout']")
    public WebElement logOutLink;



    public String getPageSubTitle() {
        waitUntilLoaderScreenDisappear();
        return pageSubTitle.getText();
    }

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userMenu, 5);
        return userMenu.getText();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userMenu);
        BrowserUtils.clickWithJS(logOutLink);
    }

}
