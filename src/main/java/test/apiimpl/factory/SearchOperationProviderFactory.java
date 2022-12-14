package test.apiimpl.factory;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.factory.SearchParameterProvider;
import test.exception.RequestException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public final class SearchOperationProviderFactory {

    private final List<SearchParameterProvider> parameterProviderList;

    public SearchParameterProvider getParameterProvider(Set<String> keySet) {

        Optional<SearchParameterProvider> provider = parameterProviderList
                .stream()
                .filter(x -> keySet.equals(x.getOperationCode().getRequestParameters()))
                .findFirst();

        if (!provider.isPresent()) {
            throw new RequestException("Not supported parameter for search request. Parameters: " + keySet);
        }
        return provider.get();
    }
}
