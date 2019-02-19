package foo.business.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultsDto {
    private List<ResultDto> items;

    @JsonCreator
    public ResultsDto(@JsonProperty("items") List<ResultDto> items) {
        this.items = items;
    }

    public List<ResultDto> getItems() {
        return items;
    }
}
