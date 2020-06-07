package test.animals;

import test.supplies.Air;

public abstract class BreathingAnimal extends FeedingAnimal {

    private final Air air;
    private final String voice;

    public BreathingAnimal(Air air, String voice, int energy, int hungryEnergyLevel, int satietyEnergyLevel, int timeEnergyStep) {
        super(energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
        this.air = air;
        this.voice = voice;
    }

    @Override
    public void voice() {
        air.sound(this.getClass().getSimpleName() + ": " + voice + " ");
    }

}
