package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddAndRemovePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AddAndRemoveStepDefs {

    private AddAndRemovePage addAndRemovePage = new AddAndRemovePage();
    private WebDriver driver = Driver.getDriver();

    @Given("User is on the main page of Magento")
    public void userIsOnTheMainPageOfMagento() {
        driver.get(ConfigurationReader.getProperty("magento.url"));
    }

    @When("User adds an item to the cart")
    public void userAddsAnItemToTheCart() {
        addAndRemovePage.addItemToCart();
    }

    @Then("The item is successfully added to the cart")
    public void theItemIsSuccessfullyAddedToTheCart() {
        Assert.assertTrue(addAndRemovePage.isCartUpdated());
    }

    @When("User navigates to the cart")
    public void userNavigatesToTheCart() {
        addAndRemovePage.navigateToCart();
    }

    @And("User removes the item from the cart")
    public void userRemovesTheItemFromTheCart() {
        addAndRemovePage.removeItemFromCart();
    }

    @Then("The cart is empty")
    public void theCartIsEmpty() {
        Assert.assertTrue(addAndRemovePage.isCartEmpty());
    }
}
