package integration.testSuite.starship;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Starship;
import integration.model.StarshipList;
import integration.request.starship.GetStarshipsRequest;
import integration.response.starship.StarshipsResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Log
public class GetStarshipListTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetStarshipsRequest();
    }

    @Override
    protected AbstractResponse getResponse() {
        return new StarshipsResponse(request);
    }

    @Test
    public void getStarshipsTest() throws IOException, ClassNotFoundException {
        StarshipList result = (StarshipList) response.getResponseObject();

        Assert.assertEquals(result.getCount(), 36);

        List<Starship> results = result.getResults();
        for (Starship starship : results) {
            log.info(starship.getName());
        }
    }
}
