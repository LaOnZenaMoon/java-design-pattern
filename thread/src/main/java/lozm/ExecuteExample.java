package lozm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

    public static void main(String[] args) throws Exception {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[The number of total thread: " + poolSize + "] Thread name:" + threadName);

                    //Throw new Exception
                    int value = Integer.parseInt("삼");
                }
            };

            //submit 과 execute 의 thread 생성 오버헤드 비교
//            executorService.execute(runnable);
            executorService.submit(runnable);

            Thread.sleep(10);
        }

        executorService.shutdown();
    }

}