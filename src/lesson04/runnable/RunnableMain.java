package lesson04.runnable;

/**
 * Created by IEvgen Boldyr on 09.06.17.
 */
public class RunnableMain {

    public static void main(String[] args) {
        //Для запуска класса реализующего интерфейс Runnable
        //нам необходимо создать объект класса Thread,
        //и передать в него объект реализующий Runnable
        Thread thr = new Thread(new SomeRunnableEx());
        thr.start();

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Анонимный Runnable");
            }
        });
        thr1.start();

        Runnable task = () -> {
            System.out.println("Лямбда-Runnable");
            System.out.println("Код для выполнения");
        };
        Thread thr2 = new Thread(task);
        thr2.start();
    }
}
