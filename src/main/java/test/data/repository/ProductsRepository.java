package test.data.repository;

import test.data.entity.Customers;
import test.data.entity.Products;
import test.data.repository.common.CommonRepository;

import java.util.List;
import java.util.Map;

/**
 * Репозитории для работы с данными Продукты
 */
public interface ProductsRepository extends CommonRepository {
    /**
     * Получить продукт по названию
     *
     * @param productName поиск по Названию продукта
     * @return список покупателей {@link Products}
     */
    List<Object[]> getCustomersIdsByProductName(String productName, int minTimes);
}
