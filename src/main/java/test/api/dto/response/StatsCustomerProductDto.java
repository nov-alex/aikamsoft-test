package test.api.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class StatsCustomerProductDto implements Serializable, Comparable<StatsCustomerProductDto> {

    private transient Integer id;
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
