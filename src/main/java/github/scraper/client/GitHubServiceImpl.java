package github.scraper.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Recoverable;
import io.micronaut.retry.annotation.Retryable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
@Recoverable
public class GitHubServiceImpl implements GitHubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubServiceImpl.class);

    private final GithubClient githubClient;
    private final ObjectMapper objectMapper;

    @Inject
    public GitHubServiceImpl(GithubClient githubClient, ObjectMapper objectMapper) {
        this.githubClient = githubClient;
        this.objectMapper = objectMapper;
    }

    @Cacheable("most-starred-projects")
    @Override
    @Retryable
    @CircuitBreaker
    public ProjectResponseDto mostStarredProjects() throws IOException {
        LOGGER.info("Fetching projects from GitHub");
        String json = githubClient.mostStarredProjects();
        LOGGER.debug("Got JSON '{}'", json);
        return objectMapper.readValue(json, ProjectResponseDto.class);
    }
}
