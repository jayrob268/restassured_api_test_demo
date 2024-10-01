package integration.client;

import integration.constants.RequestType;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import properties.PropertiesReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Log
@NoArgsConstructor
public abstract class AbstractRequest {

    protected abstract RequestType getRequestType();
    protected abstract Map<String, String> getHeaders();
    protected abstract Object getRequestBody();
    protected abstract String getEndpointkey();
    protected abstract Map<String, Object> getParameters();

    protected Properties properties = new PropertiesReader().getApiPropertiesReader();

    public RequestType requestType = getRequestType();
    public Map<String, String> requestHeaders;
    public Object requestBody;
    public Map<String, Object> parameters;

    protected String basePath = properties.getProperty(getEndpointkey());

    public RequestSpecification getRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestHeaders = getHeaders();
        requestBody = getRequestBody();
        parameters = getParameters();

        if (null == requestHeaders) {
//            log.info("No headers");
//            requestSpecBuilder.addHeader("Content-Type", "application/json");
        } else {
            requestSpecBuilder.addHeaders(requestHeaders);
        }

        if (null == parameters) {
//            log.info("No parameters");
        } else {
//            log.info("No of parameters: " + parameters.size());
            requestSpecBuilder.addPathParams(parameters);
        }

        if (null == requestBody) {
//            log.info("request body is null");
        } else {
            String requestBodyString = getJsonString(requestBody);
            log.info("requestBodyString: " + requestBodyString);
            requestSpecBuilder.setBody(requestBodyString);
        }

        return requestSpecBuilder.build();
    }

    public String getBasePath() {
        log.info(RestAssured.basePath);
        log.info("endpoint: " + basePath + RestAssured.basePath);
//        log.info(RestAssured.rootPath);

        return basePath;
    }

    public RequestType getType() {
        return requestType;
    }

    protected String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected void addHeader(String headerName, String headerValue) {
        if (null == requestHeaders) requestHeaders = new HashMap<>();
        requestHeaders.put(headerName, headerValue);
    }

    protected void addParameter(String parameter, Object value) {
        if (null == parameters) parameters = new HashMap<>();
        parameters.put(parameter, value);
//        log.info("parameter.toString(), value: " + parameter + ", " + value);
    }
}
