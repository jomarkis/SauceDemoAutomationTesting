package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOVPage extends Page{

    public CheckoutOVPage(WebDriver driver) {
        super(driver);
    }

    private By subTotal = By.cssSelector("*[data-test=\"subtotal-label\"]");
    private By taxes = By.cssSelector("*[data-test=\"tax-label\"]");
    private By total = By.cssSelector("*[data-test=\"total-label\"]");

    private By finishButton = By.cssSelector("*[data-test=\"finish\"]");
    private By cancelButton = By.cssSelector("*[data-test=\"cancel\"]");

    public String getSubTotalText() {
        return driver.findElement(subTotal).getText();
    }

    public String getTaxesText() {
        return driver.findElement(taxes).getText();
    }

    public String getTotalText() {
        return driver.findElement(total).getText();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

}
