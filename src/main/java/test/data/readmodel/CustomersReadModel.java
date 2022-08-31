package test.data.readmodel;

import java.util.List;
import java.util.Map;

/**
 * Сервис работы покупателями
 */
public interface CustomersReadModel {
    /**
     * Получить список всех покупателей по Фамилии
     *
     * @param lastName поиск по Фамилии
     * @return список покупателей {@link List}
     */
    List<Map<String, Object>> getAllCustomersByLastName(String lastName);

    /**
     * Получить список покупателей по названию продукта и кол-ву
     * приобретенного продукта
     *
     * @param productName поиск по Названию продукта
     * @param minTimes    мин кол-во покупок продукта
     * @return список покупателей {@link List}
     */
    List<Map<String, Object>> getCustomersByProductNameAndCount(String productName, Integer minTimes);

    /**
     * Получить список покупателей мин и макс
     * приобретенного продукта
     *
     * @param min Минимальная потраченная сумма
     * @param max Максимальная потраченная сумма
     * @return список покупателей {@link List}
     */
    List<Map<String, Object>> getCustomersByMinMaxExpenses(Integer min, Integer max);

    /**
     * Получить список с покупателей
     * с минимальными тратами на продукты
     *
     * @param maxCustomersCount Максимальное ко-во покупателей
     * @return список покупателей {@link List}
     */
    List<Map<String, Object>> getCustomersByMinExpenses(Integer maxCustomersCount);
}
