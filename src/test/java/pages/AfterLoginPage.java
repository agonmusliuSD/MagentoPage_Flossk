package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.WaitUtils;

public class AfterLoginPage extends BasePage {

    @FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(xpath = "(//button[@id='send2'])[1]")
    public WebElement signInForm;

    @FindBy(xpath = "//li[5]//div[1]//div[1]//div[3]//div[1]//div[2]//a[1]")
    public WebElement addToWishListButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    public WebElement confirmationMessage;

    public void signIn() {
        signInButton.click();
    }

    public void enterCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        WaitUtils.waitUntilElmIsClickable(signInForm);
        ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", signInForm);
        signInForm.click();
    }

    public void addItemToWishList() {
        WaitUtils.waitUntilElmIsClickable(addToWishListButton);
        ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", addToWishListButton);
        ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].click();", addToWishListButton);

    }

    public boolean isItemAddedToWishList() {
        return confirmationMessage.isDisplayed();
    }
}
