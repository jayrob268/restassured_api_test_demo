package integration.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends AbstractObject {
    private String name;
    private Double height;
    private Double mass;
    private String hair_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private URL homeworld;
    private List<URL> films;
    private List<URL> species;
    private List<URL> vehicles;
    private List<URL> starships;
}
