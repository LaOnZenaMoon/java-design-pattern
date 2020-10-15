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
    void criticalSectionTest() {
        Calculator calculator = new Calculator();

        //User1
        Thread user1 = new Thread(() -> calculator.setMemory(100));
        user1.start();

        //User2
        Thread user2 = new Thread(() -> calculator.setMemory(50));
        user2.start();
    }

}