package github.scraper.business;

import github.scraper.rest.dto.ProjectsDto;

public interface GitHubService {
    ProjectsDto fetchProjectsAndStars();
}
