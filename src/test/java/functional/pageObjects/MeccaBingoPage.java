package functional.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@Getter
public class MeccaBingoPage extends AbstractWebPage {
    public MeccaBingoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "https://www.meccabingo.com/";
    }

    @FindBy(css = "button[class*='login-button']")
    @CacheLookup
    public WebElement loginButton;

    @FindBy(css = "div[class*='slideout-overlay-heading'] > h4")
    @CacheLookup
    public WebElement loginText;

}
