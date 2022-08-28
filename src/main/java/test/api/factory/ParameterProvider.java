package test.api.factory;

import java.util.List;
import java.util.Map;

/**
 * Обеспечивает унифицированный доступ фабрики к Provider
 */
public interface ParameterProvider {

    /**
     * Предоставить параметры поддерживаемой операции
     *
     * @return параметры операции {@link Parameter}
     */
    Parameter getOperationCode();

    /**
     * Выдает результат поддерживаемой операции
     *
     * @param operationParameter параметры операции из запроса
     * @return результат
     */
    List<Map<String, Object>> get(Map<String, Object> operationParameter);
}
