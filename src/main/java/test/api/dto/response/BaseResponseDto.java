package test.api.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
}
