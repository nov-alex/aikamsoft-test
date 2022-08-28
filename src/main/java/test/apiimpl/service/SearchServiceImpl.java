package test.apiimpl.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.dto.request.SearchDto;
import test.api.dto.response.SearchResponseDto;
import test.api.service.SearchService;
import test.api.factory.ParameterProvider;
import test.apiimpl.factory.SearchOperationProviderFactory;
import test.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SearchServiceImpl implements SearchService {

    private final SearchOperationProviderFactory searchOperationProviderFactory;

    @Override
    public SearchResponseDto processSearchRequest(SearchDto searchDto) throws RequestException {
        SearchResponseDto responseDto = new SearchResponseDto();
        for (Map<String, Object> criteria : searchDto.getCriterias()){
            ParameterProvider provider = searchOperationProviderFactory.getParameterProvider(criteria.keySet());
            Map<String, Object> result = new HashMap<>();
            result.put("criteria", criteria);
            result.put("results", provider.get(criteria));
            responseDto.addResults( result );
        }
        return responseDto;
    }
}
