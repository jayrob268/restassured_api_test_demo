package integration.response.starship;

import integration.client.AbstractRequest;
import integration.client.AbstractResponse;
import integration.model.StarshipList;

import java.io.IOException;

public class StarshipsResponse extends AbstractResponse {

    public StarshipsResponse(AbstractRequest request) {
        super(request);
    }

    @Override
    public StarshipList getResponseObject() throws IOException {
        return getResponseObject(StarshipList.class);
    }

    @Override
    public String getJsonSchemaFileName() {
        return null;
    }

}
