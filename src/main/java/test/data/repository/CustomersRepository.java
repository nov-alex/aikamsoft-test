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
    List<Customers> allByLastName(String lastName);

    /**
     * Получить список всех покупателей по идентификатору
     *
     * @param ids список идентификатор покупателей
     * @return список покупателей {@link Customers}
     */
    List<Customers> allByIds(List<Integer> ids);

    /**
     * Получить список покупателей по названию продукта и кол-ву
     * приобретенного продукта
     *
     * @param productName поиск по Названию продукта
     * @param minTimes    мин кол-во покупок продукта
     * @return список покупателей {@link Products}
     */
    List<Customers> getCustomersIdsByProductNameAndCount(String productName, Long minTimes);
}
