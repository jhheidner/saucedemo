package saucedemo.tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class InventoryItemCheckoutTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testCheckoutProcessForItemId4() {
        System.out.println("Starting the checkout process test for item ID 4...");

        try {
            // Step 1: Login with standard_user credentials
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");
            System.out.println("Logged in successfully with valid credentials.");

            // Step 2: Navigate to the item page for Sauce Labs Fleece Jacket (id=4)
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickOnItem("Sauce Labs Fleece Jacket");
            System.out.println("Navigated to the inventory item page for 'Sauce Labs Fleece Jacket'.");

            // Step 3: Add the item to the cart
            InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
            inventoryItemPage.clickAddToCart();
            System.out.println("Added 'Sauce Labs Fleece Jacket' to the cart.");

            // Step 4: Go to the Cart page
            inventoryPage.goToCart();
            System.out.println("Navigated to the Cart page.");

            // Step 5: Proceed to checkout
            CartPage cartPage = new CartPage(driver);
            cartPage.proceedToCheckout();
            System.out.println("Proceeded to the Checkout page.");

            // Step 6: Enter checkout details
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.enterCheckoutDetails("Jesse", "Heidner", "37122");
            System.out.println("Entered valid checkout details: First Name, Last Name, and Postal Code.");

            // Step 7: Review and finish on the Checkout Overview page
            CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
            checkoutOverviewPage.clickFinishButton();
            System.out.println("Clicked the 'Finish' button on the Checkout Overview page.");

            // Step 8: Verify the checkout completion message
            CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
            String confirmationMessage = checkoutCompletePage.getConfirmationMessage();
            Assert.assertEquals(confirmationMessage, "Thank you for your order!", "Checkout confirmation does not match.");
            System.out.println("Order completed successfully. Test passed!");

        } catch (AssertionError e) {
            // Catch assertion errors and provide detailed failure output
            System.out.println("Test failed: " + e.getMessage());
            throw e; // Re-throw the exception to mark the test as failed in TestNG
        } catch (Exception e) {
            // Catch any unexpected errors and fail the test with message
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an unexpected exception.");
        }
    }
}
