package github.scraper.business;

import github.scraper.business.client.GitHubClient;
import github.scraper.rest.dto.ProjectDto;
import github.scraper.rest.dto.ProjectsDto;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.retry.annotation.Recoverable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.stream.Collectors;

@Singleton
@Recoverable
public class RealGitHubService implements GitHubService {
    private final GitHubClient gitHubClient;

    @Inject
    public RealGitHubService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @Override
    @Cacheable("github-projects-and-stars")
    public ProjectsDto fetchProjectsAndStars() {
        return new ProjectsDto(
                gitHubClient.fetchProjectsWithStars().getItems().stream()
                        .map(i -> new ProjectDto(i.getName(), i.getStargazersCount()))
                        .collect(Collectors.toList())
        );
    }
}
