package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddItemPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AddToCartStepDefs {

    private WebDriver driver = Driver.getDriver();
    AddItemPage addItemPage = new AddItemPage();

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        driver.get(ConfigurationReader.getProperty("magento.url"));
    }

    @When("User selects size {string} and color {string}")
    public void userSelectsSizeAndColor(String size, String color) {
        addItemPage.selectSizeAndColor(size, color);
        addItemPage.addToCart();
    }

    @And("the user clicks \"Add to Cart\"")
    public void theUserClicksAddToCart() {
        addItemPage.addToCart();

    }

    @Then("the item should be added to the cart")
    public void theItemShouldBeAddedToTheCart() {
        Assert.assertTrue("Item was not added to cart", addItemPage.isItemAddedToCart());
    }
}
