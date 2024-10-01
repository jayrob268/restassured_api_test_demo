package integration.testSuite.starship;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Starship;
import integration.request.starship.GetStarshipRequest;
import integration.response.starship.StarshipResponse;
import integration.testExecution.TestMarshall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetStarshipTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetStarshipRequest("2");
    }

    @Override
    protected AbstractResponse getResponse() {
        return new StarshipResponse(request);
    }

    @Test
    public void getStarshipTest() throws IOException, ClassNotFoundException {
        Starship result = (Starship) response.getResponseObject();
        Assert.assertEquals(result.getName(), "CR90 corvette");
    }
}
