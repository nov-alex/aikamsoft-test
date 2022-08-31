package test.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(value = {"id"})
public class StatsCustomerProductDto implements Comparable<StatsCustomerProductDto> {

    private Integer id;
    private String name;
    private List<Map<String, Object>> purchases;
    private Double totalExpenses;

    public StatsCustomerProductDto() {
        this.purchases = new ArrayList<>();
        this.totalExpenses = 0D;
    }

    @Override
    public int compareTo(StatsCustomerProductDto o) {
        return getId().compareTo(o.getId());
    }

    public void addPurchases(StatsCustomerProductDto dto) {
        purchases.addAll(dto.getPurchases());
        totalExpenses += dto.getTotalExpenses();
    }
}
