package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GKislin on 06.11.2015.
 */
public class MainConcurrency {
    private static volatile int sum;
    private static final Object LOCK = new Object();
    private static final AtomicInteger ATOMIC_SUM = new AtomicInteger();
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(10000);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        ATOMIC_SUM.incrementAndGet();
/*
                        synchronized (LOCK) {
                            sum++;
                        }
*/
                        REENTRANT_LOCK.lock();
                        sum++;
                        REENTRANT_LOCK.unlock();

                    }
                    countDown.countDown();
                }
            }).start();
        }
        countDown.await();
//        Thread.sleep(500);
        System.out.println(sum);
        System.out.println(ATOMIC_SUM);
    }

    static void testStatic() {
        synchronized (MainConcurrency.class) {

        }
    }

    void test() {
        synchronized (this) {

        }
    }
}
