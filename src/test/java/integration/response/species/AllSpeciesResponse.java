package integration.response.species;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.SpeciesList;

import java.io.IOException;

public class AllSpeciesResponse extends AbstractResponse {

    public AllSpeciesResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public SpeciesList getResponseObject() throws IOException {
        return getResponseObject(SpeciesList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
