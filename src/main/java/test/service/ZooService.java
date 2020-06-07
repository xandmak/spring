package test.service;

import test.animals.Animal;
import test.dto.FoodType;

public interface ZooService {
    void feed(Animal animal, FoodType type);
    void voice();
    void delivery();
    void checkFood();
    void decreaseEnergy();
}
