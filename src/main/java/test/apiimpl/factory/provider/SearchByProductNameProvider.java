package test.apiimpl.factory.provider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import test.api.factory.Parameter;
import test.api.factory.SearchParameterProvider;

import java.util.List;
import java.util.Map;

import static test.api.factory.OperationCode.SEARCH_BY_PRODUCTNAME;

@Component
public final class SearchByProductNameProvider implements SearchParameterProvider {
    @Override
    public Parameter getOperationCode() {
        return SEARCH_BY_PRODUCTNAME;
    }

    @Override
    public List<Map<String, Object>> get(Map<String, Object> operationParameter) {
        return ImmutableList.of(
                        ImmutableMap.of("lastName", "Сидоров", "firstName", "Сидр"),
                        ImmutableMap.of("lastName", "Машина", "firstName", "Маша")
                );

    }
}
