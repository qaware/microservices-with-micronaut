package github.scraper.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.core.annotation.Blocking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class GithubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GithubService.class);

    private final GithubClient githubClient;
    private final ObjectMapper objectMapper;

    @Inject
    public GithubService(GithubClient githubClient, ObjectMapper objectMapper) {
        this.githubClient = githubClient;
        this.objectMapper = objectMapper;
    }

    @Cacheable("most-starred-projects")
    @Blocking
    public ProjectResponseDto mostStarredProjects() throws IOException {
        LOGGER.info("Fetching projects from GitHub");
        String json = githubClient.mostStarredProjects();
        LOGGER.debug("Got JSON '{}'", json);
        return objectMapper.readValue(json, ProjectResponseDto.class);
    }
}
