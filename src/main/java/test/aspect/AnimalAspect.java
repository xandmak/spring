package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import test.animals.Animal;
import test.dto.Food;

import java.time.LocalDateTime;

@Aspect
@Component
public class AnimalAspect {
    @Pointcut("execution(* test.animals.Animal.eat(..))")
    public void eatPoint() {
    }
//
//    @Pointcut("within(test.Fish)")
//    public void fishPoint() {
//    }
//
//    @Before(value = "eatPoint()")
//    public void beforeEat() {
//        System.out.println("start eat");
//    }
//
//    @After(value = "eatPoint()")
//    public void afterEat() {
//        System.out.println("end eat");
//    }
//
//    @AfterThrowing(value = "eatPoint()", throwing = "ex")
//    public void eatFailed(Throwable ex) {
//        System.out.println("eat failed: " + ex.getMessage());
//    }
//
//    @AfterReturning(value = "eatPoint()")
//    public void eatSuccess(JoinPoint joinPoint) {
//        System.out.println("eat success");
//    }

    @Around(value = "eatPoint() && args(food)")
    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        Animal animal = (Animal) proceedingJoinPoint.getTarget();
        String target = animal.getClass().toString();
        if (food == null || LocalDateTime.now().isAfter(food.getExpirationDate()) || animal.getPossibleFeedTypes().contains(food.getType())){
            return false;
        }
        System.out.println(target + " start eat");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println(target + " eat success");
            System.out.println(target + " end eat");
            return result;
        } catch (Throwable e) {
            System.out.println(target + " eat failed: " + e.getMessage());
            throw e;
        }
    }
}
