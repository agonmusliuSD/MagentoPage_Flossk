package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

public class MultipleItemsPage extends BasePage {

    @FindBy(xpath = "//div[@class='swatch-opt-694']//div[@id='option-label-size-143-item-169']")
    private WebElement sizeS;

    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-57\"]")
    private WebElement colorPink;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")
    private WebElement addRadiantTeeToCart;

    @FindBy(xpath = "//div[@id='option-label-size-143-item-170' and @aria-label='XL']")
    private WebElement sizeXL;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-53' and @aria-label='Green']")
    private WebElement colorGreen;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[4]")
    private WebElement addHeroHoodieToCart;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[5]")
    private WebElement addFusionBackpackToCart;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[6]")
    private WebElement addMessengerBagToCart;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    private WebElement proceedToCheckoutButton;

    public void selectSizeAndColor(String size, String color) {
        if ("S".equals(size)) {
            sizeS.click();
        }
        if ("Pink".equals(color)) {
            colorPink.click();
        }
    }

    public void AddRadiantTeeToCart(){
        addRadiantTeeToCart.click();
    }

    public void addHeroToCart() {
        sizeXL.click();
        colorGreen.click();
        addHeroHoodieToCart.click();
    }

    public void addFusionBackpackToCart() {
        addFusionBackpackToCart.click();
    }

    public void addMessengerBagToCart() {
        addMessengerBagToCart.click();
    }

    public void proceedToCheckoutButton() {
        viewCartButton.click();
        proceedToCheckoutButton.click();
    }
}
