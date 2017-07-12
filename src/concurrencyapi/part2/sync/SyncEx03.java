package concurrencyapi.part2.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */
public class SyncEx03 {

    private static String someValue = "null";

    public static void main(String[] args) {

        ReadWriteLock locker = new ReentrantReadWriteLock();
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                locker.writeLock().lock();
                System.out.println("Start Write");
                someValue = "Write";
                TimeUnit.SECONDS.sleep(3);
                System.out.println("End Write");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locker.writeLock().unlock();
            }
        });

        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    locker.readLock().lock();
                    System.out.println(someValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    locker.readLock().unlock();
                }
            }
        });

        service.shutdown();
    }
}
