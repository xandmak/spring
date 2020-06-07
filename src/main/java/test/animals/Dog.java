package test.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.annotations.AopMarker;
import test.dto.Food;
import test.dto.FoodType;
import test.supplies.Air;

import java.util.Arrays;
import java.util.List;

@Component
@AopMarker
public class Dog extends BreathingAnimal {

    final static List<FoodType> possibleFeedTypes = Arrays.asList(FoodType.DOG_FEED, FoodType.MEAT);

    @Autowired
    public Dog(
            Air air,
            @Value("${dog.voice}") String voice,
            @Value("${dog.defaultEnergyLevel}") int energy,
            @Value("${dog.hungryEnergyLevel}") int hungryEnergyLevel,
            @Value("${dog.satietyEnergyLevel}") int satietyEnergyLevel,
            @Value("${dog.timeEnergyStep}") int timeEnergyStep) {
        super(air, voice, energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
    }

    @Override
    public String getName() {
        return "Dog";
    }


    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return possibleFeedTypes;
    }
}
