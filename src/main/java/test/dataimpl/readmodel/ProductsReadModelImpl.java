package test.dataimpl.readmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.dto.response.StatsCustomerProductDto;
import test.api.dto.response.StatsProductsDto;
import test.data.readmodel.ProductsReadModel;
import test.data.repository.ProductsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductsReadModelImpl implements ProductsReadModel {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public StatsProductsDto getProductsByDateIntervalDesc(LocalDate startDate, LocalDate endDate) {

        List<Object[]> resObjects = productsRepository.getProductsByDateIntervalDesc(startDate, endDate);

        StatsProductsDto statsProductsDto = new StatsProductsDto();
        for (Object[] row : resObjects) {
            StatsCustomerProductDto statsCustomerProductDto = new StatsCustomerProductDto();
            statsCustomerProductDto.setId((Integer) row[4]);
            statsCustomerProductDto.setName(row[2] + " " + row[3]);
            statsCustomerProductDto.setTotalExpenses(Double.valueOf((String) row[1]));
            List<Map<String, Object>> listPurchases = new ArrayList<>();
            Map<String, Object> mapPurchase = new LinkedHashMap<>();
            mapPurchase.put("name", (String) row[0]);
            mapPurchase.put("expenses", Double.valueOf((String) row[1]));
            listPurchases.add(mapPurchase);
            statsCustomerProductDto.setPurchases(listPurchases);
            statsProductsDto.addCustomer(statsCustomerProductDto);
        }

        return statsProductsDto;
    }
}
