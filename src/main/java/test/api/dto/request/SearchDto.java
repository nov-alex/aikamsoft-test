package test.api.dto.request;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SearchDto {
    private List<Map<String, Object>> criterias;
}
