package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SignUpStepDefs {

    private WebDriver driver = Driver.getDriver();
    private SignUpPage signUpPage = new SignUpPage();

    @Given("User is on the Magento homepage")
    public void userIsOnTheMagentoHomepage() {
        driver.get(ConfigurationReader.getProperty("magento.url"));

    }

    @When("User navigates to the Sign Up page")
    public void userNavigatesToTheSignUpPage() {
        signUpPage.clickCreateAccountButton();
    }

    @When("User enters their sign-up information")
    public void userEntersTheirSignUpInformation() {
        signUpPage.fillSignUpForm("Agon", "Musliu", "agonmus@outlook.org", "Testtest123");
    }

    @And("User submits the form")
    public void userSubmitsTheForm() {
        signUpPage.submitForm();
    }

    @Then("User should see a confirmation message for account creation")
    public void userShouldSeeAConfirmationMessage() {
        Assert.assertTrue("Account creation confirmation not found!", signUpPage.isConfirmationMessageDisplayed());
    }

}
