package test.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.annotations.AopMarker;
import test.dto.FoodType;

import java.util.Arrays;
import java.util.List;

@Component
@AopMarker
public class Fish extends FeedingAnimal {

    final static List<FoodType> possibleFeedTypes = Arrays.asList(FoodType.FISH_FEED, FoodType.INSECT);

    @Autowired
    public Fish(
            @Value("${fish.defaultEnergyLevel}") int energy,
            @Value("${fish.hungryEnergyLevel}") int hungryEnergyLevel,
            @Value("${fish.satietyEnergyLevel}") int satietyEnergyLevel,
            @Value("${fish.timeEnergyStep}") int timeEnergyStep) {
        super(energy, hungryEnergyLevel, satietyEnergyLevel, timeEnergyStep);
    }

    @Override
    public String getName() {
        return "Fish";
    }

    @Override
    public void voice() { }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return possibleFeedTypes;
    }
}
