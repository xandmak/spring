package test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.function.Supplier;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    @Override
    public <T> void doAsync(Supplier<T> supplier) {
        supplier.get();
        System.out.println(Thread.currentThread().getName());
    }

    @Async
    @Override
    public <T> Future<T> doAsyncReturned(Supplier<T> supplier) {
        System.out.println(Thread.currentThread().getName());
        return new AsyncResult<>(supplier.get());
    }
}
