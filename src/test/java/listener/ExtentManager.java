package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.java.Log;

import java.io.IOException;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

@Log
public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest logger;

    public ExtentManager(ExtentReports reports){
        extent = reports;
    }

    public synchronized static ExtentReports getReporter() throws IOException {
        if(extent == null){
            String workingDir = System.getProperty("user.dir");
            ExtentSparkReporter spark = new ExtentSparkReporter(workingDir + "/extentReports/TestResults" + System.getProperty("current.date") + ".html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Host Name", "Host Name");
            extent.setSystemInfo("Environment", "Test Environment");
            extent.setSystemInfo("User Name", "Robin J");
        }
        return extent;
    }

    public synchronized static ExtentTest getLogger(String testCaseName){
        try{
            logger = getReporter().createTest(testCaseName);
        }catch (Exception Ex){
            Ex.printStackTrace();
        }
        return logger;
    }
}
