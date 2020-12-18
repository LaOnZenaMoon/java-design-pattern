package lozm.compound;



public class DuckCall implements Quackable {

    private Observable observable;


    public DuckCall() {
        this.observable = new Observable(this);
    }


    @Override
    public void quack() {
        System.out.println("DuckCall quack.");
        notifyObservers();
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
