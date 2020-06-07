package test.animals;

import test.dto.Food;

public abstract class FeedingAnimal implements Animal {

    private int energy;
    private final int hungryEnergyLevel;
    private final int satietyEnergyLevel;
    private final int timeEnergyStep;

    public FeedingAnimal(int energy, int hungryEnergyLevel, int satietyEnergyLevel, int timeEnergyStep) {
        this.energy = energy;
        this.hungryEnergyLevel = hungryEnergyLevel;
        this.satietyEnergyLevel = satietyEnergyLevel;
        this.timeEnergyStep = timeEnergyStep;
    }

    @Override
    synchronized public boolean eat(Food food) {
        energy += food.eat();
        return isSatiety();
    }

    @Override
    public boolean isHungry() { return energy < hungryEnergyLevel; }

    @Override
    public boolean isSatiety() {
        return energy > satietyEnergyLevel;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    synchronized public int decreaseEnergy()
    {
        energy -= timeEnergyStep;
        if (energy < 0) energy = 0;
        return energy;
    }

}
