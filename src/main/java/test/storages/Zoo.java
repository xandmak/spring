package test.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.animals.Animal;

import java.util.List;

@Component
public class Zoo {
    private final String name;
    private final List<Animal> animals;
    private final Warehouse warehouse;

    @Autowired
    public Zoo(
            @Value("${zoo.name}") String name,
            List<Animal> animals,
            Warehouse warehouse
    ) {
        this.name = name;
        this.animals = animals;
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Warehouse getWarehouse() { return warehouse; }
}
