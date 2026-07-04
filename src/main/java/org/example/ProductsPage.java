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
}
