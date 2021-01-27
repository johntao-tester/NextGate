package com.nextgate.cucumber.steps;

import com.github.javafaker.Faker;
import com.nextgate.logger.MyLogger;
import com.nextgate.mockData.MockDataGenerator;
import com.nextgate.pages.*;
import com.nextgate.utilities.ConfigsReader;
import com.nextgate.utilities.Driver;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Map;

public class NextGateLoginSteps {
    LoginPage loginPage = new LoginPage();
    AccountHomePage homePage = new AccountHomePage();
    DataQualityManagerPage dqmPage = new DataQualityManagerPage();
    long start, finish, totalTime;
    DuplicateGroupPage duplicateGroupPage = new DuplicateGroupPage();
    ComparisonPage comparisonPage = new ComparisonPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
//    MyLogger record = new MyLogger();

    @Given("^user is on NextGate login page$")
    public void user_is_on_NextGate_login_page() throws Throwable {
        Driver.getDriver().navigate().to(ConfigsReader.getProperty("baseUrl"));
    }

    @When("^user inputs valid userName$")
    public void user_input_valid_userName() throws Throwable {
        loginPage.userNameInputField.sendKeys(ConfigsReader.getProperty("username"));
    }

    @When("^user inputs valid password$")
    public void user_input_valid_userName_with_valid_password() throws Throwable {
        loginPage.passwordInputField.sendKeys(ConfigsReader.getProperty("password"));
    }

    @And("^user clicks login button$")
    public void userClicksOnLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("^user should see message \"([^\"]*)\" in homePage$")
    public void user_is_welcomed_by_welcome_page_message(String welcomeMessage) throws Throwable {
        Assert.assertTrue(homePage.welcomeMsg.getText().contains(welcomeMessage));
    }

    @And("^user logs out$")
    public void serLogsOut() {
        loginPage.adminIcon.click();
        loginPage.logout.click();
    }

    @When("^user inputs invalid password \"([^\"]*)\"$")
    public void invalid_password(String invalidPassword) throws Throwable {
        loginPage.passwordInputField
                .sendKeys(MockDataGenerator.getMockData(invalidPassword) + Keys.ENTER);
    }

    @Then("^user should see \"([^\"]*)\"$")
    public void user_should_see(String errorMesage) throws Throwable {
        Assert.assertEquals(errorMesage, loginPage.errorMessage.getText());
    }

    @When("^user input invalid userName \"([^\"]*)\"$")
    public void user_input_invalid_userName(String invalidUserName) throws Throwable {
        loginPage.userNameInputField
                .sendKeys(MockDataGenerator.getMockData(invalidUserName));
    }

    @When("^valid password \"([^\"]*)\"$")
    public void valid_password(String password) throws Throwable {
        loginPage.passwordInputField.sendKeys(password + Keys.ENTER);
    }


    @Then("^user should see that apps are available$")
    public void user_should_see_that_apps_are_available(List<Map<String, String>> apps) throws Throwable {
        Assert.assertTrue(homePage.DQM.isDisplayed());
        Assert.assertTrue(homePage.codeset.isDisplayed());
        Assert.assertEquals(homePage.RestApiToolkit.getText(), apps.get(2).get("appName"));

    }

    @When("^clicks on Data Quality Manager app$")
    public void clicks_on_app() throws Throwable {
        homePage.DQM.click();
    }

    @When("^performs a person demographic search on patient's full name$")
    public void performs_a_person_demographic_search_on_patient_s_full_name(List<Map<String, String>> data) throws Throwable {
        dqmPage.firstNameField.sendKeys(data.get(0).get("firstname"));
        dqmPage.lastNameField.sendKeys(data.get(0).get("lastname"));
        dqmPage.searchButton.click();


    }

    @Then("^user should see records contained patient's name with EUID number$")
    public void user_should_see_records_contained_patient_s_name_with_EUID_number(List<Map<String, String>> data) throws Throwable {
        start = System.currentTimeMillis();
        Assert.assertEquals(dqmPage.EUID1000004798.getText(), data.get(0).get("EUID"));
        Assert.assertEquals(dqmPage.elizabethSmith.getText().toLowerCase(), data.get(0).get("fullname"));
        finish = System.currentTimeMillis();
        totalTime = finish - start;

        MyLogger.makeLog("Time it took to load page after performing Demographic search is: " + totalTime + " milliseconds");

    }


    @When("^user selects Person ID from search type$")
    public void user_selects_Person_ID_from_search_type() throws Throwable {
        start = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(dqmPage.EUID1000004798));
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        MyLogger.makeLog("Total time to get Demographic records is : " + totalTime + " milliseconds.");


        Driver.getDriver().findElement(By.xpath("//span[text()=' Person Demographics ']")).click();
        dqmPage.PersonId.click();
        Driver.getDriver().navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(dqmPage.idField));
