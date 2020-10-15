package lozm;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Calculator {

    private int number;


    public synchronized void addNumber(int number, long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.number += number;

        System.out.println(Thread.currentThread().getName() + ": " + this.number);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNumber(25);

        //User1
        Thread user1 = new Thread(() -> calculator.addNumber(100, 2000));
        user1.setName("user1");
        user1.start();

        //User2
        Thread user2 = new Thread(() -> calculator.addNumber(50, 0));
        user2.setName("user2");
        user2.start();
    }

}