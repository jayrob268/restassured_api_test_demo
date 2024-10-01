package functional.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@Getter
public class RankInternational extends AbstractWebPage {



    public RankInternational(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "https://www.rank.com/";
    }

    @FindBy(linkText = "meccabingo.com")
    @CacheLookup
    private WebElement meccaBingoLink;

}
