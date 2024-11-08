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

public class AfterLoginStepDefs {

    private WebDriver driver = Driver.getDriver();
    private AfterLoginPage afterLoginPage = new AfterLoginPage();


    @Given("User is logged in")
    public void userIsLoggedIn() {
        driver.get(ConfigurationReader.getProperty("magento.url") + "/customer/account/login/");
    }

    @And("User enter username and password and clicks on sign in button")
    public void userEnterUsernameAndPasswordAndClicksOnSignInButton() {
        afterLoginPage.enterCredentials("agonmus@outlook.org", "Testtest123");
        afterLoginPage.clickSignInButton();
    }

    @When("User adds an item to the wish list")
    public void userAddsAnItemToTheWishList() {
        afterLoginPage.addItemToWishList();
    }

    @Then("The item is successfully added to the wish list")
    public void theItemIsSuccessfullyAddedToTheWishList() {
        Assert.assertTrue(afterLoginPage.isItemAddedToWishList());
    }
}
