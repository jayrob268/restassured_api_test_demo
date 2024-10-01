package functional.testBase;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import properties.PropertiesReader;
import reporting.ReportUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

@ExtendWith(SeleniumJupiter.class)
public abstract class TestBase {

    protected static ReportUtil reportUtil = new ReportUtil();
    protected Properties properties = new PropertiesReader().getTestPropertiesReader();

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebdriverFactory webdriverFactory = new WebdriverFactory();

    @BeforeSuite
    public static void setupSuite() {

//        WebDriverManager.chromedriver().setup();
    }

    @Parameters(value = {"browser"})
    @BeforeTest
    public void setupTest(@Optional String browser) {
        driver.set(webdriverFactory.getWebDriver(browser));
    }

    @BeforeMethod
    public void setUp(Method method) throws IOException {
        reportUtil.setUp(method);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        reportUtil.addResult(result);
    }

//    @AfterClass

    @AfterTest
    public void tearDown() {
        reportUtil.writeResult();
        getDriver().quit();
    }

    @AfterSuite
    public void terminate() {
        driver.remove();
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

}
