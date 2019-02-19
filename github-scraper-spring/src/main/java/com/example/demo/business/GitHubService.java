package com.example.demo.business;

import com.example.demo.rest.dto.ProjectsDto;

public interface GitHubService {
    ProjectsDto fetchProjectsAndStars();
}
