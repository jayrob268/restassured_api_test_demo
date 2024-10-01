package functional.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import properties.PropertiesReader;

import java.util.Properties;

public class WebdriverFactory {
    protected Properties properties = new PropertiesReader().getTestPropertiesReader();

    public WebDriver webDriver;

    public WebDriver getWebDriver(String browser) {
        if (null == browser || browser.isEmpty()) {
            browser = properties.getProperty("default_browser");
        }
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }


}
