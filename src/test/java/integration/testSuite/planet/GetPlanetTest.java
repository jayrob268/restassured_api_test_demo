package integration.testSuite.planet;


import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Planet;
import integration.request.planet.GetPlanetRequest;
import integration.response.planet.PlanetResponse;
import integration.testExecution.TestMarshall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetPlanetTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetPlanetRequest("1");
    }

    @Override
    protected AbstractResponse getResponse() {
        return new PlanetResponse(request);
    }

    @Test
    public void getPlanetTest() throws IOException, ClassNotFoundException {
        Planet result = (Planet) response.getResponseObject();
        Assert.assertEquals(result.getName(), "Tatooine");

    }
}
