package integration.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractObjectList {
    private int count;
    private String next;
    private String previous;
}
