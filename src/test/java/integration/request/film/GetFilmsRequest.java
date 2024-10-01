package integration.request.film;

import integration.request.base.AbstractGetRequest;

public class GetFilmsRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "films";
    }

}
