package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.WaitUtils;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
    public WebElement signInButton;

    public void enterLoginCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        WaitUtils.waitUntilElmIsClickable(signInButton);
    }


}
