package foo.business.client;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.tracing.annotation.NewSpan;

@Client("github")
public interface GitHubClient {
    @Get(value = "/search/repositories?q=stars:%3E0&sort=stars&per_page=10", consumes = MediaType.APPLICATION_JSON)
    @Header(name = "User-Agent", value = "Micronaut Demo 0.0.1")
    @NewSpan
    ResultsDto fetchProjectsWithStars();
}
