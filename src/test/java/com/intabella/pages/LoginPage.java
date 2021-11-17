package com.intabella.pages;

import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userName;

    @FindBy(id = "prependedInput2")
    public WebElement passWord;

    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement rememberClick;

    @FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
    public WebElement forgotPassword;

    public void login(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        login.click();
    }

    public void setRememberClick(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(rememberClick);

    }
}
