package lozm.compound;



public class RedHeadDuck implements Quackable {

    private Observable observable;


    public RedHeadDuck() {
        this.observable = new Observable(this);
    }


    @Override
    public void quack() {
        System.out.println("RedHead quack.");
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
