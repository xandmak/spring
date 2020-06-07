package test.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.service.ZooService;

@Service
public class EventService {

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println(zooEvent.getMessage());
    }

    @EventListener(HungryEvent.class)
    public void onHungryEvent(HungryEvent hungryEvent){
        hungryEvent.getService().feed(hungryEvent.getAnimal(), hungryEvent.getType());
    }
}
