package com.nextgate.pages;

import com.mongodb.DBRef;
import com.nextgate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparisonPage {
    WebDriver driver;

    public ComparisonPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[text()=' HEBERT '])[1]")
    public WebElement comparelastname1;

    @FindBy(xpath = "(//div[text()=' HEBERT '])[3]")
    public WebElement comparelastname2;

    @FindBy(xpath = "(//div[text()=' 279-88-4729 '])[1]")
    public WebElement compareSSN1;
    @FindBy(xpath = "(//div[text()=' 279-88-4729 '])[3]")
    public WebElement compareSSN2;

    @FindBy(xpath = "//span[text()='Enterprise Link']")
    public WebElement enterPriseLink;

    @FindBy(xpath = "//span[text()='Mark Unique']")
    public WebElement markUnique;

    @FindBy(xpath = "//span[text()='Show Scores Breakdown']")
    public WebElement showScoreBreakdown;

    @FindBy(xpath = "//span[text()='Comments']")
    public WebElement comments;

    @FindBy(xpath = "//span[text()='Hide empty columns']")
    public WebElement hideEmptyColumns;



}
