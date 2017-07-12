package concurrencyapi.part1.callable;

import java.util.concurrent.*;

/**
 * Created by IEvgen Boldyr on 09.06.17.
 */
public class CallableEx {

    public static void main(String[] args) {
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Код задачи");
                TimeUnit.SECONDS.sleep(3);
                return "Результат";
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(1);
        //Объект Future после выполнения Callable-задачи
        //позволит нам получить результат
        Future<String> future = es.submit(task1);

        try {

            System.out.println("Задача завершена? " + future.isDone());
            String res = null;
            try {
                res = future.get(1, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("Задача завершена? " + future.isDone());

            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
