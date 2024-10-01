package integration.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship extends AbstractObject {
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private Long cargo_capacity;
    private String consumables;
    private Double hyperdrive_rating;
    private Integer MGLT;
    private String starship_class;
    private List<URL> pilots;
    private List<URL> films;
}
