package test.data.repository;

import test.data.repository.common.CommonRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Репозитории для работы с данными Продукты
 */
public interface ProductsRepository extends CommonRepository {

    /**
     *  Cтатистика покупок по покупателям за период из двух дат,
     *  включительно, без выходных. Упорядочено по убыванию
     * @param startDate начальная дата
     * @param endDate конечная дата
     * @return Список покупок покупателями
     */

    List<Object[]> getProductsByDateIntervalDesc(LocalDate startDate, LocalDate endDate);

}
