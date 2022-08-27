package test.data.repository;

import test.api.dto.response.CustomersResponseDto;
import test.data.dto.Customers;
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
    List<CustomersResponseDto> allByLastName(String lastName);

    /**
     * Получить список всех покупателей по идентификатору
     * @param ids список идентификатор покупателей
     * @return список покупателей {@link Customers}
     */
    List<CustomersResponseDto> allByIds(List<String> ids);
}
