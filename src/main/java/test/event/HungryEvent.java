package test.event;

import test.animals.Animal;
import test.dto.FoodType;
import test.service.ZooService;

public class HungryEvent {

    private Animal animal;

    private FoodType type;

    private ZooService service;

    public HungryEvent(Animal animal, FoodType type, ZooService service) {
        this.animal = animal;
        this.type = type;
        this.service = service;
    }

    public Animal getAnimal() {
        return animal;
    }

    public FoodType getType() {
        return type;
    }

    public ZooService getService() {
        return service;
    }
}
