package github.scraper;

import github.scraper.client.GithubService;
import github.scraper.client.ProjectResponseDto;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/projects")
public class ProjectsController {
    private final GithubService github;

    @Inject
    public ProjectsController(GithubService github) {
        this.github = github;
    }

    @Get(value = "/most-stars", produces = MediaType.APPLICATION_JSON)
    public List<ProjectDto> mostStarredProjects() throws IOException {
        ProjectResponseDto response = github.mostStarredProjects();

        return response.getItems().stream()
                .map(i -> new ProjectDto(i.getFullName(), i.getStargazersCount()))
                .sorted(Comparator.comparing(ProjectDto::getStars).reversed())
                .collect(Collectors.toList());
    }
}
