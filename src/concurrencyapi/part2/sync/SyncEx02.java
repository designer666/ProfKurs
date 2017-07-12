package concurrencyapi.part2.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */
public class SyncEx02 {

    public static void main(String[] args) {
        ReentrantLock reentrant = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            try {
                reentrant.lock();
                System.out.println("Удержание текущим потоком: "
                        + reentrant.isHeldByCurrentThread());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrant.unlock();
            }
        });

        service.submit(() -> {
            System.out.println("Состояние блокировки:      "
                    + reentrant.isLocked());
            System.out.println("Удержание текущим потоком: "
                    + reentrant.isHeldByCurrentThread());
            try {
                System.out.println("Попытка блокировки " +
                        "текущим потоком : "
                        + reentrant.tryLock(6, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
    }
}
