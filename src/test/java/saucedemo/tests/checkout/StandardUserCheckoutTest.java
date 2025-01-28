package saucedemo.tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class StandardUserCheckoutTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testCheckoutProcess() {
        System.out.println("Starting the checkout process test...");

        try {
            // Step 1: Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");
            System.out.println("Logged in successfully with valid credentials.");

            // Step 2: Add item to cart
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.addItemToCart();
            System.out.println("Added an item to the cart.");
            inventoryPage.goToCart();
            System.out.println("Navigated to the Cart page.");

            // Step 3: Proceed to checkout
            CartPage cartPage = new CartPage(driver);
            cartPage.proceedToCheckout();
            System.out.println("Proceeded to the Checkout page.");

            // Step 4: Enter checkout details
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.enterCheckoutDetails("Jesse", "Heidner", "37122");
            System.out.println("Entered valid checkout details: First Name, Last Name, and Postal Code.");

            // Step 5: Review and finish on the Overview page
            CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
            checkoutOverviewPage.clickFinishButton();
            System.out.println("Clicked the 'Finish' button on the Checkout Overview page.");

            // Step 6: Verify checkout completion
            CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
            String confirmationMessage = checkoutCompletePage.getConfirmationMessage();
            Assert.assertEquals(confirmationMessage, "Thank you for your order!", "Checkout confirmation does not match.");
            System.out.println("Order completed successfully. Test passed!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e; // Re-throw the exception to mark the test as failed in TestNG
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an unexpected exception.");
        }
    }
}
