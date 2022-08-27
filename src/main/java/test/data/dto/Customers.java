package test.data.dto;

import lombok.Data;

/**
 * Обертка для данных по покупателям
 */
@Data
public final class Customers {
    private Long id;
    private String firstName;
    private String lastName;
}
