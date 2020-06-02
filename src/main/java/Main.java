import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Zoo;
import test.configuration.BeanConfiguration;
import test.event.SomeEvent;

public class Main {
//    public static void main(String[] args) {
//        Zoo zoo = new Zoo(new Dog(), new Cat());
//        zoo.getCat().voice();
//        zoo.getDog().voice();
//    }

    public static void main(String[] args) {
        ApplicationContext context = getBeanContext();
        Zoo zoo = context.getBean(Zoo.class);
        context.publishEvent(new SomeEvent(zoo, "test"));
        zoo.getCat().voice();
        zoo.getDog().voice();
    }

    public static ApplicationContext getBeanContext() {
        return new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }
}
