package integration.request.starship;

import integration.request.base.AbstractGetRequest;

public class GetStarshipsRequest extends AbstractGetRequest {

    @Override
    protected String getEndpointkey() {
        return "starships";
    }

}
