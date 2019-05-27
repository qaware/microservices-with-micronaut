package com.example.demo;

import com.example.demo.business.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheCheater {
    private final GitHubService gitHubService;

    @Autowired
    public CacheHeater(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Scheduled(fixedDelay = 30_000)
    public void heatGitHubCache() {
        gitHubService.fetchProjectsAndStars();
    }
}
