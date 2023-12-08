package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SetupPage;
import pages.RegisterPage;
import utilities.ReusableMethods;

public class LoginStepDefinition {

    SetupPage mainPage = new SetupPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    ReusableMethods reusableMethods=new ReusableMethods();

    @When("login linkine tiklar")
    public void login_linkine_tiklar() {loginPage.loginButton.click();}
}
