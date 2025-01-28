package saucedemo.tests.inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class ProblemUserRemoveItemTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testAddAndRemoveItemFromCartFail() {
        System.out.println("Starting test for adding and removing item from cart...");

        try {
            // Step 1: Login as standard user
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("problem_user", "secret_sauce");
            System.out.println("Logged in successfully as standard_user.");

            // Step 2: Add an item to the cart
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.addItemToCart();
            System.out.println("Item added to the cart.");

            // Step 3: Verify the cart badge count has increased to 1
            String cartBadgeCount = inventoryPage.getCartBadgeCount();
            Assert.assertEquals(cartBadgeCount, "1", "Cart badge count is incorrect.");
            System.out.println("Cart badge count is correct: " + cartBadgeCount);

            // Step 4: Remove the item from the cart
            inventoryPage.removeItemFromCart();
            System.out.println("Attempting to remove the item from the cart.");

            // Step 5: Verify the cart badge count has returned to 0
            cartBadgeCount = inventoryPage.getCartBadgeCount();
            Assert.assertEquals(cartBadgeCount, "0", "Cart badge count is still incorrect after removal.");
            System.out.println("Cart badge count is correct after item removal: " + cartBadgeCount);

            // Step 6: Verify no items are present in the cart
            inventoryPage.goToCart();
            CartPage cartPage = new CartPage(driver);
            boolean isItemPresent = cartPage.isItemPresentInCart();
            Assert.assertFalse(isItemPresent, "Item is still present in the cart after removal.");
            System.out.println("No items are present in the cart after removal. Test passed!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e; // Re-throw to mark the test as failed in TestNG
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an unexpected exception.");
        }
    }
}
