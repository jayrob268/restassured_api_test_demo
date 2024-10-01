package integration.request.species;

import integration.request.base.AbstractGetRequest;

public class GetAllSpeciesRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "all_species";
    }

}
