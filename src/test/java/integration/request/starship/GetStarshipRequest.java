package integration.request.starship;

import integration.request.base.AbstractGetRequestWithID;

public class GetStarshipRequest extends AbstractGetRequestWithID {

    public GetStarshipRequest(String id) {
        super(id);
    }

    @Override
    protected String getEndpointkey() {
        return "starship";
    }
}
