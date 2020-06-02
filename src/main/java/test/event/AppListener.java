package test.event;

import org.springframework.context.ApplicationListener;

public class AppListener implements ApplicationListener<SomeEvent> {

    @Override
    public void onApplicationEvent(SomeEvent someEvent) {
        System.out.println(someEvent.getMessage());
    }
}
