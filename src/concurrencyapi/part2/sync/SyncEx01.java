package concurrencyapi.part2.sync;

import concurrencyapi.part2.sync.domain.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */
public class SyncEx01 {

    public static void main(String[] args) {
        Counter counter = new Counter();

        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500_000; i++) {
                    counter.increment();
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500_000; i++) {
                    counter.increment();
                }
            }
        };

        service.submit(task1);
        service.submit(task2);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.value());

        service.shutdown();
    }
}
