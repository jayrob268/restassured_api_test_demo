package integration.request.film;

import integration.request.base.AbstractGetRequestWithID;

public class GetFilmRequest extends AbstractGetRequestWithID {

    public GetFilmRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "film";
    }
}
