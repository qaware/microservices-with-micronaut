package foo.rest;

import foo.business.GitHubService;
import foo.dto.ProjectsDto;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/github")
public class GitHubStarsController {
    private final GitHubService gitHubService;

    @Inject
    public GitHubStarsController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Get("/stars")
    public ProjectsDto index() {
        return gitHubService.fetchProjectsAndStars();
    }
}