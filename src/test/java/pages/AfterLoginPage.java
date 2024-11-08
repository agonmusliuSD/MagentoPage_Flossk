package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.WaitUtils;

public class AfterLoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(xpath = "(//button[@id='send2'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[@title='Add to Wish List'])[4]")
    public WebElement addToWishListButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    public WebElement confirmationMessage;

    public void enterCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        WaitUtils.waitUntilElmIsClickable(signInButton);
    }

    public void addItemToWishList() {
        WaitUtils.waitUntilElmIsClickable(addToWishListButton);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToWishListButton);
        WaitUtils.waitUntilElmIsClickable(addToWishListButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToWishListButton);
    }

    public boolean isItemAddedToWishList() {
        return confirmationMessage.isDisplayed();
    }
}
