package test.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;
import test.supplies.Air;

import java.util.Arrays;
import java.util.List;

@Component
public class Cat extends BreathingAnimal {

    final static List<FoodType> possibleFeedTypes = Arrays.asList(FoodType.CAT_FEED, FoodType.MEAT, FoodType.FISH);

    @Autowired
    public Cat(
            Air air,
            @Value("${cat.voice}") String voice,
            @Value("${cat.defaultEnergyLevel}") int energy,
            @Value("${cat.hungryEnergyLevel}") int hungryEnergyLevel,
            @Value("${cat.satietyEnergyLevel}") int satietyEnergyLevel,
            @Value("${cat.timeEnergyStep}") int timeEnergyStep) {
        super(air, voice, energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
    }

    @Override
    public String getName() {
        return "Cat";
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return possibleFeedTypes;
    }


}
