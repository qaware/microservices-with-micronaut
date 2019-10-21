package github.scraper.business.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDto {
    private final String name;
    private final int stargazersCount;

    @JsonCreator
    public ResultDto(@JsonProperty("name") String name, @JsonProperty("stargazers_count") int stargazersCount) {
        this.name = name;
        this.stargazersCount = stargazersCount;
    }

    public String getName() {
        return name;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }
}
