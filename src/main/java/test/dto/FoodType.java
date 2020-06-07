package test.dto;

import java.util.stream.Stream;

public enum FoodType {

    MEAT("Сow meat", 20, 143),
    FISH("Fish", 20, 200),
    INSECT("Bug", 30, 100),
    GRASS("Grass", 40, 315),
    CAT_FEED("Whiskas", 60, 73),
    DOG_FEED("Chappi", 60, 350),
    FISH_FEED("Tetra", 60, 10),
    BIRD_FEED("Tetra", 60, 10),
    BONE("Bone", 60, 100),
    HAY("Hay", 60, 450);

    private String name;

    private int shelfLife;

    private int energyPer100Gram;

    FoodType(String name, int shelfLifeInSeconds, int energyPer100Gram) {
        this.name = name;
        this.shelfLife = shelfLifeInSeconds;
        this.energyPer100Gram = energyPer100Gram;
    }

    String getName() {
        return name;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public int getEnergyPer100Gram() {
        return energyPer100Gram;
    }

    public static Stream<FoodType> stream() {
        return Stream.of(FoodType.values());
    }

    public FoodType getNext() {
        boolean nextNeeded = false;
        for (FoodType type : FoodType.values()) {
            if (nextNeeded)
                return type;
            if (type == this)
                nextNeeded = true;
        }

        return FoodType.values()[0];
    }
}
