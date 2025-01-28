package saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class BasicLoginTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testStandardUserLogin() {
        System.out.println("Starting basic login test for standard_user...");

        try {
            // Step 1: Navigate to the Login Page
            LoginPage loginPage = new LoginPage(driver);

            // Step 2: Perform login with standard_user credentials
            loginPage.login("standard_user", "secret_sauce");
            System.out.println("Login attempted with standard_user.");

            // Step 3: Verify user is on the Inventory Page
            InventoryPage inventoryPage = new InventoryPage(driver);
            boolean isInventoryPageLoaded = inventoryPage.isInventoryPageDisplayed();
            Assert.assertTrue(isInventoryPageLoaded, "Inventory page did not load successfully after login.");

            System.out.println("Login test passed. Inventory page loaded successfully.");
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
