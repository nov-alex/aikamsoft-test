package test.api.factory;

import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

/**
 * Перечисляет все поддерживаемые операции и их параметры
 */
@AllArgsConstructor
@Getter
public enum OperationCode implements Parameter {

    SEARCH_BY_LASTNAME(ImmutableSet.of("lastName"), "Поиск покупателей с этой фамилией"),
    SEARCH_BY_PRODUCTNAME(ImmutableSet.of("productName", "minTimes"), "Поиск покупателей, купивших этот товар не менее, чем указанное число раз"),
    SEARCH_BY_EXPENSES(ImmutableSet.of("minExpenses", "maxExpenses"), "Минимальная и максимальная стоимость всех покупок"),
    SEARCH_BY_BADCUSTOMERS(ImmutableSet.of("badCustomers"), "Число пассивных покупателей"),

    STAT_BY_DATE_INTERVAL(ImmutableSet.of("startDate", "endDate"), "Статистика по покупателям за период из двух дат, включительно, без выходных");

    private final Set<String> requestParameters;
    private final String desc;

}
