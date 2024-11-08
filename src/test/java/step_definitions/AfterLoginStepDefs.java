package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AfterLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WaitUtils;

public class AfterLoginStepDefs {

    private WebDriver driver = Driver.getDriver();
    private AfterLoginPage afterLoginPage = new AfterLoginPage();


    @Given("User is on the homepage of Magento")
    public void userIsLoggedIn() {
        driver.get(ConfigurationReader.getProperty("magento.url"));
    }

    @And("User is logging in")
    public void userIsLoggingIn(){
        afterLoginPage.signIn();
    }

    @And("User enter username and password")
    public void userEnterUsernameAndPasswordAndClicksOnSignInButton() {
        afterLoginPage.enterCredentials("agonmus@outlook.org", "Testtest123");

    }

    @And("User clicks the Sign in button")
    public void userClicksTheSignInButton() {
        afterLoginPage.clickSignInButton();
    }

    @When("User adds an item to the wish list")
    public void userAddsAnItemToTheWishList() {
       // WaitUtils.sleep(3);
        afterLoginPage.addItemToWishList();
    }

    @Then("The item is successfully added to the wish list")
    public void theItemIsSuccessfullyAddedToTheWishList() {
        Assert.assertTrue(afterLoginPage.isItemAddedToWishList());
    }
}
