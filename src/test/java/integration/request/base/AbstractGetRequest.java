package integration.request.base;

import integration.client.AbstractRequest;
import integration.constants.RequestType;

import java.util.Map;

public abstract class AbstractGetRequest extends AbstractRequest {

    @Override
    protected RequestType getRequestType() {
        return RequestType.GET;
    }

    @Override
    protected Map<String, String> getHeaders() {
        return null;
    }

    @Override
    protected Object getRequestBody() {
        return null;
    }

    @Override
    protected Map<String, Object> getParameters() {
        return null;
    }
}
