package lozm;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void yieldTest() {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 is running to start");
            Thread.yield();
            System.out.println("Thread1 is running to end");
        });
        thread1.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 is running to start");
            System.out.println("Thread2 is running to end");
        });
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    @Test
    void joinTest() {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());


        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 is running to start");
            for (int i = 1; i <= 100; i++) {
                System.out.println("i = " + i);
            }
            System.out.println("Thread1 is running to end");
        });
        thread1.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 is running to start");
            System.out.println("Thread2 is running to end");
        });
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();

        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void interruptTest() throws InterruptedException {
        Thread thread1 = new InterruptThread();
        thread1.start();

        Thread.sleep(2000);
        thread1.interrupt();
    }

}