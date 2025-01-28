package saucedemo.tests.inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class InventoryItemPageTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testInventoryItemDetails() {
        try {
            // Login with standard_user credentials
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            // Navigate to the inventory page
            InventoryPage inventoryPage = new InventoryPage(driver);

            // Click on "Sauce Labs Bolt T-Shirt"
            inventoryPage.clickOnItem("Sauce Labs Bolt T-Shirt");

            // Instantiate the inventory item page
            InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);

            // Verify the title of the item
            String expectedTitle = "Sauce Labs Bolt T-Shirt";
            String actualTitle = inventoryItemPage.getItemTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Item title does not match.");
            System.out.println("Success: Item title matches expected title.");

            // Verify the description of the item
            String expectedDescription = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
            String actualDescription = inventoryItemPage.getItemDescription();
            Assert.assertEquals(actualDescription, expectedDescription, "Item description does not match.");
            System.out.println("Success: Item description matches expected description.");

            // Verify the price of the item
            String expectedPrice = "$15.99";
            String actualPrice = inventoryItemPage.getItemPrice();
            Assert.assertEquals(actualPrice, expectedPrice, "Item price does not match.");
            System.out.println("Success: Item price matches expected price.");

        } catch (AssertionError e) {
            // Print failure message for debugging
            System.err.println("Test failed: " + e.getMessage());
            throw e;
        }
    }
}
