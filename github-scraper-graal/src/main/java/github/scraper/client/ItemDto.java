package github.scraper.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDto {
    private final int id;
    private final String fullName;
    private final int stargazersCount;

    @JsonCreator
    public ItemDto(@JsonProperty("id") int id, @JsonProperty("full_name") String fullName, @JsonProperty("stargazers_count") int stargazersCount) {
        this.id = id;
        this.fullName = fullName;
        this.stargazersCount = stargazersCount;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }
}