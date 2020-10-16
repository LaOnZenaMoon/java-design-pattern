package lozm;

import java.util.concurrent.*;

public class CompletionServiceExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < 3; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int j = 1; j <= Math.random() * 1000; j++) {
                        sum += j;
                    }

                    System.out.println("Thread: " + Thread.currentThread().getName() + ", " + "sum = " + sum);
                    return sum;
                }
            });
        }

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Future<Integer> future = completionService.take();
                        Integer integer = future.get();
                        System.out.println("처리결과 = " + integer);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });

        Thread.sleep(5000);
        executorService.shutdownNow();
    }

}