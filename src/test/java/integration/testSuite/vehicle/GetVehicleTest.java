package integration.testSuite.vehicle;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Vehicle;
import integration.request.vehicle.GetVehicleRequest;
import integration.response.vehicle.VehicleResponse;
import integration.testExecution.TestMarshall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetVehicleTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetVehicleRequest("14");
    }

    @Override
    protected AbstractResponse getResponse() {

        return new VehicleResponse(request);
    }

    @Test
    public void getVehicleTest() throws IOException, ClassNotFoundException {
        Vehicle result = (Vehicle) response.getResponseObject();
        Assert.assertEquals(result.getName(), "Snowspeeder");
    }
}
