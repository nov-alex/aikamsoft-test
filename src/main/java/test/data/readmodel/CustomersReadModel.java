package test.data.readmodel;

import java.util.List;
import java.util.Map;

/**
 * Сервис работы покупателями
 */
public interface CustomersReadModel {
    List<Map<String, Object>> getAllCustomersByLastName(String lastName);

    List<Map<String, Object>> getCustomersByProductNameAndCount(String productName, Integer minTimes);

    List<Map<String, Object>> getCustomersByMinMaxExpenses(Integer min, Integer max);

    List<Map<String, Object>> getCustomersByMinExpenses(Integer maxCustomersCount);
}
