package lozm;

public class WorkerThread extends Thread {

    @Override
    public void run() {
        System.out.println("run");
    }

//    public static void main(String[] args) {
//        Thread mainThread = Thread.currentThread();
//        System.out.println("mainThread = " + mainThread.getName());
//
//        Thread workerThread = new WorkerThread();
//        System.out.println("workerThread = " + workerThread.getName());
//        workerThread.start();
//    }

}