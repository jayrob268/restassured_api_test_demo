package integration.testSuite.species;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Species;
import integration.request.species.GetSpeciesRequest;
import integration.response.species.SpeciesResponse;
import integration.testExecution.TestMarshall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetSpeciesTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetSpeciesRequest("1");
    }

    @Override
    protected AbstractResponse getResponse() {
        return new SpeciesResponse(request);
    }

    @Test
    public void getSpeciesTest() throws IOException, ClassNotFoundException {
        Species result = (Species) response.getResponseObject();
        Assert.assertEquals(result.getName(), "Human");

    }
}
