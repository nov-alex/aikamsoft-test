package test.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
public class SearchResponseDto extends BaseResponseDto {
    private List<Map<String, Object>> results;

    public SearchResponseDto() {
        super.setType("search");
        this.results = new ArrayList<>();
    }

    public void addResults(Map<String, Object> res) {
        this.results.add(res);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SearchResponseDto that = (SearchResponseDto) o;
        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), results);
    }
}
