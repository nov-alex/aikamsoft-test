package test.api.factory;

import com.sun.org.apache.xml.internal.serializer.SerializerTrace;

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
