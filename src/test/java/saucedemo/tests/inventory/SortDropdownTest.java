package saucedemo.tests.inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class SortDropdownTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testSortDropdown() {
        System.out.println("Starting sort dropdown test for error_user...");

        try {
            // Step 1: Login with error_user
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("error_user", "secret_sauce");

            // Step 2: Verify that inventory items are displayed
            InventoryPage inventoryPage = new InventoryPage(driver);
            boolean isPageLoaded = inventoryPage.isPageLoaded();
            Assert.assertTrue(isPageLoaded, "Inventory page did not load properly.");
            System.out.println("Inventory page loaded successfully.");

            // Step 3: Interact with the sort dropdown and select "Price (low to high)"
            inventoryPage.selectSortOption("Price (low to high)");

            // Verify items are sorted (you can customize this check by comparing the actual order of items)
            boolean isSortedLowToHigh = inventoryPage.verifyItemsSortedLowToHigh();
            Assert.assertTrue(isSortedLowToHigh, "Items are not sorted from low to high.");
            System.out.println("Items are sorted from low to high.");

            // Step 4: Interact with the sort dropdown and select "Price (high to low)"
            inventoryPage.selectSortOption("Price (high to low)");

            // Verify items are sorted in descending order
            boolean isSortedHighToLow = inventoryPage.verifyItemsSortedHighToLow();
            Assert.assertTrue(isSortedHighToLow, "Items are not sorted from high to low.");
            System.out.println("Items are sorted from high to low.");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an assertion error.");
        } catch (Exception e) {
            System.out.println("Test failed due to an unexpected error: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an unexpected exception.");
        }
    }
}