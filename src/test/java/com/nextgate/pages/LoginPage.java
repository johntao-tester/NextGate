package com.nextgate.pages;

import com.nextgate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Username")
    public WebElement userNameInputField;

    @FindBy(xpath = "//input[@data-nxg-testid = 'login.password']")
    public WebElement passwordInputField;

    @FindBy(name = "LoginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text() = 'The username or password is invalid.']")
    public WebElement errorMessage;

    @FindBy(css = "#adminIcon")
    public WebElement adminIcon;

    @FindBy(xpath = "(//span[text()='Logout'])[1]")
    public WebElement logout;



}
