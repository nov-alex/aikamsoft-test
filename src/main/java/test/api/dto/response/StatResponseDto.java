package test.api.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class StatResponseDto extends BaseResponseDto {
    private static final long serialVersionUID = 100L;

    public StatResponseDto() {
        super.setType("stat");
        this.customers = new ArrayList<>();
        this.totalDays = 0;
        this.totalExpenses = 0D;
        this.avgExpenses = 0D;
    }

    private int totalDays;
    private List<Map<String, Object>> customers;
    private double totalExpenses;
    private double avgExpenses;

}
