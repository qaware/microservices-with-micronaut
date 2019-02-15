package github.scraper;

import github.scraper.client.GithubService;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class CacheWarmer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheWarmer.class);

    private final GithubService githubService;

    @Inject
    public CacheWarmer(GithubService githubService) {
        this.githubService = githubService;
    }

    @Scheduled(fixedDelay = "30s")
    public void warmCache() throws IOException {
        LOGGER.debug("Warming cache...");
        githubService.mostStarredProjects();
        LOGGER.debug("Warmed cache");
    }
}
