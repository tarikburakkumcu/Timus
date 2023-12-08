package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='register-firstname-input']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@data-testid='register-lastname-input']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[@data-testid='register-email-input']")
    public WebElement regEmailBox;

    @FindBy(xpath = "//*[@data-testid='register-country-dropdown']")
    public WebElement countryDropDown;

    @FindBy(id = "privacy_box")
    public WebElement privacyBox;

    @FindBy(xpath = "(//*[@class='agreement_text'])[3]")
    public WebElement regPrivacyPolicy;

    @FindBy(id = "term_of_use_box")
    public WebElement termsBox;

    @FindBy(xpath = "(//*[@class='agreement_text'])[4]")
    public WebElement regTermsOfService;

    @FindBy(xpath = "//*[@data-testid='register-continue']")
    public WebElement regButton;

    @FindBy(xpath = "//*[@data-testid='forgot-password-login']")
    public WebElement regForgotButton;

    @FindBy(xpath = "//*[@data-testid='pages-register-index-zfrzzhrgq']")
    public WebElement acceptButton;


}
