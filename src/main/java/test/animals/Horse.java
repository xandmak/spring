package test.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.dto.FoodType;
import test.supplies.Air;

import java.util.Arrays;
import java.util.List;

@Component
public class Horse extends BreathingAnimal {

    final static List<FoodType> possibleFeedTypes = Arrays.asList(FoodType.GRASS, FoodType.HAY);

    @Autowired
    public Horse(
            Air air,
            @Value("${horse.voice}") String voice,
            @Value("${horse.defaultEnergyLevel}") int energy,
            @Value("${horse.hungryEnergyLevel}") int hungryEnergyLevel,
            @Value("${horse.satietyEnergyLevel}") int satietyEnergyLevel,
            @Value("${horse.timeEnergyStep}") int timeEnergyStep) {
        super(air, voice, energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
    }

    @Override
    public String getName() {
        return "Horse";
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return possibleFeedTypes;
    }
}
