package com.nextgate.pages;

import com.nextgate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateGroupPage {

    WebDriver driver;

    public DuplicateGroupPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[text() =' NORMAN HEBERT | LEONARD HEBERT ']")
    public WebElement targetDupGroup;

    @FindBy(xpath = "//button[@ng-disabled ='formCtrl.loading || dqmSearchForm.$invalid']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='Person Potential Duplicates']")
    public WebElement PersonPotentialDuplicates;

    @FindBy(xpath = "//button[@class ='btn btn-primary ng-binding ng-scope']")
    public WebElement compareButton;




}
