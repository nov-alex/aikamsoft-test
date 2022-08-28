package test.api.service;

import test.api.dto.request.StatDto;
import test.api.dto.response.StatResponseDto;

/**
 * Сервис API: Stat
 */
public interface StatService {
    /**
     * Обработка запроса API: stat
     *
     * @param statDto параметры запроса {@link StatDto}
     * @return результат обработки запроса {@link StatResponseDto}
     */
    StatResponseDto processStatRequest(StatDto statDto);
}
