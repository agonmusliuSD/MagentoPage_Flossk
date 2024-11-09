package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefs {

    private LoginPage loginPage = new LoginPage();
    private WebDriver driver = Driver.getDriver();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get(ConfigurationReader.getProperty("magento.url") + "/customer/account/login/");
    }

    @When("User enters a valid username and password")
    public void userEntersAValidUsernameAndPassword() {
        loginPage.enterLoginCredentials("agonmus@outlook.org", "Testtest123");
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickSignInButton();
    }

    @Then("User should be logged in successfully")
    public void userSeesDashboard() {
        Driver.getDriver().getCurrentUrl();

    }
}
