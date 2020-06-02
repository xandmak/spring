package test;

import java.util.List;

public class Zoo {
    private Animal dog;
    private Animal cat;
    private String name;
    private List<Animal> animals;

    public Zoo() {
    }

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

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
