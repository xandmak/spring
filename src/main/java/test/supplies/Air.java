package test.supplies;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Air {
    public void sound(String content) {
        System.out.print(content);
    } //TODO: Don`t use stdout in real code
}
