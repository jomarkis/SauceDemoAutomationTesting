package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ProductsPage extends Page {

    private By detailsName = By.cssSelector("*[data-test=\"inventory-item-name\"]");

    private HashMap<String,String> productDetails = new HashMap<>(Map.of("backpack","carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","bike-light","A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","bolt-t-shirt","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","fleece-jacket","It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","onesie","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","testallthethings", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."));
    private HashMap<String,String> productPrices = new HashMap<>(Map.of("backpack","$29.99","bike-light","$9.99","bolt-t-shirt","$15.99","fleece-jacket","$49.99","onesie","$7.99","testallthethings", "$15.99"));

    // Details Page Buttons

    private By detailsAddButton = By.cssSelector("*[data-test=\"add-to-cart\"]");
    private By detailsRemoveButton = By.cssSelector("*[data-test=\"remove\"]");

    // Sorting

    private By sortingcontainer = By.cssSelector("*[data-test=\"product-sort-container\"]");

    // Details Page Getters

    public String getDetailsAddButtonText() {
        return driver.findElement(detailsAddButton).getText();
    }
    public String getDetailsRemoveButtonText() {
        return driver.findElement(detailsRemoveButton).getText();
    }

    public void clickDetailsAddButton() {
        driver.findElement(detailsAddButton).click();
    }

    public void clickDetailsRemoveButton() {
        driver.findElement(detailsRemoveButton).click();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public By addButton(String product) {
        return By.cssSelector("*[data-test=\"add-to-cart-" + product + "\"]");
    }

    public String getAddButtonText(String product) {
        return driver.findElement(addButton(product)).getText();
    }

    public By removeButton(String product) {
        return By.cssSelector("*[data-test=\"remove-" + product + "\"]");
    }

    public String getRemoveButtonText(String product) {
        return driver.findElement(removeButton(product)).getText();
    }

    public void clickAddButton(String product) {
        driver.findElement(addButton(product)).click();
    }

    public void clickRemoveButton(String product) {
        driver.findElement(removeButton(product)).click();
    }


    public void clickOnName(String product) {
        HashMap<String,Integer> namecodes = new HashMap<>( Map.of("bike-light",0,"bolt-t-shirt",1,"onesie",2,"Test.allTheThings()",3,"fleece-jacket",5));
        if (product.equals("backpack")) {
            driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).click();
        } else {
            driver.findElement(By.cssSelector("#item_" + namecodes.get(product) + "_title_link > .inventory_item_name")).click();
        }
    }

    public String getProductDetails(String product) {
        return productDetails.get(product);
    }

    public String getProductPrices(String product) {
        return productPrices.get(product);
    }

    // Sorting

    public void clickOnSortingContainer() {
        driver.findElement(sortingcontainer).click();
    }

    public void clickOnSortingOption(String option) {
        HashMap<String,String> optionsmap = new HashMap<>(Map.of("A-Z", "1","Z-A","2","Low-High","3","High-Low","4"));
        driver.findElement(By.cssSelector("option:nth-child("+optionsmap.get(option)+")")).click();
    }
}
