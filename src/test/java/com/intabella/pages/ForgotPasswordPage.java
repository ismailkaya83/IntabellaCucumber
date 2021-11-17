package com.intabella.pages;

import com.intabella.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{

    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameEmail;

    @FindBy(css = "button[type='submit']")
    public WebElement request;

    @FindBy(css = "a[href='/user/login']")
    public WebElement returnLogin;

}
