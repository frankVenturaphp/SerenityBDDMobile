package com.bdd.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepdefs {

    MyUserSteps user;
    private static final Logger LOGGER = LoggerFactory.getLogger(MyStepdefs.class);

    @Before
    public void setupTest(Scenario scenario) throws Throwable {
        user = new MyUserSteps(ThucydidesWebDriverSupport.getDriver());
        Thread.sleep(10000);
    }

    @After
    public void tearDown() {
        ThucydidesWebDriverSupport.closeAllDrivers();
    }

    @Given("^the app is running$")
    public void theAppIsRunning(){
        LOGGER.info("Starting running tests");
    }

    @When("^searching for Sara$")
    public void searchingForSara() {
        user.searchFor("sara");
    }

    @Then("^Sara Alston is returned$")
    public void saraAlstonIsReturned() {
        LOGGER.info("Output is: " + user.getResult());
        Assert.assertThat(user.getResult(), CoreMatchers.containsString("Sara Alston"));

    }

    @Given("^blah$")
    public void blah() {
        LOGGER.info("SOMETHING 1");
    }

    @When("^blahblah$")
    public void blahblah() {
        LOGGER.info("SOMETHING 2");
    }

    @Then("^blahblahblah$")
    public void blahblahblah() {
        LOGGER.info("SOMETHING 3");
    }

}
