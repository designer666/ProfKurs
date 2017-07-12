package concurrencyapi.part2.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */
public class ScheduledEx01 {

    public static void main(String[] args) {
        System.out.println("Старт метода main()");
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(1);

        Runnable someTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Отложенная к выполнению задача");
            }
        };

        //Объект ScheduledFuture позволяет нам получить
        //оставшееся время до запуска отложенной задачи
        ScheduledFuture future =
                service.schedule(someTask, 5, TimeUnit.SECONDS);

        try {

            TimeUnit.SECONDS.sleep(3);
            //С помощью метода getDelay() - получаем оставшееся время в \
            //в выбраной единице измерения
            System.out.println("Время до запуска отложеной задачи:"
                    + future.getDelay(TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение метода main()");
        service.shutdown();
    }
}
