package integration.request.base;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public abstract class AbstractGetRequestWithID extends AbstractGetRequest {

    protected String id;

    @Override
    protected Map<String, Object> getParameters() {
        addParameter("id", id);
        return parameters;
    }

}
