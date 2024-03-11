import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage selectDropdownOption(String option) {
        Select select =  new Select(dropdown);
        select.selectByVisibleText(option);

        System.out.println(select.getFirstSelectedOption().getText());
        return this;
    }
}
