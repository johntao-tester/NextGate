package com.nextgate.cucumber.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/default-cucumber-reports / report.html",
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },
        features = {
                "src/test/resources/features/NextGateLogin.feature",
                "src/test/resources/features/NextGateDQM.feature",
                "src/test/resources/features/NexGateHomePage.feature"

        },
        glue = {
                "com.nextgate.cucumber.steps"
        },
        tags = {
                "@loginWithWrongUsername"
        },
        dryRun = false
)
public class NextGateTest {
}
