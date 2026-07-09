package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    private By pageTitle = By.cssSelector("*[data-test=\"title\"]");
    private By menuButton = By.id("react-burger-menu-btn");

    // Menu Buttons

    private By menuAllItems = By.cssSelector("*[data-test=\"inventory-sidebar-link\"]");
    private By menuAbout = By.cssSelector("*[data-test=\"about-sidebar-link\"]");
    private By menuLogout = By.cssSelector("*[data-test=\"logout-sidebar-link\"]");
    private By menuResetAppState =By.cssSelector("*[data-test=\"reset-sidebar-link\"]");

    // Menu Button Getters

    public By  getMenuButton() {
        return menuButton;
    }

    public By getMenuAllItems() {
        return menuAllItems;
    }

    public By getMenuAbout() {
        return menuAbout;
    }

    public By getMenuLogout() {
        return menuLogout;
    }

    public By getMenuResetAppState()
    {
        return menuResetAppState;
    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    public By addButton(String product) {
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

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    // Click Menu buttons

    public void clickMenuAllItems() {
        driver.findElement(menuAllItems).click();
    }

    public void clickMenuAbout() {
        driver.findElement(menuAbout).click();
    }

    public void clickMenuLogout() {
        driver.findElement(menuLogout).click();
    }

    public void clickMenuResetAppState() {
        driver.findElement(menuResetAppState).click();
    }
}
