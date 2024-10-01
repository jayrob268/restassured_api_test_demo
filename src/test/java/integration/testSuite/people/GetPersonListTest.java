package integration.testSuite.people;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Person;
import integration.request.people.GetPeopleRequest;
import integration.response.people.PeopleResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Log
public class GetPersonListTest extends TestMarshall {

    @Override
    protected AbstractRequest getRequest() {
        return new GetPeopleRequest();
    }

    @Override
    protected AbstractResponse getResponse() {
        return new PeopleResponse(request);
    }

    @Test
    public void getPeopleTest() throws IOException {
        PeopleResponse response = (PeopleResponse) this.response;

        List<Person> results = response.getResponseObject().getResults();

        for (Person person : results) {
            log.info("person.getName(): " + person.getName());
        }
    }
}
