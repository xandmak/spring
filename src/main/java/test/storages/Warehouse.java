package test.storages;

import common.Utils;
import org.springframework.stereotype.Component;
import test.animals.Animal;
import test.dto.Food;
import test.dto.FoodState;
import test.dto.FoodType;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Warehouse {

    private Map<FoodType, List<Food>> foods;

    public Warehouse() {
        foods = new EnumMap<FoodType, List<Food>>(FoodType.class);
        FoodType.stream().forEach(type -> foods.put(type, new ArrayList<>()));
    }

    synchronized public Food getFood(FoodType type) {
        List<Food> listFood = foods.get(type);
        if (listFood.isEmpty())
            return null;
        return  foods.get(type).remove(0);
    }

    public void addFoods(List<Food> foods) { foods.forEach(food -> addFood(food)); }

    synchronized public void addFood(Food food) {
        foods.get(food.getType()).add(food);
    }

    synchronized public void addFood(int ix, Food food) {
        foods.get(food.getType()).add(ix, food);
    }

    synchronized public void checkFood() {
        for (Map.Entry<FoodType, List<Food>> entry: foods.entrySet()) {
            List<Food> freshFoods = entry.getValue().stream().filter(food -> food.getState() == FoodState.EDIBLE).collect(Collectors.toList());
            entry.getValue().removeAll(freshFoods);
            if (!entry.getValue().isEmpty())
                Utils.printTrace("Remove old food: " + entry.getValue());
            entry.setValue(freshFoods);
        }
    }

}
