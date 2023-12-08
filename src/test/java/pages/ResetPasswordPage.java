package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ResetPasswordPage {

    public ResetPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='reset-password-password-input']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@data-testid='reset-password-confirm-password-input']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//*[@data-testid='reset-password-confirm']")
    public WebElement resetButton;

}
