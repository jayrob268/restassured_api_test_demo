package integration.request.species;

import integration.request.base.AbstractGetRequestWithID;

public class GetSpeciesRequest extends AbstractGetRequestWithID {

    public GetSpeciesRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "species";
    }
}
