package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.time.Duration;

public class AddItemPage extends BasePage {

    @FindBy(xpath = "//div[@class='swatch-opt-694']//div[@id='option-label-size-143-item-169']")
    private WebElement sizeL;

    @FindBy(xpath = "//div[@class='swatch-opt-694']//div[@id='option-label-color-93-item-52']")
    private WebElement colorGray;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[3]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\" and contains(text(), 'You added')]\n")
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
        addToCartButton.click();
    }

    public boolean isItemAddedToCart() {
        return confirmationMessage.isDisplayed();
    }
}
