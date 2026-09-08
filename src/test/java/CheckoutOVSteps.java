import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutOVSteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private YourCartPage yourCartPage = new YourCartPage(driver);
    private CheckoutYIPage checkoutYIPage = new CheckoutYIPage(driver);
    private CheckoutOVPage checkoutOVPage = new CheckoutOVPage(driver);
    private CheckoutCOPage checkoutCOPage = new CheckoutCOPage(driver);

    @Then("The correct prices and total should be displayed on the checkout overview page")
    public void checkTruePriceValues() {
        String price = productsPage.getProductPrices("backpack");
        assertEquals("Item total: "+price, checkoutOVPage.getSubTotalText());
        assertEquals("Tax: $2.40", checkoutOVPage.getTaxesText());
        assertEquals("Total: $32.39", checkoutOVPage.getTotalText());
    }

    @When("The user clicks on the \"Finish\" button")
    public void clickFinishButton() {
        checkoutOVPage.clickFinish();
    }

    @Then("The user should be redirected to the page with title \"Checkout: Complete!\"")
    public void checkFinishPageTitle() {
        assertEquals("Checkout: Complete!", checkoutCOPage.getTitleText());
    }

    @When("The user clicks on the \"Cancel\" button")
    public void clickCancelButton() {
        checkoutOVPage.clickCancel();
    }
}
