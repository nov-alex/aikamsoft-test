package test.api.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class SearchResponseDto extends BaseResponseDto {
    private static final long serialVersionUID = 100L;

    public SearchResponseDto() {
        super.setType("search");
        this.results = new ArrayList<>();
    }

    private List<Map<String, Object>> results;

    public void addResults(Map<String, Object> res) {
        this.results.add(res);
    }
}
