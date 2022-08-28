package test.apiimpl.factory;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.exception.RequestException;

class SearchOperationProviderFactoryTest extends SpringTest {

    @Autowired
    SearchOperationProviderFactory factory;

    @Test
    void givenValidOperationAndParameters_thenResultOk() {
        Assertions.assertDoesNotThrow(() -> factory.getParameterProvider(ImmutableSet.of("lastName")));
    }

    @Test
    void givenValidOperation_whenParametersNotSupported_thenThrowException() {
        Assertions.assertThrows(RequestException.class, () -> factory.getParameterProvider(ImmutableSet.of("firstName")));
    }

}