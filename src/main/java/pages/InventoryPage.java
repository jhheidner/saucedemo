package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    // Locators for elements on the Inventory Page
    private By productItems = By.cssSelector(".inventory_item"); // All items displayed on the inventory page
    private By addToCartButtons = By.cssSelector(".btn_inventory"); // Buttons to add items to the cart
    private By removeItemButtons = By.cssSelector(".btn_inventory.remove"); // Buttons to remove items from the cart
    private By cartBadge = By.cssSelector(".shopping_cart_badge"); // Cart badge indicating number of items in the cart
    private By sortDropdown = By.cssSelector(".product_sort_container"); // The sort dropdown
    private By priceElements = By.cssSelector(".inventory_item_price"); // Price elements
    private By firstItemImage = By.xpath("(//img[@class='inventory_item_img'])[1]");
    private final String INVENTORY_PAGE_URL = "https://www.saucedemo.com/inventory.html";

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Checks if the Inventory Page is displayed by verifying the current URL.
     *
     * @return true if the current URL matches the expected Inventory Page URL, false otherwise.
     */
    public boolean isInventoryPageDisplayed() {
        try {
            return driver.getCurrentUrl().equals(INVENTORY_PAGE_URL);
        } catch (Exception e) {
            return false; // Return false if any exception occurs
        }
    }

    // Method to add the first item to the cart (this can be adjusted to target any item based on index)
    public void addItemToCart() {
        try {
            List<WebElement> addButtons = driver.findElements(addToCartButtons);
            if (!addButtons.isEmpty()) {
                addButtons.get(0).click(); // Adds the first item in the list
                System.out.println("Item added to the cart.");
            } else {
                System.out.println("No 'Add to Cart' buttons found on the page.");
            }
        } catch (Exception e) {
            System.out.println("Error while adding item to the cart: " + e.getMessage());
        }
    }

    // Method to add a specific item to the cart (by index)
    public void addItemToCart(int index) {
        try {
            List<WebElement> addButtons = driver.findElements(addToCartButtons);
            if (index < addButtons.size()) {
                addButtons.get(index).click(); // Adds the item at the specified index
                System.out.println("Item " + (index + 1) + " added to the cart.");
            } else {
                System.out.println("Index out of bounds: No item at index " + index);
            }
        } catch (Exception e) {
            System.out.println("Error while adding item to the cart: " + e.getMessage());
        }
    }

    // Method to remove an item from the cart (removes the first item found)
    public void removeItemFromCart() {
        try {
            List<WebElement> removeButtons = driver.findElements(removeItemButtons);
            if (!removeButtons.isEmpty()) {
                removeButtons.get(0).click(); // Removes the first item in the list
                System.out.println("Item removed from the cart.");
            } else {
                System.out.println("No 'Remove' buttons found on the page.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing item from the cart: " + e.getMessage());
        }
    }

    // Method to get the count of items in the cart (returns the badge number)
    public String getCartBadgeCount() {
        try {
            WebElement badge = driver.findElement(cartBadge);
            return badge.getText();
        } catch (Exception e) {
            System.out.println("Error retrieving cart badge count: " + e.getMessage());
            return "0"; // Default if badge is not found or is empty
        }
    }

    // Method to verify if a specific item is present in the cart
    public boolean isItemPresentInCart() {
        try {
            WebElement item = driver.findElement(By.cssSelector(".cart_item"));
            return item.isDisplayed();
        } catch (Exception e) {
            System.out.println("No items found in the cart.");
            return false;
        }
    }
    // Method to get the src attribute of the first item's image
    public String getFirstItemImageSrc() {
        WebElement imageElement = driver.findElement(firstItemImage);
        return imageElement.getAttribute("src");

    }

    // Method to get the description of a specific item by name
    public String getItemDescription(String itemName) {
        List<WebElement> itemContainers = driver.findElements(By.className("inventory_item"));
        for (WebElement item : itemContainers) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(itemName)) {
                return item.findElement(By.className("inventory_item_desc")).getText();
            }
        }
        throw new RuntimeException("Item with name '" + itemName + "' not found on the inventory page.");
    }

    // Method to select a sort option from the dropdown
    public void selectSortOption(String option) {
        try {
            WebElement sortDropdownElement = driver.findElement(sortDropdown);
            sortDropdownElement.click();
            WebElement sortOption = driver.findElement(By.xpath("//option[text()='" + option + "']"));
            sortOption.click();
            System.out.println("Sort option selected: " + option);
        } catch (Exception e) {
            System.out.println("Error selecting sort option: " + e.getMessage());
        }
    }

    // Method to verify if the items are sorted from low to high by price
    public boolean verifyItemsSortedLowToHigh() {
        try {
            List<WebElement> priceElementsList = driver.findElements(priceElements);
            double previousPrice = -1;

            for (WebElement priceElement : priceElementsList) {
                double currentPrice = Double.parseDouble(priceElement.getText().replace("$", ""));
                if (currentPrice < previousPrice) {
                    System.out.println("Items are not sorted in ascending order.");
                    return false;
                }
                previousPrice = currentPrice;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error verifying items sorted low to high: " + e.getMessage());
            return false;
        }
    }

    // Method to verify if the items are sorted from high to low by price
    public boolean verifyItemsSortedHighToLow() {
        try {
            List<WebElement> priceElementsList = driver.findElements(priceElements);
            double previousPrice = Double.MAX_VALUE;

            for (WebElement priceElement : priceElementsList) {
                double currentPrice = Double.parseDouble(priceElement.getText().replace("$", ""));
                if (currentPrice > previousPrice) {
                    System.out.println("Items are not sorted in descending order.");
                    return false;
                }
                previousPrice = currentPrice;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error verifying items sorted high to low: " + e.getMessage());
            return false;
        }
    }

    public void clickOnItem(String itemName) {
        // Wait for the page to load and the target element to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By itemLocator = By.xpath("//div[@data-test='inventory-item-name' and text()='" + itemName + "']");

        try {
            // Scroll into view and click the element
            WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
            wait.until(ExpectedConditions.elementToBeClickable(item)).click();
        } catch (Exception e) {
            System.err.println("Failed to find or click on item: " + itemName);
            throw e;
        }
    }

    // Method to navigate to the cart page
    public void goToCart() {
        try {
            WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
            cartIcon.click();
            System.out.println("Navigated to the cart page.");
        } catch (Exception e) {
            System.out.println("Error navigating to the cart: " + e.getMessage());
        }
    }

    // Method to check if the inventory page is loaded (optional check for page readiness)
    public boolean isPageLoaded() {
        try {
            return driver.findElement(productItems).isDisplayed();
        } catch (Exception e) {
            System.out.println("Error: Inventory page is not loaded properly.");
            return false;
        }
    }
}
