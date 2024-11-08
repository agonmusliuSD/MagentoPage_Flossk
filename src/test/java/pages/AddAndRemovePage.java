package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class AddAndRemovePage extends BasePage {



    @FindBy(xpath = "(//button[@title='Add to Cart'])[6]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@class='action viewcart']")
    private WebElement viewCartLink;

    @FindBy(xpath = "(//a[@class='action action-delete'])[1]")
    private WebElement removeItemButton;

    @FindBy(xpath = "//div[@class='cart-empty']")
    private WebElement cartEmptyMessage;

    public void addItemToCart() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        WaitUtils.sleep(1);  // Short pause to allow the page to adjust
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", addToCartButton);

    }

    public boolean isCartUpdated() {
        WaitUtils.waitUntilElmIsVisible(cartIcon);
        return cartIcon.isDisplayed();
    }

    public void navigateToCart() {
        WaitUtils.waitUntilElmIsClickable(cartIcon);
        cartIcon.click();
        WaitUtils.waitUntilElmIsClickable(viewCartLink);
        viewCartLink.click();
    }

    public void removeItemFromCart() {
        WaitUtils.waitUntilElmIsClickable(removeItemButton);
        removeItemButton.click();
    }

    public boolean isCartEmpty(){
        WaitUtils.waitUntilElmIsVisible(cartEmptyMessage);
        return cartEmptyMessage.isDisplayed();
    }
}
