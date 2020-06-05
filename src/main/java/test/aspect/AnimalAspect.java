package test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnimalAspect {

//    @Pointcut("target(test.Cat)")
//    public void fishPoint() {
//    }
//
//    @Around(value = "fishPoint()")
//    public Object validateEatForFish(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Object result = proceedingJoinPoint.proceed();
//        return result;
//    }
}
