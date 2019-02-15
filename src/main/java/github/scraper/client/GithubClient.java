package github.scraper.client;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

@Client("github")
public interface GithubClient {
    @Get(value = "/search/repositories?q=stars%3A%3E0&sort=stars&per_page=10", consumes = MediaType.APPLICATION_JSON)
    @Header(name = "User-Agent", value = "Micronaut Demo")
    String mostStarredProjects();
}
