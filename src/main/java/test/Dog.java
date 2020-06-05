package test;

import org.springframework.stereotype.Component;
import test.annotations.AopMarker;
import test.dto.Food;

@Component
@AopMarker
public class Dog implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("gav");
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return false;
    }
}
