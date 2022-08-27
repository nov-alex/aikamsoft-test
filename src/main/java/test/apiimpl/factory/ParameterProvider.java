package test.apiimpl.factory;

import java.io.Serializable;
import java.util.Map;

public interface ParameterProvider {

    Parameter getOperationCode();

    Serializable get(Map<String, Object> operationParameter);
}
