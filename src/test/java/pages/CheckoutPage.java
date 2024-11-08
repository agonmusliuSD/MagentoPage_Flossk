package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//span[text()='Place Order']")
    private WebElement placeOrderButton;

    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    public void completeOrder(){
        placeOrderButton.click();
    }





}
