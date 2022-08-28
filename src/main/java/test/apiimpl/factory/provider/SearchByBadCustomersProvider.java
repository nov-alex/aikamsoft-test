package test.apiimpl.factory.provider;

import org.springframework.stereotype.Component;
import test.api.factory.Parameter;
import test.api.factory.SearchParameterProvider;

import java.util.List;
import java.util.Map;

import static test.api.factory.OperationCode.SEARCH_BY_BADCUSTOMERS;

@Component
public final class SearchByBadCustomersProvider implements SearchParameterProvider {
    @Override
    public Parameter getOperationCode() {
        return SEARCH_BY_BADCUSTOMERS;
    }

    @Override
    public List<Map<String, Object>> get(Map<String, Object> operationParameter) {
        return null;
    }
}
