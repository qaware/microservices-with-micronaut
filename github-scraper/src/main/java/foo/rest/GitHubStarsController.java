package foo.rest;

import foo.business.GitHubService;
import foo.rest.dto.ProjectsDto;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.NewSpan;

import javax.inject.Inject;

@Controller("/github")
public class GitHubStarsController {
    private final GitHubService gitHubService;

    @Inject
    public GitHubStarsController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Get("/stars")
    @NewSpan
    public ProjectsDto index() {
        return gitHubService.fetchProjectsAndStars();
    }
}