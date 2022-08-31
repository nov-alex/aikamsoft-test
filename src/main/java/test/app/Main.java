package test.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.config.DataConfiguration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(DataConfiguration.class);
        ctx.refresh();

        Application application = ctx.getBean("application", Application.class);
        application.start(args);
        ctx.close();
    }
}
