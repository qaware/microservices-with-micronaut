package com.example.demo.rest;

import com.example.demo.business.GitHubService;
import com.example.demo.rest.dto.ProjectsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class GitHubStarsController {
    private final GitHubService gitHubService;

    @Autowired
    public GitHubStarsController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/stars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProjectsDto index() {
        return gitHubService.fetchProjectsAndStars();
    }

}
