package com.example.demo.business;

import com.example.demo.business.client.GitHubClient;
import com.example.demo.rest.dto.ProjectDto;
import com.example.demo.rest.dto.ProjectsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RealGitHubService implements GitHubService {
    private final GitHubClient gitHubClient;

    @Autowired
    public RealGitHubService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @Override
    @Cacheable(value = "github-projects-and-stars", sync = true)
    public ProjectsDto fetchProjectsAndStars() {
        return new ProjectsDto(
                gitHubClient.fetchProjectsWithStars().getItems().stream()
                        .map(i -> new ProjectDto(i.getName(), i.getStargazersCount()))
                        .collect(Collectors.toList())
        );
    }
}
