package github.scraper.client;

import java.io.IOException;

public interface GitHubService {
    ProjectResponseDto mostStarredProjects() throws IOException;
}
