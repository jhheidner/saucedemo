package saucedemo.tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class StandardUserNegativeCheckoutTests extends BaseTest {

    @Test (groups = {"regression"})
    public void testCheckoutWithoutFirstName() {
        System.out.println("Starting the negative test: Attempting to proceed with checkout without providing a First Name...");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Logged in successfully with valid credentials.");

        // Step 2: Add item to the cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        System.out.println("Added an item to the cart.");
        inventoryPage.goToCart();
        System.out.println("Navigated to the Cart page.");

        // Step 3: Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        System.out.println("Proceeded to the Checkout page.");

        // Step 4: Enter invalid checkout details (missing first name)
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails(null, "TestLastName", "12345");
        System.out.println("Attempted to proceed with checkout by leaving the First Name field empty.");

        // Step 5: Verify the error message
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(
                errorMessage,
                "Error: First Name is required",
                "Error message does not match the expected validation message."
        );
        System.out.println("Test passed: Error message was displayed correctly - " + errorMessage);
    }

    @Test
    public void testCheckoutWithoutLastName() {
        System.out.println("Starting the negative test: Attempting to proceed with checkout without providing a Last Name...");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Logged in successfully with valid credentials.");

        // Step 2: Add item to the cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        System.out.println("Added an item to the cart.");
        inventoryPage.goToCart();
        System.out.println("Navigated to the Cart page.");

        // Step 3: Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        System.out.println("Proceeded to the Checkout page.");

        // Step 4: Enter invalid checkout details (missing last name)
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("TestFirstName", null, "12345");
        System.out.println("Attempted to proceed with checkout by leaving the Last Name field empty.");

        // Step 5: Verify the error message
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(
                errorMessage,
                "Error: Last Name is required",
                "Error message does not match the expected validation message."
        );
        System.out.println("Test passed: Error message was displayed correctly - " + errorMessage);
    }

    @Test
    public void testCheckoutWithoutPostalCode() {
        System.out.println("Starting the negative test: Attempting to proceed with checkout without providing a Postal Code...");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Logged in successfully with valid credentials.");

        // Step 2: Add item to the cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        System.out.println("Added an item to the cart.");
        inventoryPage.goToCart();
        System.out.println("Navigated to the Cart page.");

        // Step 3: Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        System.out.println("Proceeded to the Checkout page.");

        // Step 4: Enter invalid checkout details (missing postal code)
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("TestFirstName", "TestLastName", null);
        System.out.println("Attempted to proceed with checkout by leaving the Postal Code field empty.");

        // Step 5: Verify the error message
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(
                errorMessage,
                "Error: Postal Code is required",
                "Error message does not match the expected validation message."
        );
        System.out.println("Test passed: Error message was displayed correctly - " + errorMessage);
    }

    @Test
    public void testCheckoutWithoutAllFields() {
        System.out.println("Starting the negative test: Attempting to proceed with checkout without providing any required fields...");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Logged in successfully with valid credentials.");

        // Step 2: Add item to the cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        System.out.println("Added an item to the cart.");
        inventoryPage.goToCart();
        System.out.println("Navigated to the Cart page.");

        // Step 3: Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        System.out.println("Proceeded to the Checkout page.");

        // Step 4: Enter invalid checkout details (all fields missing)
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails(null, null, null);
        System.out.println("Attempted to proceed with checkout by leaving all required fields empty.");

        // Step 5: Verify the error message
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(
                errorMessage,
                "Error: First Name is required",
                "Error message does not match the expected validation message."
        );
        System.out.println("Test passed: Error message was displayed correctly - " + errorMessage);
    }
}
