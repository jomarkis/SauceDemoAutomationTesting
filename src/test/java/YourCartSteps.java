import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.LoginPage;
import org.example.ProductsPage;
import org.example.YourCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YourCartSteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private YourCartPage yourCartPage = new YourCartPage(driver);

    @When("The user clicks on the cart icon")
    public void clicksOnTheCartIcon() {
        yourCartPage.clickCartBadge();
    }

    @Then("The user should be redirected to the page with title \"Your Cart\"")
    public void isTitleYourCart() {
        String titleText = yourCartPage.getTitleText();
        assertEquals("Your Cart", titleText);
    }

    @Then("The \"Remove\" button should be displayed for the product in the cart")
    public void isThereRemoveButton() {
        {
            List<WebElement> elements = driver.findElements(yourCartPage.removeButton("sauce-labs-backpack"));
            assert(elements.size() > 0);
        }
        assertEquals("Remove",yourCartPage.getRemoveButtonText("sauce-labs-backpack"));
    }
}
