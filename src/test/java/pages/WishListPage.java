package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.WaitUtils;

import java.time.Duration;

public class WishListPage extends BasePage {

    @FindBy(xpath = "(//a[@title='Add to Wish List'])[6]")
    private WebElement addToWishListButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    public void scrollToElementAndClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToWishListButton);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addToWishListButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToWishListButton);

    }

    public boolean isLoginPageDisplayed(){
        WaitUtils.waitUntilElmIsVisible(emailField);
        return emailField.isDisplayed() && passwordField.isDisplayed();
    }


}
