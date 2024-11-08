package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WishListPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class WishListStepDefs {

    private WishListPage wishListPage =new WishListPage();
    private WebDriver driver = Driver.getDriver();


    @Given("User is on the Magento page")
    public void userIsOnTheMagentoPage() {
        driver.get(ConfigurationReader.getProperty("magento.url"));
    }

    @When("User clicks \"Add to Wish List\"")
    public void userClicksAddToWishListPage() {
        wishListPage.scrollToElementAndClick();
    }

    @Then("User is redirected to the login page")
    public void userIsRedirectedToTheLoginPage() {
        Assert.assertTrue(wishListPage.isLoginPageDisplayed());
    }
}
