package integration.response.people;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.PersonList;

import java.io.IOException;

public class PeopleResponse extends AbstractResponse {

    public PeopleResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public PersonList getResponseObject() throws IOException {
        return getResponseObject(PersonList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "people.json";
    }
}
