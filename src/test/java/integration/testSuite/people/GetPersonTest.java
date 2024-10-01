package integration.testSuite.people;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Person;
import integration.request.people.GetPersonRequest;
import integration.response.people.PersonResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Log
public class GetPersonTest extends TestMarshall {

    @Override
    protected AbstractRequest getRequest() {
        return new GetPersonRequest("2");
    }

    @Override
    protected AbstractResponse getResponse() {
        return new PersonResponse(request);
    }

    @Test
    public void getPersonTest() throws IOException, ClassNotFoundException {
//        PersonResponse response = (PersonResponse) this.response;
        Person result = (Person) response.getResponseObject();

        log.info("person.getName(): " + result.getName());

        Assert.assertEquals(result.getName(), "C-3PO");

//        validateSchema(response.getResponse(), "person.json");
    }
}
