package foo.business;

import foo.dto.ProjectsDto;
import io.micronaut.retry.annotation.Fallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

@Fallback
public class FallbackGitHubService implements GitHubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackGitHubService.class);

    @Override
    public ProjectsDto fetchProjectsAndStars() {
        LOGGER.warn("Failed to reach GitHub, someone call them!");
        return new ProjectsDto(Collections.emptyList());
    }
}
