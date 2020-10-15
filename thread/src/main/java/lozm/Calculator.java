package lozm;

import lombok.Getter;

@Getter
public class Calculator {

    private int memory;

    public void setMemory(int memory) {
        this.memory = memory;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }

    public void addMemory(int memory) {
        int tempMemory = this.memory;

        try {
            Thread.sleep((long) (Math.random()*5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tempMemory += memory;
        this.memory = tempMemory;

        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setMemory(25);

        //User1
        Thread user1 = new Thread(() -> calculator.addMemory(100));
        user1.start();

        //User2
        Thread user2 = new Thread(() -> calculator.addMemory(50));
        user2.start();
    }

}