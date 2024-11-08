package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.Driver;

public class AddReviewPage extends BasePage {

    @FindBy(xpath = "//a[@class='action add' and contains(text(), 'Add Your Review')]")
    private WebElement addReviewButton;

    @FindBy(id = "nickname_field")
    private WebElement nicknameBodyField;

    @FindBy(id = "summary_field")
    private WebElement summaryBodyField;


    @FindBy(id = "review_field")
    private WebElement reviewBodyField;


    @FindBy(xpath = "//*[@id=\"Rating_5_label\"]")
    private WebElement rating5Stars;

    @FindBy(xpath = "//span[text()='Submit Review']")
    private WebElement submitReviewButton;

//    @FindBy(xpath = "//div[contains(@data-bind, 'prepareMessageForHtml') and contains(text(), 'You submitted your review for moderation')]")
//    private WebElement reviewConfirmationMessage;

    public void navigateToItemPage() {
        Driver.getDriver().get("https://magento.softwaretestingboard.com/radiant-tee.html");
    }

    public void clickAddReviewButton() {
        addReviewButton.click();
    }

    public void enterReview(String nickname, String summary, String review) {
        nicknameBodyField.sendKeys(nickname);
        summaryBodyField.sendKeys(summary);
        reviewBodyField.sendKeys(review);
    }


    public void selectRating() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", rating5Stars);

    }

    public void submitReview() {
        submitReviewButton.click();
    }



}
