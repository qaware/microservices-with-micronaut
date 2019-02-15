package github.scraper.client;

import io.micronaut.retry.annotation.Fallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;

@Fallback
public class FallbackGitHubService implements GitHubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackGitHubService.class);

    @Override
    public ProjectResponseDto mostStarredProjects() throws IOException {
        LOGGER.warn("GitHubService failed, using fallback!");
        return new ProjectResponseDto(1, Collections.singletonList(
                new ItemDto(1, "fallback/fallback", 42)
        ));
    }
}
