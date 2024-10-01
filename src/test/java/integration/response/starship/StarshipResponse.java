package integration.response.starship;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Starship;

import java.io.IOException;

public class StarshipResponse extends AbstractResponse {

    public StarshipResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Starship getResponseObject() throws IOException {
        return getResponseObject(Starship.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
