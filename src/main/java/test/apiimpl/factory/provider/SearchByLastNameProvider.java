package test.apiimpl.factory.provider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import test.api.factory.Parameter;
import test.api.factory.SearchParameterProvider;

import java.util.List;
import java.util.Map;

import static test.api.factory.OperationCode.SEARCH_BY_LASTNAME;

@Component
public final class SearchByLastNameProvider implements SearchParameterProvider {
    @Override
    public Parameter getOperationCode() {
        return SEARCH_BY_LASTNAME;
    }

    @Override
    public List<Map<String, Object>> get(Map<String, Object> operationParameter) {
        return ImmutableList.of(
                ImmutableMap.of("lastName", "Иванов", "firstName", "Иван"),
                ImmutableMap.of("lastName", "Петров", "firstName", "Петя")
        );
    }
}
