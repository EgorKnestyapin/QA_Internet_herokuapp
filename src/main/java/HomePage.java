import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/javascript_alerts']")
    WebElement jsAlerts;

    public AlertsPage selectJSAlerts() {
        click(jsAlerts);
//        clickWithJS(jsAlerts, 0, 200); for small screens
        return new AlertsPage(driver);
    }
}
