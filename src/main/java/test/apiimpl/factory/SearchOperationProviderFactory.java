package test.apiimpl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.exception.RequestException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public final class SearchOperationProviderFactory {
    @Autowired
    private List<ParameterProvider> parameterProviderList;

    public ParameterProvider getParameterProvider(Set<String> keySet) {

        Optional<ParameterProvider> provider = parameterProviderList
                .stream().filter(x -> keySet.contains(x.getOperationCode().getCode())).findFirst();

        if (!provider.isPresent()) {
            throw new RequestException("Not supported parameter for search request");
        }
        return provider.get();
    }
}
