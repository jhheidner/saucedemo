# saucedemo
Automated Test Suite for SauceDemo

This project contains an automated test suite for testing the SauceDemo web application. The suite includes 10+ tests, including end-to-end tests that verify login, inventory navigation, adding items to the cart, and completing the checkout process.

Prerequisites

Before you can build and execute the test cases, ensure you have the following installed on your machine:

1. Java Development Kit (JDK)

   - Version: 8 or higher
   - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. Maven

   - Version: 3.6 or higher
   - [Download Maven](https://maven.apache.org/download.cgi)

3. Google Chrome

   - Latest version installed

4. ChromeDriver

   - Version compatible with your installed Google Chrome browser
   - [Download ChromeDriver](https://chromedriver.chromium.org/downloads)

5. IDE (Optional)

   - IntelliJ IDEA or Eclipse for easier project navigation

Project Structure

- src/main/java/
  - Contains utility classes, page classes, and reusable components.
- src/test/java
  - Contains test cases organized by feature Package files (checkout, inventory, login).
- resources/TestSuites
  - Full Regression Suite is housed here to run all test cases instead of individually
- pom.xml
  - Maven configuration file for managing dependencies.

Setup Instructions

- Clone the Repository
  - git clone repository-url
  - cd repository-folder

- Configure ChromeDriver Path - Update the path to ChromeDriver in the `BaseTest` class:
  - System.setProperty("webdriver.chrome.driver", "<path-to-chromedriver>");
  
- Install Dependencies - Run the following command to install all dependencies:
  - mvn clean install

How to Execute Test Cases

- Using Maven Command Line

  - Run All Tests:
    mvn test

  - Run a Specific Test Class:
    mvn -Dtest=<TestClassName> test

  -   Example:
   mvn -Dtest=StandardUserCheckoutTest test


2. Using an IDE

1. Open the project in IntelliJ IDEA or Eclipse.
2. Navigate to the `src/test/java` directory.
3. Right-click on a test class and select **Run** or **Debug** to execute the test.
4. To Run All test cases go to resources > TestSuites > Right-click on "FullRegressionSuite.xml"


Test Scenarios Included

1. Login Test
   - Verifies that a standard user can log in successfully and is on Inventory Page.

3.  Full Checkout Process Test ((InventoryItemCheckoutTest, StandarUserCheckoutTest)
   - Covers the entire checkout process from logging into the website, inventory page, from adding an item to the cart to completing the order.
   - Separate test that goes to the inventory item page and completes checkout flow.

4. Negative Checkout Tests
   - Tests that check various combinations of missing information during checkout process, including First Name, Last Name, and Zip Code missing.

5. Inventory Image verification
   - Covers whether the image is correct, one test for standar_user and one test for visual_user

7. Locked Out User Test
   - Verifies error message given with user that is locked out when attempting to log into the website

8. Performance Test
   - Test how quickly the performance_glitch user takes to log into the website

9. Remove Cart Item Test
   - Tests whether an item can be added and removed on the inventory page (tested with problem_user)

10. Check sorting functionality
    - Test to check sorting Functionality

11. Item Description verification
   - Checks two different items for the proper descriptions on the inventory page


Reporting

After test execution, reports are generated in the `target/surefire-reports` directory. You can view the reports to analyze test results.


Troubleshooting

Common Errors:

1. Element Not Found Error:

   - Ensure that the element identifiers (e.g., XPath or CSS) in the page classes are correct.
   - Confirm that the page has fully loaded before interacting with elements.

2. ChromeDriver Version Mismatch:

   - Ensure your ChromeDriver version matches the version you installed on your Google Chrome browser.

Debugging:

- Use `System.out.println` statements to log intermediate steps.
- Run tests in debug mode from the IDE to set breakpoints and inspect issues.


Contributing

1. Fork the repository.
2. Create a new feature branch:

   git checkout -b feature/your-feature-name

3. Commit your changes:

   git commit -m "Add your message here"
 
4. Push your branch:

   git push origin feature/your-feature-name

5. Submit a pull request.

