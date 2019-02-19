package foo.rest;

import foo.business.GitHubService;
import foo.dto.ProjectDto;
import foo.dto.ProjectsDto;
import io.micronaut.context.annotation.Primary;
import io.micronaut.context.annotation.Replaces;

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
