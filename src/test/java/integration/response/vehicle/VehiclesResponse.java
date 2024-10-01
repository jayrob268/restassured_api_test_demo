package integration.response.vehicle;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.VehicleList;

import java.io.IOException;

public class VehiclesResponse extends AbstractResponse {

    public VehiclesResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public VehicleList getResponseObject() throws IOException {
        return getResponseObject(VehicleList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
