package test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.Animal;
import test.Cat;
import test.Dog;
import test.Zoo;
import test.event.AppListener;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean(name = "dog", initMethod = "init", destroyMethod = "destroy")
    public Dog createDog() {
        return new Dog();
    }

    @Bean(name = "cat")
    public Cat createCat() {
        return new Cat();
    }

    @Bean(name = "zoo")
    public Zoo createZoo() {
        return new Zoo(createDog(), createCat());
    }

    @Bean(name = "animals")
    public List<Animal> createListZoo() {
        return Arrays.asList(createCat(), createDog());
    }

    @Bean(name = "listener")
    public AppListener createListener(){
        return new AppListener();
    }
}
