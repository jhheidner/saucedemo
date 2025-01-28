package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;

    // Locators
    private By confirmationMessage = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
