package com.nextgate.pages;

import com.nextgate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHomePage {

    WebDriver driver;

    public AccountHomePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='home__heading']")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//strong[text() = 'Data Quality Manager']")
    public WebElement DQM;

    @FindBy(xpath = "//strong[text() = 'Codeset Manager']")
    public WebElement codeset;

    @FindBy(xpath = "//strong[text() = 'REST API Toolkit']")
    public WebElement RestApiToolkit;

}
