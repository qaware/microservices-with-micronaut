package github.scraper;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ProjectDto {
    private final String name;
    private final int stars;

    @JsonCreator
    public ProjectDto(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }
}
