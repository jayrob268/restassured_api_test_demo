package integration.testSuite.film;


import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Film;
import integration.request.film.GetFilmRequest;
import integration.response.film.FilmResponse;
import integration.testExecution.TestMarshall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetFilmTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetFilmRequest("1");
    }

    @Override
    protected AbstractResponse getResponse() {
        return new FilmResponse(request);
    }

    @Test
    public void getFilmTest() throws IOException, ClassNotFoundException {
        Film result = (Film) response.getResponseObject();

        Assert.assertEquals(result.getTitle(), "A New Hope");
    }

}
