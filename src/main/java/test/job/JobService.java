package test.job;

import common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.service.ZooService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class JobService {

    private final ZooService zooService;

    @Autowired
    public JobService(ZooService zooService) {
        this.zooService = zooService;
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void voice() {
        System.out.print(Utils.getCurrentLocalDateTimeStamp());
        zooService.voice();
        System.out.println();
    }

    @Scheduled(fixedRate = 5000)
    public void delivery() {
        zooService.delivery();
    }

    @Scheduled(fixedRate = 1000)
    public void checkFood() {
        zooService.checkFood();
    }

    @Scheduled(fixedRate = 100)
    public void decreaseEnergy() {
        zooService.decreaseEnergy();
    }

}
