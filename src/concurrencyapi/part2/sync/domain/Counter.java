package concurrencyapi.part2.sync.domain;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IEvgen Boldyr on 16.06.17.
 */

public class Counter {

    private ReentrantLock reentrant = new ReentrantLock();
    private int count = 0;

    public void increment() {
        //код
        synchronized (this) {
            count++;
        }
        //код
    }

    public void lockIncrement() {
        try {
            reentrant.lock();
            count++;
        } finally {
            reentrant.unlock();
        }
    }

    public int value() {
        return count;
    }
}
