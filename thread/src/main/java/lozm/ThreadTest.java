package lozm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> taskList = new ArrayList<>();
        taskList.add(getTask1());
        taskList.add(getTask2());
        taskList.add(getTask3());

        List<Future<String>> futureList = executorService.invokeAll(taskList);

        for (Future<String> stringFuture : futureList) {
            stringFuture.get();
        }

        log.info("allDone");

        executorService.shutdown();
    }

    private static Callable<String> getTask1() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Thread1 start");
                for (int i = 0; i < 1; i++) {
                    log.info("Thread1 ...");
                    Thread.sleep(1000);
                }
                log.info("Thread1 end");
                return "Thread1";
            }
        };
    }

    private static Callable<String> getTask3() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Thread3 start");
                for (int i = 0; i < 2; i++) {
                    log.info("Thread3 ...");
                    Thread.sleep(1000);
                }
                log.info("Thread3 end");
                return "Thread3";
            }
        };
    }

    private static Callable<String> getTask2() {
        return () -> {
            log.info("Thread2 start");
            for (int i = 0; i < 3; i++) {
                log.info("Thread2 ...");
                Thread.sleep(1000);
            }
            log.info("Thread2 end");
            return "Thread2";
        };
    }

}