package integration.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Log
@Getter
public abstract class AbstractResponse {
    public abstract Object getResponseObject() throws IOException, ClassNotFoundException;
    public abstract String getJsonSchemaFileName();

    protected Response response;
    protected String schemaFileName;

    public AbstractResponse(AbstractRequest request) {
        this.response = fetchResponse(request);
    }

    public Response fetchResponse(AbstractRequest request) {
        RequestSpecification requestSpecification = request.getRequestSpecification();

        try {

            switch (request.getType()) {
                case GET:
                    response = RestAssured.given()
                            .spec(requestSpecification)
                            .get(request.getBasePath());

                    break;
                case PUT:
                    response = RestAssured.given()
                            .spec(requestSpecification)
                            .put();
                    break;
                case POST:
                    response = RestAssured.given()
                            .spec(requestSpecification)
                            .post();
                    break;
                case DELETE:
                    response = RestAssured.given()
                            .spec(requestSpecification)
                            .delete();
                    break;
                default:
                    response = null;
            }
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
        log.info(response.asPrettyString());
        Assert.assertEquals(200, getResponseCode());
        return  response;
    }

    public int getResponseCode() {
        return response.getStatusCode();
    }

    protected  <T> List<T> getResponseArray(Class c)
            throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" +c.getName() + ";");
        T[] objects = mapper.readValue(response.asString(), arrayClass);
        log.info("list.size(): " + objects.length);
        return Arrays.asList(objects);
    }

    protected  <T> T getResponseObject(Class c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (T) mapper.readValue(response.asString(), c);
    }

    private String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
