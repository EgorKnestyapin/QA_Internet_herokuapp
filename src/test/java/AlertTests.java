import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectJSAlerts();
    }

    @Test
    public void clickForJSAlertTest() {
        new AlertsPage(driver).clickForJSAlert().verifyResult("You successfully clicked an alert");
    }

    @Test
    public void clickForJSConfirmTest() {
        new AlertsPage(driver).clickForJSConfirm("Cancel").verifyResult("You clicked: Cancel");
    }

    @Test
    public void clickForJSPromptTest() {
        new AlertsPage(driver).sendMessageToAlert("I have a pen").verifyResult("You entered: I have a pen");
    }
}
