package functional.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public abstract class AbstractWebPage {

    public abstract String getPageUrl();

    protected Map<String, String> data;
    protected WebDriver driver;
    protected int timeout = 30;

    protected final String pageLoadedText = "RANK'S SOCIAL MEDIA";

    public AbstractWebPage() {
    }

    public AbstractWebPage(WebDriver driver) {
        this();
        this.driver = driver;
        driver.switchTo().defaultContent();
        PageFactory.initElements(driver, this);

    }

    public AbstractWebPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public AbstractWebPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    public AbstractWebPage click(WebElement element) {
        verifyElementLoaded(element);
        element.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the WebPage class instance.
     */
    public AbstractWebPage verifyElementLoaded(WebElement element) {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return element.isDisplayed();
            }
        });
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the WebPage class instance.
     */
    public AbstractWebPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the WebPage class instance.
     */
    public AbstractWebPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(getPageUrl());
            }
        });
        return this;
    }
}
