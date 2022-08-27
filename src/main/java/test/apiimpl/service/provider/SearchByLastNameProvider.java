package test.apiimpl.service.provider;

import org.springframework.stereotype.Component;
import test.apiimpl.factory.Parameter;
import test.apiimpl.factory.ParameterProvider;

import java.io.Serializable;
import java.util.Map;

import static test.apiimpl.factory.SearchOperationCode.SEARCH_BY_LASTNAME;

@Component
public final class SearchByLastNameProvider implements ParameterProvider {
    @Override
    public Parameter getOperationCode() {
        return SEARCH_BY_LASTNAME;
    }

    @Override
    public Serializable get(Map<String, Object> operationParameter) {
        return null;
    }
}