//        Thread.sleep(1000);
    }

    @When("^user inputs EUID from records$")
    public void user_inputs_EUID_from_records() throws Throwable {
        dqmPage.idField.sendKeys("1000004798" + Keys.ENTER);
    }

    @Then("^user should be able to access records by validating page URL \"([^\"]*)\"$")
    public void user_should_be_able_to_get_record_details(String pageUrl) throws Throwable {
        start = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(dqmPage.demoDOB));
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        MyLogger.makeLog("Total time it took to load EUID record's inforamtion is: " + totalTime + " milliseconds.");
        Assert.assertEquals(pageUrl, Driver.getDriver().getCurrentUrl());
    }


    @Then("user should be able to get record details")
    public void userShouldBeAbleToGetRecordDetails(List<Map<String, String>> data) {
        Assert.assertEquals(dqmPage.profileName.getText(), data.get(0).get("fullname"));
        Assert.assertEquals(dqmPage.dob.getText(), data.get(0).get("dob"));
        Assert.assertEquals(dqmPage.patientEuid.getText(), data.get(0).get("ID"));
        Assert.assertEquals(dqmPage.phone.getText(), data.get(0).get("phone"));
        Assert.assertEquals(dqmPage.address.getText(), data.get(0).get("address"));
    }

    @Then("^user should be able to read all available demographics$")
    public void user_should_be_able_to_read_all_available_demographics(List<Map<String, String>> data) throws Throwable {
        Assert.assertEquals(dqmPage.demoFirstName.getText(), data.get(0).get("firstname"));
        Assert.assertEquals(dqmPage.demoLastName.getText(), data.get(0).get("lastname"));
        Assert.assertEquals(dqmPage.demoSSN.getText(), data.get(0).get("ssn"));
        Assert.assertEquals(dqmPage.demoDOB.getText(), data.get(0).get("dob"));
    }


    @When("^user selects Person Potential Duplicates$")
    public void user_selects_Person_Potential_Duplicates() throws Throwable {
        Driver.getDriver().findElement(By.xpath("//span[text()=' Person Demographics ']")).click();

        duplicateGroupPage.PersonPotentialDuplicates.click();
    }

    @When("^user clicks search$")
    public void user_clicks_search() throws Throwable {
        Thread.sleep(1000);
        duplicateGroupPage.searchButton.click();
        start = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(duplicateGroupPage.targetDupGroup));
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        MyLogger.makeLog("Total time to get Potential Duplicates Group is: " + totalTime + " milliseconds.");
    }

    @Then("^user should be abe to see \"([^\"]*)\"$")
    public void user_should_be_abe_to_see(String expectedResult) throws Throwable {
        Assert.assertEquals(expectedResult, Driver.getDriver().findElement(By.xpath("//span[text()='Showing 100 potential duplicate groups']")).getText());
        Assert.assertTrue(duplicateGroupPage.targetDupGroup.isDisplayed());
    }

    @When("^picks a potential dup group$")
    public void picks_a_potential_dup_group() throws Throwable {
        duplicateGroupPage.targetDupGroup.click();
        duplicateGroupPage.compareButton.click();
        start = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(comparisonPage.comparelastname1));
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        MyLogger.makeLog("Total time to load comparison page is: " + totalTime + " milliseconds.");
    }


    @Then("^user can compare potential duplicates$")
    public void userCanComparePotentialDuplicates() {
        Assert.assertTrue(comparisonPage.comparelastname1.isDisplayed());
        Assert.assertTrue(comparisonPage.comparelastname2.isDisplayed());
        Assert.assertTrue(comparisonPage.compareSSN1.isDisplayed());
        Assert.assertTrue(comparisonPage.compareSSN2.isDisplayed());

    }

    @Then("^user can navigate through page$")
    public void userCanNavigateThroughThePage() throws InterruptedException {
        comparisonPage.hideEmptyColumns.click();
        Thread.sleep(3000);
        comparisonPage.hideEmptyColumns.click();

        comparisonPage.enterPriseLink.click();
        Thread.sleep(4000);
        Driver.getDriver().navigate().back();

        Assert.assertTrue(comparisonPage.enterPriseLink.isDisplayed());
        Assert.assertTrue(comparisonPage.markUnique.isDisplayed());
        Assert.assertTrue(comparisonPage.showScoreBreakdown.isDisplayed());
        Assert.assertTrue(comparisonPage.comments.isDisplayed());

    }


    @When("^user clicks logout button$")
    public void serClicksLogoutButton() throws InterruptedException {
        loginPage.adminIcon.click();
        loginPage.logout.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));

    }

    @Then("^user should be at login page with following URL \"([^\"]*)\"$")
    public void serShouldBeAtTheLoginPageWithFollowingURL(String url) {
        Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());
    }


}
