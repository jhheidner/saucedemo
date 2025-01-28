package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        if (firstName != null) {
            driver.findElement(firstNameField).sendKeys(firstName);
        }
        if (lastName != null) {
            driver.findElement(lastNameField).sendKeys(lastName);
        }
        if (postalCode != null) {
            driver.findElement(postalCodeField).sendKeys(postalCode);
        }
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
