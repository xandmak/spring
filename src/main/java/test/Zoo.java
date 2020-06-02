package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private Animal dog;
    private Animal cat;
    @Value("${zoo.name}")
    private String name;
    //    @Autowired
    private List<Animal> animals;

    public Zoo() {
    }

    @Autowired
    public Zoo(Animal dog, Animal cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }

    public void setDog(Animal dog) {
        this.dog = dog;
    }

    public void setCat(Animal cat) {
        this.cat = cat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Autowired
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
