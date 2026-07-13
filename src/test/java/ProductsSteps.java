import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.LoginPage;
import org.example.ProductsPage;
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

public class ProductsSteps {
    private WebDriver driver = LoginSteps.driver;
    private ProductsPage productsPage = new ProductsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    // Scenario: Add and Remove a product from cart as standard_user
    @When("The user adds a product to the cart")
    public void addToCart() {
        productsPage.clickAddButton("sauce-labs-backpack");
    }

    @Then("The cart badge should show \"1\" and the button should change to \"Remove\"")
    public void cartIs1() {
        assertEquals("1", productsPage.getCartBadgeText(), "The cart badge must be \"1\"");
        assertEquals("Remove", productsPage.getRemoveButtonText("sauce-labs-backpack"), "The button must be \"Remove\"");
    }

    @When("The user removes the product from the cart")
    public void removeFromCart() {
        productsPage.clickRemoveButton("sauce-labs-backpack");
    }

    @Then("The cart badge should be empty and the button should change to \"Add to cart\"")
    public void cartIsEmpty() {
        assertEquals("", productsPage.getCartBadgeText(), "The cart badge must be empty");
        assertEquals("Add to cart", productsPage.getAddButtonText("sauce-labs-backpack"), "The button must be \"Add to cart\"");
        if (driver != null) {
            driver.quit();
        }
    }

    // Scenario: Use menu bar as standard_user
    @When("The user clicks on the menu bar")
    public void clickOnMenu() {
        productsPage.clickMenuButton();
    }

