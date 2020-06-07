package test.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.dto.FoodType;
import test.supplies.Air;

import java.util.Arrays;
import java.util.List;

@Component
public class Pigeon extends BreathingAnimal {

    final static List<FoodType> possibleFeedTypes = Arrays.asList(FoodType.BIRD_FEED, FoodType.INSECT);

    @Autowired
    public Pigeon(
            Air air,
            @Value("${pigeon.voice}") String voice,
            @Value("${pigeon.defaultEnergyLevel}") int energy,
            @Value("${pigeon.hungryEnergyLevel}") int hungryEnergyLevel,
            @Value("${pigeon.satietyEnergyLevel}") int satietyEnergyLevel,
            @Value("${pigeon.timeEnergyStep}") int timeEnergyStep) {
        super(air, voice, energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
    }

    @Override
    public String getName() {
        return "Pigeon";
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return possibleFeedTypes;
    }
}
