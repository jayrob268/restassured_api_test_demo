package integration.response.film;




import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.Film;

import java.io.IOException;

public class FilmResponse extends AbstractResponse {

    public FilmResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public Film getResponseObject() throws IOException {
        return getResponseObject(Film.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "film.json";
    }

}
