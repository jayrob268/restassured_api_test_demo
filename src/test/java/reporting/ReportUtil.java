package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import listener.ExtentManager;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtil {
    public static String testCaseName = null;
    public static ExtentTest extentTest = null;
    public static ExtentManager extentManager = null;
    public static ExtentReports extentReports = null;

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
        System.setProperty("current.date", dateFormat.format(new Date()));
    }

    public static void setUp(Method method) throws IOException {
        testCaseName = method.getName();
        extentManager = new ExtentManager(extentReports);
        extentReports = ExtentManager.getReporter();
        extentTest = ExtentManager.getLogger(testCaseName);
    }

    public void addResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test case SKIPPED due to below issues:", ExtentColor.GREY));
            extentTest.skip(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test case PASSED.", ExtentColor.GREEN));
        }
    }

    public void writeResult() {
        extentReports.flush();
    }

}
