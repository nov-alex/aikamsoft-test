package test.api.dto.response;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ErrorResponseDto extends BaseResponseDto {
    private final String message;

    public ErrorResponseDto(String message) {
        super.setType("search");
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ErrorResponseDto that = (ErrorResponseDto) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }
}
