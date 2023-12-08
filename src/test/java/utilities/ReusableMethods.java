package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.SetupPage;

public class ReusableMethods {
    public ReusableMethods() {
    }

    public static void login() {
        SetupPage mainPage = new SetupPage();
        LoginPage loginPage = new LoginPage();
        goToUrl();
        loginPage.loginButton.click();
        if (!Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("loginUrl"))) {
            goToUrl();
            loginPage.loginButton.click();
        }
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("validUserName"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.loginButton.click();
    }

    public static void goToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }

    public static void scrollTo(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(2);
    }

}
