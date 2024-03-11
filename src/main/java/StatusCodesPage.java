import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class StatusCodesPage extends BasePage {
    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public StatusCodesPage validateLinks() {
        for (WebElement allLink : allLinks) {
            String url = allLink.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            System.out.println(url + " is link with status code " + httpURLConnection.getResponseCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
