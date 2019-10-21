package github.scraper.rest;

import github.scraper.business.GitHubService;
import github.scraper.rest.dto.ProjectDto;
import github.scraper.rest.dto.ProjectsDto;
import io.micronaut.context.annotation.Primary;

import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
@Primary
public class MockGitHubService implements GitHubService {
    @Override
    public ProjectsDto fetchProjectsAndStars() {
        return new ProjectsDto(Arrays.asList(
                new ProjectDto("project-1", 1),
                new ProjectDto("project-2", 2)
        ));
    }
}
