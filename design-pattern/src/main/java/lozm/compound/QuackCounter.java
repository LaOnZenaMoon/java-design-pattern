package lozm.compound;

import java.util.Observer;

public class QuackCounter implements Quackable {

    private Quackable duck;
    private static int numberOfCounts;


    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }


    @Override
    public void quack() {
        duck.quack();
        numberOfCounts++;
    }

    public int getQuackCounts() {
        return numberOfCounts;
    }

//    public void registerObserver(Observer observer) {
//        duck.registerObserver(observer);
//    }
//
//    public void notifyObservers() {
//        duck.noifyObservers();
//    }

}
