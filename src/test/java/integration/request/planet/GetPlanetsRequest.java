package integration.request.planet;

import integration.request.base.AbstractGetRequest;

public class GetPlanetsRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "planets";
    }

}
