package test.api.service;

import test.api.dto.request.SearchDto;
import test.api.dto.response.BaseResponseDto;

/**
 * Сервис API: Search
 */
public interface SearchService {

    /**
     * Обработка запроса API: search
     *
     * @param searchDto параметры запроса {@link SearchDto}
     * @return результат обработки запроса {@link BaseResponseDto}
     */
    BaseResponseDto processSearchRequest(SearchDto searchDto);
}
