package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;
import utilities.*;

public class LoginStepDefinition {

    LoginPage loginPage = new LoginPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    MailPage mailPage = new MailPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    @When("login linkine tiklar")
    public void login_linkine_tiklar() {
        loginPage.loginButton.click();
    }

    @Given("Go to Url.")
    public void goToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("loginUrl"));
    }

    @And("Enter {string} and {string}.")
    public void enterAnd(String email, String password) {
        loginPage.emailBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("Click Continue login button.")
    public void clickContinueLoginButton() {
        loginPage.loginButton.click();
    }

    @And("Verify that the user is successfully logged in.")
    public void verifyThatTheUserIsSuccessfullyLoggedIn() {
        Assert.assertTrue("Log in Success", loginPage.alert.isDisplayed());
    }

    @And("Check the Remember Me option.")
    public void checkTheRememberMeOption() {
        loginPage.rememberMeBox.click();
    }

    @Then("Log in with {string} and {string}")
    public void logInWithAnd(String email, String password) {
        enterAnd(email, password);
        clickContinueLoginButton();
    }

    @Then("close the browser.")
    public void closeTheBrowser() {
        Driver.getDriver().close();
    }

    @And("Reopen the browser and verify that the user is still logged in automatically.")
    public void reopenTheBrowserAndVerifyThatTheUserIsStillLoggedInAutomatically() {
        goToUrl();
        verifyThatTheUserIsSuccessfullyLoggedIn();
    }

    @And("Click on the Forgot Password link.")
    public void clickOnTheForgotPasswordLink() {
        loginPage.forgotPassword.click();
    }

    @Then("Enter a {string} address and submit the form.")
    public void enterAAddressAndSubmitTheForm(String email) {
        forgotPasswordPage.emailBox.sendKeys(email);
        forgotPasswordPage.loginBox.click();
    }

    @And("Check the email for the password reset link.")
    public void checkTheEmailForThePasswordResetLink() {
        Driver.getDriver().get(ConfigReader.getProperty("mailUrl"));
        mailPage.resetLink.click();

    }

    @Then("Set a new {string} using the link.")
    public void setANewUsingTheLink(String password) {
        resetPasswordPage.passwordBox.sendKeys(password);
        resetPasswordPage.confirmPasswordBox.sendKeys(password);
        resetPasswordPage.resetButton.click();
    }

    @And("Log in with the new {string},{string}.")
    public void logInWithTheNew(String email, String password) {
        enterAnd(email, password);
        clickContinueLoginButton();
    }
}
