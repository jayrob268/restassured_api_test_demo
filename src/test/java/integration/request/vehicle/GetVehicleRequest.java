package integration.request.vehicle;

import integration.request.base.AbstractGetRequestWithID;

public class GetVehicleRequest extends AbstractGetRequestWithID {

    public GetVehicleRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "vehicle";
    }
}
