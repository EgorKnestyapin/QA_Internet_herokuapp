import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedirectionPage extends BasePage {
    public RedirectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "redirect")
    WebElement redirect;

    public StatusCodesPage getStatusCodes() {
        click(redirect);
        return new StatusCodesPage(driver);
    }
}
