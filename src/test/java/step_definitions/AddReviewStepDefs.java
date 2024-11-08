package step_definitions;

import io.cucumber.java.de.Angenommen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddReviewPage;
import utilities.Driver;
import utilities.WaitUtils;

public class AddReviewStepDefs {

     private AddReviewPage addReviewPage = new AddReviewPage();
     private WebDriver driver = Driver.getDriver();


    @Given("User is on the item page")
    public void userIsOnTheItemPage() {
        addReviewPage.navigateToItemPage();
    }

    @When("User clicks \"Add Your Review\"")
    public void userClicksAddYourReview() {
        addReviewPage.clickAddReviewButton();
    }

    @When("User enters a review with nickname {string} and title {string} and body {string}")
    public void userEntersAReviewWithTitleAndBody(String nickname,String title, String body) {
        addReviewPage.enterReview(nickname,title,body);

    }

    @And("User selects a rating of {string}")
    public void userSelectsARatingOf(String rating) {
        if ("5 stars".equals(rating)) {
            addReviewPage.selectRating();
        }
    }

    @Then("User submits the review")
    public void userSubmitsTheReview() {
        addReviewPage.submitReview();
    }



}
