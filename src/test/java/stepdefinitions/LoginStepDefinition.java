package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.SetupPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class LoginStepDefinition {

    SetupPage mainPage = new SetupPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    ReusableMethods reusableMethods = new ReusableMethods();
    Actions actions=new Actions(Driver.getDriver());

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
}
