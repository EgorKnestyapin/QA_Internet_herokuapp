import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class AlertsPage extends HomePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    WebElement jsAlert;

    @FindBy(id = "result")
    WebElement result;

    @FindBy(xpath = "//*[text()='Click for JS Confirm']")
    WebElement jsConfirm;

    @FindBy(xpath = "//*[text()='Click for JS Prompt']")
    WebElement jsPrompt;

    public AlertsPage clickForJSAlert() {
        click(jsAlert);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                .accept();
        return this;
    }

    public AlertsPage clickForJSConfirm(String confirm) {
        click(jsConfirm);
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        if (confirm != null && confirm.equals("Ok")) {
            alert.accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            alert.dismiss();
        }
        return this;
    }

    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }

    public AlertsPage sendMessageToAlert(String text) {
        click(jsPrompt);
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }
}
