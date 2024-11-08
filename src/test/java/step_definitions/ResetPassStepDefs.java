package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ResetPassPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ResetPassStepDefs {

    private ResetPassPage resetPassPage = new ResetPassPage();
    private WebDriver driver = Driver.getDriver();


    @Given("User is on the login page of Magento")
    public void userIsOnTheHomePageOfMagento() {
        driver.get(ConfigurationReader.getProperty("magento.url") + "/customer/account/login/");
    }

    @When("User clicks \"Forgot Your Password?\"")
    public void userClicksForgotYourPassword() {
        resetPassPage.clickForgotPassword();
    }

    @And("User enters their email address")
    public void userEntersTheirEmailAddress() {
        resetPassPage.enterEmailAddress("agonmus@outlook.com");
    }

    @And("User submits the reset password request")
    public void userSubmitsTheResetPasswordRequest() {
        resetPassPage.submitResetPassword();
    }

    @Then("User sees a password reset confirmation message")
    public void userSeesAPasswordResetConfirmationMessage() {
        Assert.assertTrue(resetPassPage.isResetConfirmationDisplayed());
    }


}
