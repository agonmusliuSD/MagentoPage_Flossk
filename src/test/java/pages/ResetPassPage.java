package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class ResetPassPage extends BasePage {

    @FindBy(xpath = "//a[contains(., 'Forgot Your Password?')][1]")
    private WebElement forgotPasswordLink;

    @FindBy(id = "email_address")
    private WebElement emailAddressField;

    @FindBy(xpath = "//span[normalize-space()='Reset My Password']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[contains(text(), 'If there is an account associated')]")
    private WebElement resetConfirmationMessage;

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickForgotPassword() {
        scrollToElement(forgotPasswordLink);
        WaitUtils.waitUntilElmIsClickable(forgotPasswordLink);
        forgotPasswordLink.click();
    }

    public void enterEmailAddress(String emailAddress) {
        WaitUtils.waitUntilElmIsVisible(emailAddressField);
        emailAddressField.sendKeys(emailAddress);
    }

    public void submitResetPassword() {
        WaitUtils.waitUntilElmIsClickable(resetPasswordButton);
        resetPasswordButton.click();
    }

    public boolean isResetConfirmationDisplayed() {
        WaitUtils.waitUntilElmIsVisible(resetConfirmationMessage);
        return resetConfirmationMessage.isDisplayed();
    }


}
