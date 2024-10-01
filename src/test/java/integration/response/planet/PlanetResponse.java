package integration.response.planet;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Planet;

import java.io.IOException;

public class PlanetResponse extends AbstractResponse {

    public PlanetResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Planet getResponseObject() throws IOException {
        return getResponseObject(Planet.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "planet.json";
    }

}
