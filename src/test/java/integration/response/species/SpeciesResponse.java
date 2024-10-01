package integration.response.species;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Species;

import java.io.IOException;

public class SpeciesResponse extends AbstractResponse {

    public SpeciesResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Species getResponseObject() throws IOException {
        return getResponseObject(Species.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
