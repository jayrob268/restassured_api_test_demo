package integration.testSuite.vehicle;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Vehicle;
import integration.model.VehicleList;
import integration.request.vehicle.GetVehiclesRequest;
import integration.response.vehicle.VehiclesResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Log
public class GetVehicleListTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetVehiclesRequest();
    }

    @Override
    protected AbstractResponse getResponse() {
        return new VehiclesResponse(request);
    }

    @Test
    public void getVehiclesTest() throws IOException, ClassNotFoundException {
        VehicleList result = (VehicleList) response.getResponseObject();
        Assert.assertEquals(result.getCount(), 39);
        List<Vehicle> results = result.getResults();
        for (Vehicle vehicle : results) {
            log.info(vehicle.getName());
        }

    }
}
