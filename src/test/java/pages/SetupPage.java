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

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[1]")
    public WebElement lengthCreteria;

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[2]")
    public WebElement lowerCaseCreteria;

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[3]")
    public WebElement upperCaseCreteria;

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[4]")
    public WebElement digitCreteria;

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[5]")
    public WebElement specialCreteria;

    @FindBy(xpath = "(//*[@class='isax isax-tick-circle valid-icon'])[6]")
    public WebElement matchCreteria;

}
