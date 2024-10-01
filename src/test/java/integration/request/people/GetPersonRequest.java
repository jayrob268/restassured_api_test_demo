package integration.request.people;

import integration.request.base.AbstractGetRequestWithID;

public class GetPersonRequest extends AbstractGetRequestWithID {

    public GetPersonRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "person";
    }
}
