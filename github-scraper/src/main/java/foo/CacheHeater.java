package foo;

import foo.business.GitHubService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CacheHeater {
    private final GitHubService gitHubService;

    @Inject
    public CacheHeater(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    // @Scheduled(fixedDelay = "${micronaut.caches.github-projects-and-stars.expire-after-write}")
    public void heatGitHubCache() {
        gitHubService.fetchProjectsAndStars();
    }
}
