package test.dto;

import java.time.LocalDateTime;

public class Food {
    private FoodType type;
    private int weight;
    private FoodState state;
    private LocalDateTime expirationDate;

    public Food(FoodType type, int weight) {
        this.type = type;
        this.weight = weight;
        this.state = FoodState.EDIBLE;
        this.expirationDate = LocalDateTime.now().plusSeconds(type.getShelfLife());
    }

    public FoodType getType() {
        return type;
    }

    public int getWeight() { return weight; }

    public FoodState getState() {
        if (state == FoodState.EDIBLE && LocalDateTime.now().isAfter(expirationDate))
            state = FoodState.SPOILED;
        return state;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public int getEnergy() { return weight * type.getEnergyPer100Gram() / 100; };

    public int eat() {
        state = FoodState.EATEN;
        return getEnergy();
    };
}
