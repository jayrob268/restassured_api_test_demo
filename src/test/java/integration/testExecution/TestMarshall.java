package integration.testExecution;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import properties.PropertiesReader;
import reporting.ReportUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Log
public abstract class TestMarshall {

    protected abstract AbstractRequest getRequest();
    protected abstract AbstractResponse getResponse();

    protected AbstractRequest request;
    protected AbstractResponse response;

    protected Properties properties = new PropertiesReader().getApiPropertiesReader();
    public static ReportUtil reportUtil = new ReportUtil();

    @BeforeSuite
    public void setupBaseURL(ITestContext context) {
        RestAssured.baseURI = properties.getProperty("base_uri");
        RestAssured.basePath = properties.getProperty("base_path");
    }

//    @BeforeTest
//    @BeforeClass

    @BeforeMethod
    public void setUp(Method method) throws IOException {
        reportUtil.setUp(method);

        this.request = getRequest();
        this.response = getResponse();

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        reportUtil.addResult(result);
    }

//    @AfterClass

    @AfterTest
    public void tearDown() {
        reportUtil.writeResult();
    }

//    @AfterSuite


    //common
    public void validateSchema(Response response, String filename) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                    ValidationConfiguration.newBuilder()
                            .setDefaultVersion(SchemaVersion.DRAFTV4)
                            .freeze())
                .freeze();

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(filename)
                        .using(jsonSchemaFactory));
    }

}
