package github.scraper.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.jackson.annotation.JacksonFeatures;

import java.util.ArrayList;
import java.util.List;

public class ProjectResponseDto {
    private final int totalCount;
    private final List<ItemDto> items;

    @JsonCreator
    public ProjectResponseDto(@JsonProperty("total_count") int totalCount, @JsonProperty("items") List<ItemDto> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
