package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage {
    private WebDriver driver;

    // Locators for common elements on the inventory item page
    private By itemTitle = By.className("inventory_details_name");
    private By itemDescription = By.className("inventory_details_desc");
    private By itemPrice = By.className("inventory_details_price");
    private By addToCartButton = By.className("btn_inventory");
    private By backToProductsButton = By.id("back-to-products");

    // Constructor
    public InventoryItemPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the title of the item
    public String getItemTitle() {
        return driver.findElement(itemTitle).getText();
    }

    // Method to get the description of the item
    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }

    // Method to get the price of the item
    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    // Method to click the "Add to Cart" button
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Method to check if the "Add to Cart" button is displayed
    public boolean isAddToCartButtonDisplayed() {
        return driver.findElement(addToCartButton).isDisplayed();
    }

    // Method to click the "Back to Products" button
    public void clickBackToProducts() {
        driver.findElement(backToProductsButton).click();
    }

    // Method to check if the "Back to Products" button is displayed
    public boolean isBackToProductsButtonDisplayed() {
        return driver.findElement(backToProductsButton).isDisplayed();
    }
}
