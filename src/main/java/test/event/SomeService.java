package test.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @EventListener(SomeEvent.class)
    public void onApplicationEvent(SomeEvent someEvent) {
        System.out.println(someEvent.getMessage());
    }
}
