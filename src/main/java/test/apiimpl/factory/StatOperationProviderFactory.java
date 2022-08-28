package test.apiimpl.factory;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.factory.StatParameterProvider;
import test.exception.RequestException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public final class StatOperationProviderFactory {
    private final List<StatParameterProvider> parameterProviderList;

    public StatParameterProvider getParameterProvider(Set<String> keySet) {

        Optional<StatParameterProvider> provider = parameterProviderList
                .stream()
                .filter(x -> keySet.equals(x.getOperationCode().getRequestParameters()))
                .findFirst();

        if (!provider.isPresent()) {
            throw new RequestException("Not supported parameter for stat request. Parameters: " + keySet);
        }
        return provider.get();
    }
}
