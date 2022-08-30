package test.data.repository;

import test.data.entity.Customers;
import test.data.entity.Products;
import test.data.repository.common.CommonRepository;

import java.util.List;

/**
 * Репозитории для работы с данными Customers
 */
public interface CustomersRepository extends CommonRepository {

    /**
     * Получить список всех покупателей по Фамилии
     *
     * @param lastName поиск по Фамилии
     * @return список покупателей {@link Customers}
     */
    List<Customers> getAllCustomersByLastName(String lastName);

    /**
     * Получить список покупателей по названию продукта и кол-ву
     * приобретенного продукта
     *
     * @param productName поиск по Названию продукта
     * @param minTimes    мин кол-во покупок продукта
     * @return список покупателей {@link Products}
     */
    List<Customers> getCustomersByProductNameAndCount(String productName, Integer minTimes);

    /**
     * Получить список покупателей мин и макс
     * приобретенного продукта
     *
     * @param min Минимальная потраченная сумма
     * @param max Максимальная потраченная сумма
     * @return список покупателей {@link Customers}
     */
    List<Customers> getCustomersByMinMaxExpenses(Integer min, Integer max);

    /**
     * Получить список с покупателей
     * с минимальными тратами на продукты
     *
     * @param maxCustomersCount Максимальное ко-во покупателей
     * @return список покупателей {@link Customers}
     */
    List<Customers> getCustomersByMinExpenses(Integer maxCustomersCount);
}
