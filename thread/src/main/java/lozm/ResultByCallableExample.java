package lozm;

import java.util.concurrent.*;

public class ResultByCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        class Result {
            int number;

            Result() {
                this.number = 0;
            }

            synchronized void addNumber(int number) {
                this.number += number;
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Result result = new Result();

        //Thread1
        Future<Integer> thread1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Thread1 start: " + Thread.currentThread().getName());
                int value = 0;
                for (int i = 0; i < Math.random() * 100; i++) {
                    value += i;
                }
                System.out.println("Thread1 value = " + value);
                return value;
            }
        });

        //Thread2
        Future<Integer> thread2 = executorService.submit(() -> {
            System.out.println("Thread2 start: " + Thread.currentThread().getName());
            int value = 0;
            for (int i = 0; i < Math.random() * 100; i++) {
                value += i;
            }
            System.out.println("Thread2 value = " + value);
            return value;
        });

        executorService.submit(() -> {
            System.out.println("Thread result start: " + Thread.currentThread().getName());
            try {
                result.addNumber(thread1.get());
                System.out.println("Thread1 end");

                result.addNumber(thread2.get());
                System.out.println("Thread2 end");

                System.out.println("Result number = " + result.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Thread result end: " + Thread.currentThread().getName());
        });

        executorService.shutdown();
    }

}