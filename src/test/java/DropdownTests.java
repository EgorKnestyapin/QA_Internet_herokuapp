import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDropdown();
    }

    @Test
    public void selectDropdownOptionTest() {
        new DropdownPage(driver).selectDropdownOption("Option 2");
    }
}
