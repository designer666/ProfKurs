package lesson04.runnable;

/**
 * Created by IEvgen Boldyr on 09.06.17.
 */

public class SomeRunnableEx implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable - поток");
    }
}
