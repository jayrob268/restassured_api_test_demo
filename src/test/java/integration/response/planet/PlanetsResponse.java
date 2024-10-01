package integration.response.planet;




import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.PlanetList;

import java.io.IOException;

public class PlanetsResponse extends AbstractResponse {

    public PlanetsResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public PlanetList getResponseObject() throws IOException {
        return getResponseObject(PlanetList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "planets.json";
    }

}
