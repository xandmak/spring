package test.animals;

import test.dto.Food;
import test.dto.FoodType;

import java.util.List;

public interface Animal {
    String getName();

    void voice();

    boolean eat(Food food);

    boolean isHungry();

    boolean isSatiety();

    int getEnergy();

    int decreaseEnergy();

    List<FoodType> getPossibleFeedTypes();
}
