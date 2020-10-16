package lozm;

import java.util.concurrent.*;

public class ThreadBlocking {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread1 start");
                Thread.sleep(3000);
                System.out.println("Thread1 end");
                return "success";
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread2 start");
                    //Thread1 이 완료될때까지 블로킹
                    String result = future.get();
                    System.out.println("result = " + result);
                    System.out.println("Thread2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }

}