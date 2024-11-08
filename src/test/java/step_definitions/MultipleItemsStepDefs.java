package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.MultipleItemsPage;
import pages.ShippingPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class MultipleItemsStepDefs {

    private MultipleItemsPage multipleItemsPage = new MultipleItemsPage();
    private WebDriver driver = Driver.getDriver();

    @Given("User is on the main page")
    public void userIsOnTheMainPage() {
        driver.get(ConfigurationReader.getProperty("magento.url"));
    }

    @When("User adds multiple items to the cart")
    public void userAddsMultipleItemsToTheCart() {
        multipleItemsPage.selectSizeAndColor("S", "Pink");
        multipleItemsPage.AddRadiantTeeToCart();
        multipleItemsPage.addHeroToCart();
        multipleItemsPage.addFusionBackpackToCart();
        multipleItemsPage.addMessengerBagToCart();
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() {
    MultipleItemsPage multipleItemsPage = new MultipleItemsPage();
    multipleItemsPage.proceedToCheckoutButton();
    }

    @And("User enters shipping details and selects shipping method")
    public void userEntersShippingDetailsAndSelectsShippingMethod() {
        ShippingPage shippingPage = new ShippingPage();
        shippingPage.enterShippingDetails("Agon", "Musliu", "Test1", "test12", "New York", "Colorado", "12345-98740", "United States", "123654789");
        shippingPage.selectShippingMethod("Standard");
        shippingPage.clickNextButton();
    }

    @Then("User completes the checkout process")
    public void userCompletesTheCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.completeOrder();
    }
}
