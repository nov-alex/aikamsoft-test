package test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import test.config.DataConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfiguration.class)
public abstract class SpringTest {
}
