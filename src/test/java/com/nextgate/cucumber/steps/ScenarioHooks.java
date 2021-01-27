package com.nextgate.cucumber.steps;

import com.nextgate.pages.LoginPage;
import com.nextgate.utilities.ConfigsReader;
import com.nextgate.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class ScenarioHooks {


    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        try {
            if(scenario.isFailed()){
                //this is the code to take a screenshot
                final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        }catch (Exception e){
            System.out.println("Exception happened while running tearDown: " + e.getMessage());
        }
        Driver.closeDriver();
    }
}
