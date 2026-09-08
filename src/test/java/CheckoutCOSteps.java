import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCOSteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private YourCartPage yourCartPage = new YourCartPage(driver);
    private CheckoutYIPage checkoutYIPage = new CheckoutYIPage(driver);
    private CheckoutOVPage checkoutOVPage = new CheckoutOVPage(driver);
    private CheckoutCOPage checkoutCOPage = new CheckoutCOPage(driver);

    @Then("A message \"Thank you for your order!\" should be displayed on the checkout complete page")
    public void checkFinalMessage() {
        assertEquals("Thank you for your order!", checkoutCOPage.getFinalMessageText());
    }

    @When("The user clicks on the \"Back Home\" button")
    public void clickOnBackHomeButton() {
        checkoutCOPage.clickBackToHome();
    }
}
