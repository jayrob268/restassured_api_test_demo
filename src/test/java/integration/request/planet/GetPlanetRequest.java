package integration.request.planet;

import integration.request.base.AbstractGetRequestWithID;

public class GetPlanetRequest extends AbstractGetRequestWithID {

    public GetPlanetRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "planet";
    }
}
