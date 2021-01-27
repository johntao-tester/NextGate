package com.nextgate.pages;

import com.nextgate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataQualityManagerPage {
    WebDriver driver;

    public DataQualityManagerPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

////*[@id="nxg-dqm-app-container"]/div/section[2]/nxg-dqm-form/form/div/div[1]/div/button/span[2]
    @FindBy(xpath = "//span[text()='Person Demographics']")
    public WebElement personDemographics;

    @FindBy(xpath = "//span[text()='Person ID']")
    public WebElement PersonId;



    @FindBy(xpath = "//span[text()='Person Potential Duplicates']")
    public WebElement searchDuplicatesButton;

    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder = 'Last Name']")
    public WebElement lastNameField;

    @FindBy(css = "button[class='search-form__btn search-form__btn--search-btn btn']")
    public WebElement searchButton;

    @FindBy(css = "b[data-nxg-testid = 'dqmsearch.results.personNames.1000004798']")
    public WebElement elizabethSmith;

    @FindBy(css = "span[data-nxg-testid = 'dqmsearch.results.euidNumber.1000004798']")
    public WebElement EUID1000004798;

    @FindBy(css = "input[ng-if='!fieldCtrl.byService']")
    public WebElement idField;

    //Record details

    @FindBy(css = "h2[data-nxg-testid='dqmrecordmaininfopage.profileName']")
    public WebElement profileName;

    @FindBy(css = "span[data-nxg-testid='dqmrecordmaininfopage.patientEuid']")
    public WebElement patientEuid;

    @FindBy(css = "span[data-nxg-testid='dqmRecordMainInfoPagePatientDOB']")
    public WebElement dob;

    @FindBy(css = "span[data-nxg-testid='dqmRecordMainInfoPagePatientPhone']")
    public WebElement phone;

    @FindBy(css = "span[data-nxg-testid='dqmRecordMainInfoPagePatientAddress']")
    public WebElement address;

    //Available demographics

    @FindBy(xpath = "//span[text()=' ELIZABETH ']")
    public WebElement demoFirstName;

    @FindBy(xpath = "//span[text()=' SMITH ']")
    public WebElement demoLastName;

    @FindBy(xpath = "//span[@data-nxg-testid = 'dqmeditablefield.detailsControl.ssn']")
    public WebElement demoSSN;

    @FindBy(xpath = "//span[text()= ' 09/06/1916 ']")
    public WebElement demoDOB;


}
