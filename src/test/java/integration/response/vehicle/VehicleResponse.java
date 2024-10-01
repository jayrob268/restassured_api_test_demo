package integration.response.vehicle;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Vehicle;

import java.io.IOException;

public class VehicleResponse extends AbstractResponse {

    public VehicleResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Vehicle getResponseObject() throws IOException {
        return getResponseObject(Vehicle.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
