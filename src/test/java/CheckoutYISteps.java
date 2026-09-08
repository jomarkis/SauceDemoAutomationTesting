import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutYISteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private YourCartPage yourCartPage = new YourCartPage(driver);
    private CheckoutYIPage checkoutYIPage = new CheckoutYIPage(driver);
    private CheckoutOVPage checkoutOVPage = new CheckoutOVPage(driver);

    @When("The user clicks on the \"Checkout\" button")
    public void clickCheckoutButton() {
        yourCartPage.clickCheckout();
    }

    @Then("The user should be redirected to the page with title \"Checkout: Your Information\"")
    public void checkoutYIPageTitle() {
        String titleText = checkoutYIPage.getTitleText();
        assertEquals("Checkout: Your Information",titleText);
    }

    @When("The user types the first name, last name, and postal code in each field")
    public void enterCheckoutInformation() {
        checkoutYIPage.enterFirstName("John");
        checkoutYIPage.enterLastName("Markakis");
        checkoutYIPage.enterPostalCode("12345");
    }

    @Then("The correct values should be displayed in each field")
    public void verifyCheckoutInformation() {
        assertEquals("John", checkoutYIPage.getFirstNameValue());
        assertEquals("Markakis", checkoutYIPage.getLastNameValue());
        assertEquals("12345", checkoutYIPage.getPostalCodeValue());
    }

    @When("The user clicks on the \"Continue\" button")
    public void clickContinueButton() {
        checkoutYIPage.clickContinue();
    }

    @Then("The user should be redirected to the page with title \"Checkout: Overview\"")
    public void checkoutOverviewPageTitle() {
        String titleText = checkoutOVPage.getTitleText();
        assertEquals("Checkout: Overview", titleText);
    }

}
