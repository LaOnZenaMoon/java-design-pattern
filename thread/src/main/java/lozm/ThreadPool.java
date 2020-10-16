package lozm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        ExecutorService executorService1 = Executors.newCachedThreadPool();
    }

}