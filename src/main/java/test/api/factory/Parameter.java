package test.api.factory;

import java.util.Set;

/**
 * Предоставляет коды поддерживаемых операции в запросах
 */
public interface Parameter {

    /**
     * Получить параметры операции запроса
     *
     * @return список параметров операции
     */
    Set<String> getRequestParameters();

    /**
     * Получить описание поддерживаемой операции
     *
     * @return описание операции
     */
    String getDesc();
}
