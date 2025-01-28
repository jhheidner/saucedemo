package saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class PerformanceLoginTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testLoginPerformance() {
        System.out.println("Starting login performance test for performance_glitch_user...");

        // Capture the start time of the login process
        long startTime = System.currentTimeMillis();

        try {
            // Step 1: Login with performance_glitch_user
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("performance_glitch_user", "secret_sauce");

            // Capture the end time after login
            long endTime = System.currentTimeMillis();

            // Calculate the time taken to log in
            long timeTaken = endTime - startTime;
            System.out.println("Login time for performance_glitch_user: " + timeTaken + " milliseconds.");

            // Optional: Assert that the login took less than an acceptable time (e.g., 2000 ms)
            Assert.assertTrue(timeTaken < 2000, "Login took longer than expected. Time taken: " + timeTaken + "ms");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an unexpected exception.");
        }
    }
}
