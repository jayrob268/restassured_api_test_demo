package integration.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet extends AbstractObject {

    private String name;
    private Integer rotation_period;
    private Long orbital_period;
    private Long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private List<URL> residents;
    private List<URL> films;
}
