package foo.business;

import foo.dto.ProjectsDto;

public interface GitHubService {
    ProjectsDto fetchProjectsAndStars();
}
