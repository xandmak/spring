package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Dog implements Animal {
    public void voice() {
        System.out.println("gav");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog was init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog was destroy");
    }
}
