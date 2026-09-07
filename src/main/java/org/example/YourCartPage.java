package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends Page {
    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    private By continueShopping = By.cssSelector("*[data-test=\"continue-shopping\"]");

    public By removeButton(String product) {
        return By.cssSelector("*[data-test=\"remove-" + product + "\"]");
    }

    public String getRemoveButtonText(String product) {
        return driver.findElement(removeButton(product)).getText();
    }

    public void clickRemoveButton(String product) {
        driver.findElement(removeButton(product)).click();
    }
}
