package foo.business;

import foo.rest.dto.ProjectsDto;

public interface GitHubService {
    ProjectsDto fetchProjectsAndStars();
}
