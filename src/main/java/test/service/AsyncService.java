package test.service;

import java.util.concurrent.Future;
import java.util.function.Supplier;

public interface AsyncService {
    <T> void doAsync(Supplier<T> supplier);

    <T> Future<T> doAsyncReturned(Supplier<T> supplier);
}
