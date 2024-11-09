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

    @FindBy(xpath = "//span[@data-bind=\"css: { empty: !!getCartParam('summary_count') == false && !isLoading() }, blockLoader: isLoading\"]")
    private WebElement viewCartLink;

    @FindBy(xpath = "//a[@title='Remove item']")
    private WebElement removeItemButton;

    @FindBy(xpath = "//span[normalize-space()='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong")
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
        WaitUtils.waitUntilElmIsVisible(viewCartLink);
        WaitUtils.waitUntilElmIsClickable(viewCartLink);
        viewCartLink.click();
    }

    public void removeItemFromCart() {
        WaitUtils.waitUntilElmIsClickable(removeItemButton);
        removeItemButton.click();
        WaitUtils.waitUntilElmIsVisible(okButton);
        okButton.click();
    }

    public boolean isCartEmpty(){
        WaitUtils.waitUntilElmIsVisible(cartEmptyMessage);
        return cartEmptyMessage.isDisplayed();
    }
}
