package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    private By pageTitle = By.cssSelector("*[data-test=\"title\"]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    private By addButton(String product) {
        return By.cssSelector("*[data-test=\"add-to-cart-" + product + "\"]");
    }

    public String getAddButtonText(String product) {
        return driver.findElement(addButton(product)).getText();
    }

    private By removeButton(String product) {
        return By.cssSelector("*[data-test=\"remove-" + product + "\"]");
    }

    public String getRemoveButtonText(String product) {
        return driver.findElement(removeButton(product)).getText();
    }

    private By cartBadge = By.cssSelector("*[data-test=\"shopping-cart-link\"]");

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public void clickAddButton(String product) {
        driver.findElement(addButton(product)).click();
    }

    public void clickRemoveButton(String product) {
        driver.findElement(removeButton(product)).click();
    }
}
