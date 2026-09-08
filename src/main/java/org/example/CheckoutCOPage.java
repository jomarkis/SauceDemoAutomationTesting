package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCOPage extends Page{
    public CheckoutCOPage(WebDriver driver) {
        super(driver);
    }

    private By backtohomeButton = By.cssSelector("*[data-test=\"back-to-products\"]");

    private By finalMessage = By.cssSelector("*[data-test=\"complete-header\"]");

    public String getFinalMessageText(){
        return driver.findElement(finalMessage).getText();
    }

    public void clickBackToHome() {
        driver.findElement(backtohomeButton).click();
    }

}
