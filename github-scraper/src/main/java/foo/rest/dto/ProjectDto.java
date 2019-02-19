package foo.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDto {
    private final String name;
    private final long stars;

    @JsonCreator
    public ProjectDto(@JsonProperty("name") String name, @JsonProperty("stars") long stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public long getStars() {
        return stars;
    }
}
