package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SetupPage {

    public SetupPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='setup-password-title-input']")
    public WebElement name;

    @FindBy(xpath = "//*[@data-testid='setup-password-password-input']")
    public WebElement password;

    @FindBy(linkText = "//*[@data-testid='setup-password-confirm-password-input']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//*[@data-testid='setup-password-continue']")
    public WebElement setUpPasswordButton;



    public String selectedInDateControl(String day) {
        String xpath = "//input[contains(@value, '/" + day + "/2021' ) and @id='checkin_date']";
        return xpath;
    }

    public String selectedOutDateControl(String day) {
        String xpath = "//input[contains(@value, '/" + day + "/2021' ) and @id='checkout_date']";
        return xpath;
    }
}
