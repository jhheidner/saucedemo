package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;

    // Locators
    private By finishButton = By.xpath("//button[@id='finish']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
