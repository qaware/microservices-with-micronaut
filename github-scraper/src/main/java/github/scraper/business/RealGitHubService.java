package github.scraper.business;

import github.scraper.business.client.GitHubClient;
import github.scraper.rest.dto.ProjectDto;
import github.scraper.rest.dto.ProjectsDto;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.retry.annotation.Recoverable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.stream.Collectors;

@Singleton
// I had to explicitly specify FallbackGitHubService here, otherwise it won't work
@Recoverable(api = FallbackGitHubService.class)
public class RealGitHubService implements GitHubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RealGitHubService.class);

    private final GitHubClient gitHubClient;

    @Inject
    public RealGitHubService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @Override
    @Cacheable("github-projects-and-stars")
    public ProjectsDto fetchProjectsAndStars() {
        LOGGER.info("Fetching projects and stars from GitHub");

        return new ProjectsDto(
                gitHubClient.fetchProjectsWithStars().getItems().stream()
                        .map(i -> new ProjectDto(i.getName(), i.getStargazersCount()))
                        .collect(Collectors.toList())
        );
    }
}
