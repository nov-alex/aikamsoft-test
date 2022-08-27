package test.apiimpl.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SearchOperationCode implements Parameter {

    SEARCH_BY_LASTNAME("lastName", "Поиск покупателей с этой фамилией"),
    SEARCH_BY_PRODUCTNAME("productName", "Поиск покупателей, купивших этот товар не менее, чем указанное число раз"),
    SEARCH_BY_EXPENSES("minExpenses", "Минимальная и максимальная стоимость всех покупок"),
    SEARCH_BY_BADCUSTOMERS("badCustomers", "Число пассивных покупателей");

    private final String code;
    private final String desc;

}
