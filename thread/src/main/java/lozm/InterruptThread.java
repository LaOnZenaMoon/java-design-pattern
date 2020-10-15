package lozm;

public class InterruptThread extends Thread {

    @Override
    public void run() {
        System.out.println("Interrupt Thread 실행 시작");

        try {
            while (true) {
                System.out.println("Interrupt Thread 실행중...");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupt Thread 실행 자원 정리");
        System.out.println("Interrupt Thread 실행 종료");
    }

}