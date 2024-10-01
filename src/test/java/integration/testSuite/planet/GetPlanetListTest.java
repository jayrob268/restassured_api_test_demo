package integration.testSuite.planet;


import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Planet;
import integration.model.PlanetList;
import integration.request.planet.GetPlanetsRequest;
import integration.response.planet.PlanetsResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Log
public class GetPlanetListTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetPlanetsRequest();
    }

    @Override
    protected AbstractResponse getResponse() {
        return new PlanetsResponse(request);
    }

    @Test
    public void getPlanetsTest() throws IOException, ClassNotFoundException {
        PlanetList result = (PlanetList) response.getResponseObject();
        Assert.assertEquals(result.getCount(), 60);
        List<Planet> planets = result.getResults();
        for (Planet planet : planets) {
            log.info(planet.getName());
        }
    }
}
