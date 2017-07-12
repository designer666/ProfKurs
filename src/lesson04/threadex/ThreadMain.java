package lesson04.threadex;

/**
 * Created by IEvgen Boldyr on 09.06.17.
 */
public class ThreadMain {

    public static void main(String[] args) {
        SomeThread thread = new SomeThread();
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
