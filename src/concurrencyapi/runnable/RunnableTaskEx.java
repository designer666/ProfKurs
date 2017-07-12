package concurrencyapi.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by IEvgen Boldyr on 09.06.17.
 */
public class RunnableTaskEx {

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                //Устаревший вариант - Время указывается в милисекундах
                //Thread.currentThread().sleep(1000);
                TimeUnit.SECONDS.sleep(15);
                System.out.println("Задача для выполнения");
            } catch (InterruptedException e) {
                /*Исключение IterruptedException будет сгененрировано
                только в том случае, когда мы попытаемся досрочно
                завершить работу спящего потока*/
                e.printStackTrace();
            }
        };

        //Создание исполнителя
        //Класс Executors - позволяет создавать объекты исполнителей
        //с уже заранее подготовленными настройками
        //newSingleThreadExecutor() - создает исполнителя с одним
        //                            потоком в пуле
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(task);

        //Вежливая остановка сервиса
        service.shutdown();

        if (!service.isTerminated()) {
            try {
                System.out.println("Подготовка к досрочному завершению работы");
                //Даем таймаут на завершение процессов
                service.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Дострочное прекращение работы потоков вне
                //зависимости от состояния
                service.shutdownNow();
            }
        }
    }
}
