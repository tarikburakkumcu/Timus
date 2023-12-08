package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='login-email-input']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@data-testid='pages-login-niigwirnsa']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@class='el-checkbox__input is-checked']")
    public WebElement rememberMeBox;

    @FindBy(xpath = "//*[@data-testid='login-forgot-password']")
    public WebElement forgotPassword;

    @FindBy(xpath = "(//*[@data-testid='register-terms-of-use'])[1]")
    public WebElement privacyPolicy;

    @FindBy(xpath = "(//*[@data-testid='register-terms-of-use'])[2]")
    public WebElement termsOfService;

    @FindBy(xpath = "//*[@data-testid='login-continue']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@data-testid='login-create-account']")
    public WebElement creatAccountButton;

    @FindBy(xpath = "")
    public WebElement alert;
}
