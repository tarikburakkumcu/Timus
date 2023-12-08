package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='forgot-password-email-input']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@data-testid='forgot-password-send']")
    public WebElement sendBox;

    @FindBy(xpath = "//*[@data-testid='forgot-password-login']")
    public WebElement loginBox;

}
