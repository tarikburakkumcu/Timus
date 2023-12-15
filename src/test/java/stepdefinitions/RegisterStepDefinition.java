package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.*;

public class RegisterStepDefinition {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    MailPage mailPage = new MailPage();
    MainPage mainPage = new MainPage();
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    SetupPage setupPage = new SetupPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();


    @And("Click Create Account button.")
    public void clickCreateAccountButton() {
        loginPage.creatAccountButton.click();
    }

    @And("Verify that the user is successfully go to register page.")
    public void verifyThatTheUserIsSuccessfullyGoToRegisterPage() {
        registerPage.alertRegisterPage.isDisplayed();
    }

    @And("Enter {string}, {string} and {string}.")
    public void enterAnd(String firstName, String lastName, String email) {
        registerPage.firstNameBox.sendKeys(firstName);
        registerPage.lastNameBox.sendKeys(lastName);
        registerPage.regEmailBox.sendKeys(email);
    }

    @And("Select {string}.")
    public void select(String country) {
        registerPage.countryDropDown.sendKeys();
    }

    @And("Check Privacy Policy and Terms Of Services")
    public void checkPrivacyPolicyAndTermsOfServices() {

        if (registerPage.privacyBox.isSelected()) {
            System.out.println("Privacy Box is Checked");
        } else {
            registerPage.privacyBox.click();
            js.executeScript("arguments[0].scrollIntoView();", registerPage.regPrivacyPolicy);
            registerPage.regPrivacyPolicy.click();
        }

        if (registerPage.termsBox.isSelected()) {
            System.out.println("Terms of Services is Checked");
        } else {
            registerPage.termsBox.click();
            js.executeScript("arguments[0].scrollIntoView();", registerPage.regTermsOfService);
            registerPage.regTermsOfService.click();
        }
    }

    @Then("Click continue login button.")
    public void clickContinueLoginButton() {
        registerPage.acceptButton.click();
    }

    @And("Verify that the user is successfully register verify page.")
    public void verifyThatTheUserIsSuccessfullyRegisterVerifyPage() {
        registerPage.alertRegisterPage2.isDisplayed();
    }

    @And("Register with a valid {string}, {string}, {string} address and {string}.")
    public void registerWithAValidAddressAnd(String firstName, String lastName, String email, String country) {
        clickCreateAccountButton();
        enterAnd(firstName, lastName, email);
        select(country);
        clickContinueLoginButton();
    }

    @Then("Check the email for the activation link.")
    public void checkTheEmailForTheActivationLink() {
        Driver.getDriver().get(ConfigReader.getProperty("mailUrl"));
    }

    @And("Click on the activation link")
    public void clickOnTheActivationLink() {
        mailPage.activateLink.click();
    }

    @Then("Verify that the account is activated and the user can log in.")
    public void verifyThatTheAccountIsActivatedAndTheUserCanLogIn() {
        mainPage.name.isDisplayed();
    }

    @Then("Click set Password.")
    public void clickSetPassword() {
        mailPage.activateLink.click();
    }

    @And("Enter {string}.")
    public void enter(String name) {
        setupPage.name.sendKeys(name);
    }

    @And("Enter a strong {string} during registration.")
    public void enterAStrongDuringRegistration(String password) {
        setupPage.password.sendKeys(password);
        setupPage.confirmPassword.sendKeys(password);
    }

    @Then("Verify that the system accepts the password strength criteria.")
    public void verifyThatTheSystemAcceptsThePasswordStrengthCriteria() {
        Assert.assertTrue(setupPage.lengthCreteria.isDisplayed());
        Assert.assertTrue(setupPage.lowerCaseCreteria.isDisplayed());
        Assert.assertTrue(setupPage.upperCaseCreteria.isDisplayed());
        Assert.assertTrue(setupPage.digitCreteria.isDisplayed());
        Assert.assertTrue(setupPage.specialCreteria.isDisplayed());
        Assert.assertTrue(setupPage.matchCreteria.isDisplayed());
    }

    @And("Enter a weak {string} during registration.")
    public void enterAWeakDuringRegistration(String password) {
        setupPage.password.sendKeys(password);
        setupPage.confirmPassword.sendKeys(password);
    }

    @And("Verify that the system prompts for a stronger password.")
    public void verifyThatTheSystemPromptsForAStrongerPassword() {
        Assert.assertFalse(setupPage.setUpPasswordButton.isEnabled());
    }

    @And("Enter different passwords in the {string} and {string} fields.")
    public void enterDifferentPasswordsInTheAndFields(String password, String confirmPassword) {
        setupPage.password.sendKeys(password);
        setupPage.confirmPassword.sendKeys(confirmPassword);
    }

    @And("Verify that the system displays an appropriate error message.")
    public void verifyThatTheSystemDisplaysAnAppropriateErrorMessage() {
        Assert.assertFalse(setupPage.matchCreteria.isDisplayed());
    }
}
