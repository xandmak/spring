package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.service.ZooService;

import java.time.LocalDateTime;

@Service
public class JobService {

    private final ZooService zooService;

    @Autowired
    public JobService(ZooService zooService) {
        this.zooService = zooService;
    }

//    @Scheduled(fixedDelay = 1000)
//    public void voice() {
//        System.out.println(LocalDateTime.now().toString());
//        zooService.voice();
//    }
}
