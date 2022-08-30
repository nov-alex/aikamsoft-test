package test.api.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data

public class StatsProductsDto {
    private List<StatsCustomerProductDto> customers;
    private Double totalExpenses;
    private Double avgExpenses;

    public StatsProductsDto() {
        this.customers = new ArrayList<>();
        this.totalExpenses = 0D;
        this.avgExpenses = 0D;
    }

    public void addCustomer(StatsCustomerProductDto dto) {
        Optional<StatsCustomerProductDto> existDto =
                customers.stream().filter(i -> i.compareTo(dto) == 0).findFirst();
        if (existDto.isPresent()) {
            StatsCustomerProductDto statsCustomerProductDto = existDto.get();
            statsCustomerProductDto.addPurchases(dto);
        } else {
            customers.add(dto);
        }
        totalExpenses += dto.getTotalExpenses();
        avgExpenses = totalExpenses / customers.size();
    }
}