    @Then("The menu should be displayed")
    public void menuIsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Animation delay
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-cross-btn")));

        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"inventory-sidebar-link\"]"));
            assertTrue(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"about-sidebar-link\"]"));
            assertTrue(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"logout-sidebar-link\"]"));
            assertTrue(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"reset-sidebar-link\"]"));
            assertTrue(elements.size() > 0);
        }
    }

    @When("The user clicks on \"All Items\"")
    public void clickOnAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement AllItemsLink = wait.until(
                ExpectedConditions.elementToBeClickable(productsPage.getMenuAllItems())
        );
        productsPage.clickMenuAllItems();
    }

    @Then("The user should be redirected to the products page")
    public void checkProductsPage() {
        String title = productsPage.getTitleText();
        assertEquals("Products", title, "The user must be redirected to the products page");
    }

    @When("The user clicks on \"About\"")
    public void clickOnAbout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement aboutLink = wait.until(
                ExpectedConditions.elementToBeClickable(productsPage.getMenuAbout())
        );
        productsPage.clickMenuAbout();
    }

    @Then("The user should be redirected to the Sauce LAB website")
    public void checkAboutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("saucelabs.com"));
        driver.navigate().back();
        productsPage.clickMenuButton();
    }

    @When("The user clicks on \"Logout\"")
    public void clickOnLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement LogoutLink = wait.until(
                ExpectedConditions.elementToBeClickable(productsPage.getMenuLogout())
        );
        productsPage.clickMenuLogout();
    }

    @Then("The user should be logged out and redirected to the login page")
    public void checkLoginPage() {
        List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"login-button\"]"));
        assertTrue(elements.size() > 0);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("The user clicks on \"Reset App State\"")
    public void clickOnResetAppState() {
        productsPage.clickMenuButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement resetLink = wait.until(
                ExpectedConditions.elementToBeClickable(productsPage.getMenuResetAppState())
        );
        productsPage.clickMenuResetAppState();
    }

    @Then("The cart should be empty and all buttons should be reset to \"Add to cart\"")
    public void checkResetAppStateFunctionality() {

        try {
            assertEquals("", productsPage.getCartBadgeText(), "The cart badge must be empty");
            ArrayList<String> products = new ArrayList<>(List.of("sauce-labs-backpack", "sauce-labs-bike-light", "sauce-labs-bolt-t-shirt", "sauce-labs-fleece-jacket", "sauce-labs-onesie", "test.allthethings()-t-shirt-(red)"));
            for (String product : products) {
                List<WebElement> elements = driver.findElements(productsPage.addButton(product));
                assertTrue(elements.size() > 0);
                assertEquals("Add to cart", productsPage.getAddButtonText(product), "The button must be \"Add to cart\"");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Navigation to details
    @When("The user clicks on a product's name")
    public void clickOnProductsName() {
        productsPage.clickOnName("backpack");
    }

    @Then("The user should be redirected to the product's details page and the product's name, description, and price should be displayed")
    public void checkProductDetailPage() {
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"inventory-item-name\"]"));
            assertTrue(elements.size() > 0);
        }
        assertEquals("Sauce Labs Backpack", driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), "The product name must be \"Sauce Labs Backpack\"");
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"inventory-item-desc\"]"));
            assertTrue(elements.size() > 0);
        }
        assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-desc\"]")).getText(), productsPage.getProductDetails("backpack"));
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"inventory-item-price\"]"));
            assertTrue(elements.size() > 0);
        }
        assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), productsPage.getProductPrices("backpack"));
    }

    @Then("The \"Add to cart\" button should be displayed if the product is not in the cart, or the \"Remove\" button should be displayed if the product is already in the cart")
    public void checkAddToCartButtonDetailsPage() {
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("*[data-test=\"remove\"]"));
            assertTrue(elements.size() > 0);
        }
        assertEquals("Remove", productsPage.getDetailsRemoveButtonText(), "The button must be \"Remove\"");
    }

    @When("The user clicks on \"Add to cart\" or \"Remove\" Button in the details page")
    public void clickButtonDetailsPage() {
        productsPage.clickDetailsRemoveButton();
    }

    @When("The user clicks on the \"Back to products\" button")
    public void clickBackToProductsButton() {
        driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
    }

    @Then("The product's button should be updated to either \"Add to cart\" or \"Remove\" based on the previous action")
    public void checkButtonUpdate() {
        assertEquals("Add to cart", productsPage.getAddButtonText("sauce-labs-backpack"));
    }

    // Sorting

    @When("The user clicks on the product sorting container")
    public void clickOnProductSortingContainer() {
        productsPage.clickOnSortingContainer();
    }

    @When("The user clicks on option A-Z")
    public void clickOnOptionAZ() {
        productsPage.clickOnSortingOption("A-Z");
    }

    @Then("The products should be sorted in ascending order by name")
    public void checkSortingAZ() {
        HashMap<String,String> namesmap = new HashMap<>( Map.of("Sauce Labs Bike Light","0","Sauce Labs Bolt T-Shirt","1","Sauce Labs Onesie","2","Test.allTheThings() T-Shirt (Red)","3","Sauce Labs Fleece Jacket","5"));
        assertEquals("Sauce Labs Backpack",driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText());
        for (String key : namesmap.keySet()) {
            assertEquals(key,driver.findElement(By.cssSelector("#item_" + namesmap.get(key) + "_title_link > .inventory_item_name")).getText());
        }
    }

    @When("The user clicks on option Z-A")
    public void clickOnOptionZA() {
        productsPage.clickOnSortingOption("Z-A");
    }

    @Then("The products should be sorted in descending order by name")
    public void checkSortingDescending() {
        HashMap<String,String> namesmap = new HashMap<>( Map.of("Sauce Labs Onesie","0","Sauce Labs Fleece Jacket","1","Sauce Labs Bike Light","2","Sauce Labs Backpack","3","Sauce Labs Bolt T-Shirt","5"));
        assertEquals("Test.allTheThings() T-Shirt (Red)",driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText());
        for (String key : namesmap.keySet()) {
            assertEquals(key,driver.findElement(By.cssSelector("#item_" + namesmap.get(key) + "_title_link > .inventory_item_name")).getText());
        }
    }

    @When("The user clicks on option Low-High")
    public void clickOnOptionLowHigh() {
        productsPage.clickOnSortingOption("Low-High");
    }

    @Then("The products should be sorted in ascending order by price")
    public void checkSortingPriceAscending() {
        HashMap<String,String> namesmap = new HashMap<>( Map.of("Sauce Labs Bike Light","0","Sauce Labs Bolt T-Shirt","1","Sauce Labs Onesie","2","Test.allTheThings() T-Shirt (Red)","3","Sauce Labs Fleece Jacket","5"));
        assertEquals("Sauce Labs Backpack",driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText());
        for (String key : namesmap.keySet()) {
            assertEquals(key,driver.findElement(By.cssSelector("#item_" + namesmap.get(key) + "_title_link > .inventory_item_name")).getText());
        }
    }

    @When("The user clicks on option High-Low")
    public void clickOnOptionHighLow() {
        productsPage.clickOnSortingOption("High-Low");
    }

}
