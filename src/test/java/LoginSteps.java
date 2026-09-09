import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.LoginPage;
import org.example.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    public static WebDriver driver;

    private long startTime;
    private long endTime;

    @Given("The user opens the SauceDemo website in Firefox")
    public void openWebsite() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();

            // Ελέγχουμε αν από το τερματικό/Jenkins ζητήθηκε headless mode
            String isHeadless = System.getProperty("headless", "false");
            if (Boolean.parseBoolean(isHeadless)) {
                options.addArguments("-headless"); // Τρέξε αόρατα
            }

            driver = new FirefoxDriver(options);
            driver.manage().window().setSize(new Dimension(1513, 831));
        }

        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @When("The user enters username {string} and password {string}")
    public void enterNamePass(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("The user clicks the login button")
    public void clickLoginButton() {
        startTime = System.currentTimeMillis();
        loginPage.clickLoginButton();
    }

    @Then("The user should be redirected to the products page with title {string}")
    public void isTitleProducts(String expTitle) {
        String titleText = productsPage.getTitleText();
        assertEquals(expTitle,titleText,"The login page must be \"Products\"");
    }

    @Then("An error message should be displayed with text {string}")
    public void isErrorMessage(String error) {
        String errorText = loginPage.getErrorMessage();
        assertEquals(error,errorText,"There must be an error message: "+error);
    }

    @Then("The user should be redirected to the products page with title {string} within 2 seconds")
    public void isWithin2sec(String expTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String titleText = productsPage.getTitleText();
        assertEquals(expTitle,titleText,"Should be redirected to the products page with title: "+expTitle);
        assertTrue(totalTime <= 2000, "The redirection process took longer than 2 seconds: " + totalTime + " milliseconds");
    }

    @Given("The user is logged in as a {string}")
    public void userIsLoggedInAs(String userType) {
        openWebsite();

        loginPage.enterUsername(userType);
        loginPage.enterPassword("secret_sauce");

        clickLoginButton();
    }
}
