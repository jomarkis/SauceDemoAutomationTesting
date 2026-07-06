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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsSteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);

    @When("The user adds a product to the cart")
    public void addToCart() {
        productsPage.clickAddButton("sauce-labs-backpack");
    }

    @Then("The cart badge should show \"1\"")
    public void cartIs1() {
        assertEquals("1",productsPage.getCartBadgeText(),"The cart badge must be \"1\"");
    }

    @When("The user removes the product from the cart")
    public void removeFromCart() {
        productsPage.clickRemoveButton("sauce-labs-backpack");
    }

    @Then("The cart badge should be empty")
    public void cartIsEmpty() {
        assertEquals("",productsPage.getCartBadgeText(),"The cart badge must be empty");
        if (driver != null) {
            driver.quit();
        }
    }


}
