package test.api.dto.response;

import lombok.Data;

@Data
public class SearchResponseDto extends BaseResponseDto {
    public SearchResponseDto() {
        super.setType("search");
    }
}
