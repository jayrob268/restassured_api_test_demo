package integration.response.people;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Person;

import java.io.IOException;

public class PersonResponse extends AbstractResponse {

    public PersonResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Person getResponseObject() throws IOException {
        return getResponseObject(Person.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "person.json";
    }

}
