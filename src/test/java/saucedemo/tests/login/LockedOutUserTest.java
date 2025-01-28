package saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LockedOutUserTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testLockedOutUserLogin() {
        System.out.println("Starting the test for the locked_out_user...");

        try {
            // Step 1: Initialize the login page
            LoginPage loginPage = new LoginPage(driver);

            // Step 2: Attempt login with locked_out_user
            loginPage.login("locked_out_user", "secret_sauce");

            // Step 3: Verify error message
            String errorMessage = loginPage.getErrorMessage();
            String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
            Assert.assertEquals(errorMessage, expectedMessage, "Error message does not match the expected message.");
            System.out.println("The correct error message was displayed: " + errorMessage);
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
