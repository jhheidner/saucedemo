package saucedemo.tests.inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

import java.net.HttpURLConnection;
import java.net.URL;

public class InventoryImageTests extends BaseTest {

    @Test (groups = {"regression"})
    public void testFirstImageWithStandardUser() {
        // Login with standard_user credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Navigate to the inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Get the src attribute of the first image
        String actualImageSrc = inventoryPage.getFirstItemImageSrc();

        // Expected image source for standard_user
        String expectedImageSrc = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";

        // Verify the image src matches the expected value
        Assert.assertEquals(actualImageSrc, expectedImageSrc, "Image source does not match the expected value for standard_user.");

        // Verify the image is accessible
        Assert.assertTrue(isImageAccessible(actualImageSrc), "The image is not accessible or the URL is broken for standard_user.");
    }

    @Test (groups = {"regression"})
    public void testFirstImageWithVisualUser() {
        // Login with visual_user credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("visual_user", "secret_sauce");

        // Navigate to the inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Get the src attribute of the first image
        String actualImageSrc = inventoryPage.getFirstItemImageSrc();

        // Expected image source for visual_user
        String expectedImageSrc = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg";

        // Verify the image src matches the expected value
        Assert.assertEquals(actualImageSrc, expectedImageSrc, "Image source does not match the expected value for visual_user.");

        // Verify the image is accessible
        Assert.assertTrue(isImageAccessible(actualImageSrc), "The image is not accessible or the URL is broken for visual_user.");
    }

    // Method to check if an image URL is accessible
    private boolean isImageAccessible(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode == 200; // Returns true if image is accessible
        } catch (Exception e) {
            System.out.println("Error while checking image accessibility: " + e.getMessage());
            return false;
        }
    }
}
