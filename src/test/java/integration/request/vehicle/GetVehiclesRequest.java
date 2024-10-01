package integration.request.vehicle;

import integration.request.base.AbstractGetRequest;

public class GetVehiclesRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "vehicles";
    }

}
