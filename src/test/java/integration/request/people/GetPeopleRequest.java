package integration.request.people;

import integration.request.base.AbstractGetRequest;

public class GetPeopleRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "people";
    }

}
