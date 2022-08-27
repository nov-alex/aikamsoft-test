package test.apiimpl.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import test.api.dto.request.SearchDto;
import test.api.dto.response.BaseResponseDto;
import test.api.dto.response.SearchResponseDto;
import test.api.service.SearchService;
import test.apiimpl.factory.SearchOperationProviderFactory;
import test.data.service.CustomersService;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SearchServiceImpl implements SearchService {

    private final CustomersService customersService;
    private final SearchOperationProviderFactory searchOperationProviderFactory;

    @Override
    public BaseResponseDto processSearchRequest(SearchDto searchDto) {


        return new SearchResponseDto();
    }
}
