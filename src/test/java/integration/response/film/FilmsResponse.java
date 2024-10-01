package integration.response.film;




import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.FilmList;

import java.io.IOException;

public class FilmsResponse extends AbstractResponse {

    public FilmsResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public FilmList getResponseObject() throws IOException {
        return getResponseObject(FilmList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return "films.json";
    }

}
