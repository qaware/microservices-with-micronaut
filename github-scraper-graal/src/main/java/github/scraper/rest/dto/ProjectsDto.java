package github.scraper.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProjectsDto {
    private final List<ProjectDto> projects;

    @JsonCreator
    public ProjectsDto(@JsonProperty("projects") List<ProjectDto> projects) {
        this.projects = projects;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }
}
