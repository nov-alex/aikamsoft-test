package test.apiimpl.factory.provider;

import org.springframework.stereotype.Component;
import test.api.factory.Parameter;
import test.api.factory.StatParameterProvider;

import java.util.List;
import java.util.Map;

import static test.api.factory.OperationCode.STAT_BY_DATE_INTERVAL;

@Component
public final class StatByDateIntervalProvider implements StatParameterProvider {
    @Override
    public Parameter getOperationCode() {
        return STAT_BY_DATE_INTERVAL;
    }

    @Override
    public List<Map<String, Object>> get(Map<String, Object> operationParameter) {
        return null;
    }
}
