package test.data.service;

import test.data.dto.Customers;

import java.util.List;

/**
 * Сервис работы с данными покупателей
 */
public interface CustomersService {

    /**
     * Получение списка покупателей по фамилии
     *
     * @param lastName Фамилия покупателя
     * @return данные покупателей
     */
    List<Customers> getCustomersByLastName(String lastName);
}
