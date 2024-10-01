package integration.testSuite.film;


import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Film;
import integration.model.FilmList;
import integration.request.film.GetFilmsRequest;
import integration.response.film.FilmsResponse;
import integration.testExecution.TestMarshall;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Log
public class GetFilmListTest extends TestMarshall {
    @Override
    protected AbstractRequest getRequest() {
        return new GetFilmsRequest();
    }

    @Override
    protected AbstractResponse getResponse() {
        return new FilmsResponse(request);
    }

    @Test
    public void getFilmsTest() throws IOException, ClassNotFoundException {
        FilmList result = (FilmList) response.getResponseObject();

        Assert.assertEquals(result.getCount(), 6);

        List<Film> films = result.getResults();
        for (Film film : films) {
            log.info(film.getTitle());
        }
    }
}
