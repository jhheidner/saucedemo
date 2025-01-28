package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    // Locators for elements on the Cart Page
    private By cartItems = By.cssSelector(".cart_item"); // To check the items in the cart
    private By checkoutButton = By.cssSelector("[data-test='checkout']"); // Button to proceed to checkout
    private By removeItemButton = By.cssSelector(".cart_button"); // Button to remove an item (could be improved based on the item structure)
    private By continueShoppingButton = By.cssSelector("[data-test='continue-shopping']"); // Button to continue shopping

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to verify if an item is present in the cart
    public boolean isItemPresentInCart() {
        try {
            WebElement item = driver.findElement(cartItems);
            return item.isDisplayed();
        } catch (Exception e) {
            System.out.println("No items found in the cart.");
            return false;
        }
    }

    // Method to proceed to the checkout process
    public void proceedToCheckout() {
        try {
            WebElement checkout = driver.findElement(checkoutButton);
            if (checkout.isDisplayed() && checkout.isEnabled()) {
                checkout.click();
                System.out.println("Proceeded to the checkout page.");
            } else {
                System.out.println("Checkout button is not clickable.");
            }
        } catch (Exception e) {
            System.out.println("Error while clicking checkout button: " + e.getMessage());
        }
    }

    // Method to remove an item from the cart (if applicable)
    public void removeItemFromCart() {
        try {
            WebElement removeButton = driver.findElement(removeItemButton);
            if (removeButton.isDisplayed() && removeButton.isEnabled()) {
                removeButton.click();
                System.out.println("Removed an item from the cart.");
            } else {
                System.out.println("Remove button is not clickable.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing item from cart: " + e.getMessage());
        }
    }

    // Method to continue shopping (navigate back to the inventory page)
    public void continueShopping() {
        try {
            WebElement continueShoppingBtn = driver.findElement(continueShoppingButton);
            if (continueShoppingBtn.isDisplayed() && continueShoppingBtn.isEnabled()) {
                continueShoppingBtn.click();
                System.out.println("Navigated back to the Inventory page.");
            } else {
                System.out.println("Continue shopping button is not clickable.");
            }
        } catch (Exception e) {
            System.out.println("Error while continuing shopping: " + e.getMessage());
        }
    }

    // Method to get the total price of the items in the cart
    public String getTotalPrice() {
        try {
            WebElement totalPriceElement = driver.findElement(By.cssSelector(".summary_total_label"));
            return totalPriceElement.getText();
        } catch (Exception e) {
            System.out.println("Error retrieving total price: " + e.getMessage());
            return "$0.00"; // Default if no total price is found
        }
    }

    // Method to get the number of items in the cart
    public int getNumberOfItemsInCart() {
        try {
            return driver.findElements(cartItems).size();
        } catch (Exception e) {
            System.out.println("Error retrieving the number of items in the cart: " + e.getMessage());
            return 0;
        }
    }
}
