package concurrencyapi.part2.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */
public class ScheduledEx02 {

    public static void main(String[] args) {
        ScheduledExecutorService service
                = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    System.out.println("Начало");
                    System.out.println("Задача для повторного запуска");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("Окончание");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        service.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        //service.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(10);
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
