package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYIPage extends Page{

    public CheckoutYIPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.cssSelector("*[data-test=\"firstName\"]");
    private By lastName = By.cssSelector("*[data-test=\"lastName\"]");
    private By postalCode = By.cssSelector("*[data-test=\"postalCode\"]");

    private By continueButton = By.cssSelector("*[data-test=\"continue\"]");

    public void enterFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        driver.findElement(this.postalCode).sendKeys(postalCode);
    }

    public String getFirstNameValue(){
        return driver.findElement(firstName).getAttribute("value");
    }

    public String getLastNameValue(){
        return driver.findElement(lastName).getAttribute("value");
    }

    public String getPostalCodeValue(){
        return driver.findElement(postalCode).getAttribute("value");
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
}
