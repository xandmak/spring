package test.service;

import common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.animals.Animal;
import test.dto.FoodState;
import test.dto.FoodType;
import test.event.HungryEvent;
import test.storages.Zoo;
import test.dto.Food;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;
    private final AsyncService asyncService;
    private final ApplicationContext appContext;

    @Autowired
    public ZooServiceImpl(Zoo zoo, AsyncService asyncService, ApplicationContext appContext) {
        this.zoo = zoo;
        this.asyncService = asyncService;
        this.appContext = appContext;
    }

    @Override
    public void feed(Animal animal, FoodType type) {
        asyncService.doAsync(() -> {
            Food curFood = zoo.getWarehouse().getFood(type);
            if (!animal.eat(curFood) && curFood.getState() == FoodState.EDIBLE) {
                zoo.getWarehouse().addFood(0, curFood);
                appContext.publishEvent(new HungryEvent(animal, curFood.getType().getNext(), this));
            }
            return null;
        });
    }

    @Override
    public void voice() {
        zoo.getAnimals().forEach(Animal::voice);
    }

    @Override
    public void delivery() {
        Random random = new Random();
        int limit = random.nextInt(10);
        for (int ix = 0; ix < limit; ix++)
            FoodType.stream().forEach(type -> zoo.getWarehouse().addFood(new Food(type, random.nextInt(1000))));
    }

    @Override
    public void checkFood() {
        zoo.getWarehouse().checkFood();
    }

    @Override
    public void decreaseEnergy() {
        List<Animal> hungryAnimals = zoo.getAnimals()
                .stream()
                .peek(animal -> animal.decreaseEnergy())
                .filter(Animal::isHungry)
                .peek(animal -> {
                    Utils.printTrace(animal.getName() + " is hungry");
                    appContext.publishEvent(new HungryEvent(animal, FoodType.values()[0], this));
                })
                .collect(Collectors.toList());
    }
}
