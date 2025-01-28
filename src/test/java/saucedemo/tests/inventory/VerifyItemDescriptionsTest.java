package saucedemo.tests.inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class VerifyItemDescriptionsTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testItemDescriptionFail() {
        // Login with standard_user credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Navigate to the inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Verify description for Sauce Labs Backpack
        String backpackDescription = inventoryPage.getItemDescription("Sauce Labs Backpack");
        String expectedBackpackDescription = "Carry All the Things with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        try {
            Assert.assertEquals(backpackDescription, expectedBackpackDescription, "Backpack description is incorrect.");
            System.out.println("Test passed: Description for Sauce Labs Backpack is correct.");
        } catch (AssertionError e) {
            System.err.println("Test failed: Description for Sauce Labs Backpack is incorrect.");
            throw e;
        }
    }
        @Test
        public void testItemDescriptionsPass() {

            // Login with standard_user credentials
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            // Navigate to the inventory page
            InventoryPage inventoryPage = new InventoryPage(driver);

        // Verify description for Sauce Labs Bike Light
        String bikeLightDescription = inventoryPage.getItemDescription("Sauce Labs Bike Light");
        String expectedBikeLightDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";

        try {
            Assert.assertEquals(bikeLightDescription, expectedBikeLightDescription, "Bike Light description is incorrect.");
            System.out.println("Test passed: Description for Sauce Labs Bike Light is correct.");
        } catch (AssertionError e) {
            System.err.println("Test failed: Description for Sauce Labs Bike Light is incorrect.");
            throw e;
        }
    }
}
