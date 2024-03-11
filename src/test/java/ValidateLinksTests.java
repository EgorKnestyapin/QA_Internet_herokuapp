import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getRedirection();
        new RedirectionPage(driver).getStatusCodes();
    }

    @Test
    public void validateLinksTest() {
        new StatusCodesPage(driver).validateLinks();
    }
}
