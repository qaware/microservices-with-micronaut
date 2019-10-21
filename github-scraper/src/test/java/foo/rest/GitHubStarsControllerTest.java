package foo.rest;

import foo.rest.dto.ProjectsDto;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GitHubStarsControllerTest {

    @Test
    public void testIndex() throws Exception {
        try (EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
            try (RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
                HttpResponse<ProjectsDto> result = client.toBlocking().exchange("/github/stars", ProjectsDto.class);

                assertThat((CharSequence) result.getStatus()).isEqualTo(HttpStatus.OK);
                assertThat(result.getBody()).isPresent();
                assertThat(result.getBody().get().getProjects()).hasSize(2);
            }
        }
    }
}
