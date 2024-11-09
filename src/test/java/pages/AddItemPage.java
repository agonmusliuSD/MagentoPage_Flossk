package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

import java.time.Duration;

public class AddItemPage extends BasePage {

    @FindBy(xpath = "//div[@class='swatch-opt-694']//div[@id='option-label-size-143-item-169']")
    private WebElement sizeL;

    @FindBy(xpath = "//div[@class='swatch-opt-694']//div[@id='option-label-color-93-item-52']")
    private WebElement colorGray;

    @FindBy(xpath = "//li[3]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement confirmationMessage;

    public void selectSizeAndColor(String size, String color) {
        if ("L".equals(size)) {
            sizeL.click();
        }
        if ("Gray".equals(color)) {
            colorGray.click();
        }
    }

    public void addToCart() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        WaitUtils.waitUntilElmIsVisible(addToCartButton);
        try {
            addToCartButton.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", addToCartButton);
        }
    }
    public boolean isItemAddedToCart() {
        return confirmationMessage.isDisplayed();
    }
}