package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;

public class ShippingPage extends BasePage {

    @FindBy(id = "LBKF300")
    private WebElement firstNameField;

    @FindBy(id = "XLF1A24")
    private WebElement lastNameField;

    @FindBy(id = "I0J4I54")
    private WebElement companyNameField;

    @FindBy(id = "LLJRGR2")
    private WebElement addressLine1Field;

    @FindBy(id = "HXVPEVR")
    private WebElement cityNameField;

    @FindBy(id = "Y0MQNFL")
    private WebElement stateNameDropdown;

    @FindBy(id = "WFYH3A4")
    private WebElement zipCodeField;

    @FindBy(id = "XS0BJOI")
    private WebElement countryDropdown;

    @FindBy(id = "U7G5PPG")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@type='radio' and @name='ko_unique_1' and @value='tablerate_bestway']")
    private WebElement shippingMethodField;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    public ShippingPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterShippingDetails(String firstName, String lastName, String company, String streetAddress, String city,String state, String zip, String country, String phone) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        companyNameField.sendKeys(company);
        addressLine1Field.sendKeys(streetAddress);
        cityNameField.sendKeys(city);
        stateNameDropdown.sendKeys(state);
        zipCodeField.sendKeys(zip);
        countryDropdown.sendKeys(country);
        phoneNumberField.sendKeys(phone);

    }

    public void selectShippingMethod(String method) {
        if ("Standard".equalsIgnoreCase(method)){
            shippingMethodField.click();
        }
    }

    public void clickNextButton() {
        nextButton.click();
    }


    }
