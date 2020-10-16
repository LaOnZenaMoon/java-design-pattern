package lozm;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {

    private ExecutorService executorService;

    public CallbackExample() {
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
        @Override
        public void completed(Integer result, Void attachment) {
            System.out.println("completed result = " + result);
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
            System.out.println("failed result = " + exc.toString());
        }
    };

    public void doWork(final String source1, final String source2) {
        executorService.submit(() -> {
            try {
                int x = Integer.parseInt(source1);
                int y = Integer.parseInt(source2);
                int result = x + y;
                callback.completed(result, null);
            } catch (Exception e) {
                e.printStackTrace();
                callback.failed(e, null);
            }
        });
    }

    public void finish() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        CallbackExample callbackExample = new CallbackExample();
        callbackExample.doWork("3", "4");
        callbackExample.doWork("5", "육");
        callbackExample.finish();
    }

}