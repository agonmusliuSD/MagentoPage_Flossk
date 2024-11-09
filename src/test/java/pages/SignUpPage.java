package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

import java.time.Duration;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountButton;

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createButton;

    @FindBy(xpath = "//*[contains(text(), 'Thank you for registering')]")
    private WebElement confirmationMessage;

    public void clickCreateAccountButton() {
        WaitUtils.waitUntilElmIsClickable(createAccountButton);
        createAccountButton.click();
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void submitForm(){
        WaitUtils.waitUntilElmIsClickable(createButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createButton);
        createButton.click();

    }

    public boolean isConfirmationMessageDisplayed(){
        WaitUtils.sleep(2);
        WaitUtils.waitUntilElmIsVisible(confirmationMessage);
        return confirmationMessage.isDisplayed();
    }


    }
