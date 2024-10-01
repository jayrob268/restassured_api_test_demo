package integration.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle extends AbstractObject{

    private String name;
    private String model;
    private String manufacturer;
    private Double length;
    private Long max_atmosphering_speed;
    private Integer crew;
    private Integer passengers;
    private String cargo_capacity;
    private String vehicle_class;
    private List<URL> pilots;
    private List<URL> films;
}
