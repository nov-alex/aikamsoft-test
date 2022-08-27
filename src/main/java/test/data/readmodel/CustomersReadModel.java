package test.data.readmodel;

import test.data.dto.Customers;

/**
 * Сервис работы покупателями
 */
public interface CustomersReadModel {
    /**
     * Получение данных по покупателю
     *
     * @param id идентификатор покупателя
     * @return данные по покупателю {@link Customers}
     */
    Customers getCustomers(long id);
}
