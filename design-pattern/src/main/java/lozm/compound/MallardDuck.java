package lozm.compound;



public class MallardDuck implements Quackable {

    private Observable observable;


    public MallardDuck() {
        this.observable = new Observable(this);
    }


    @Override
    public void quack() {
        System.out.println("Mallard quack.");
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

}
