package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;
    private final AsyncService asyncService;

    @Autowired
    public ZooServiceImpl(Zoo zoo, AsyncService asyncService) {
        this.zoo = zoo;
        this.asyncService = asyncService;
    }

    @Override
    public void feed(Food food) {
        List<Animal> angryAnimals = zoo.getAnimals()
                .stream()
                .peek(animal -> doAsync(food, animal))
                .filter(Animal::isAngry)
                .collect(Collectors.toList());
        System.out.println(angryAnimals);
    }

    @Override
    public void voice() {
        zoo.getAnimals().forEach(Animal::voice);
    }

//    private void doAsync(Food food, Animal animal) {
//        asyncService.doAsync(() -> animal.eat(food));
//    }

    private boolean doAsync(Food food, Animal animal) {
        try {
            return asyncService.doAsyncReturned(() -> animal.eat(food)).get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return true;
    }
}
