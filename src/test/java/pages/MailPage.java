package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MailPage {

    public MailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='login-email-input']")
    public WebElement resetLink;

    @FindBy(xpath = "//*[@data-testid='login-email-input']")
    public WebElement activateLink;
}
