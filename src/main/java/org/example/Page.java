package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    private By pageTitle = By.cssSelector("*[data-test=\"title\"]");
    private By cartBadge = By.cssSelector("*[data-test=\"shopping-cart-link\"]");
    private By menuButton = By.id("react-burger-menu-btn");

    private By menuAllItems = By.cssSelector("*[data-test=\"inventory-sidebar-link\"]");
    private By menuAbout = By.cssSelector("*[data-test=\"about-sidebar-link\"]");
    private By menuLogout = By.cssSelector("*[data-test=\"logout-sidebar-link\"]");
    private By menuResetAppState = By.cssSelector("*[data-test=\"reset-sidebar-link\"]");

    public String getTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public void clickCartBadge() {
        driver.findElement(cartBadge).click();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

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

    public By getMenuButton() { return menuButton; }
    public By getMenuAllItems() { return menuAllItems; }
    public By getMenuAbout() { return menuAbout; }
    public By getMenuLogout() { return menuLogout; }
    public By getMenuResetAppState() { return menuResetAppState; }
}