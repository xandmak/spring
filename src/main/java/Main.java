import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Zoo;
import test.configuration.AnnotationConfiguration;
import test.event.SomeEvent;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        Zoo zoo = context.getBean(Zoo.class);
        context.publishEvent(new SomeEvent(zoo, "test"));
        zoo.getCat().voice();
        zoo.getDog().voice();
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
