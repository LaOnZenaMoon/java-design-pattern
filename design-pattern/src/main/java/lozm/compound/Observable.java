package lozm.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements QuackObservable {

    private List<Observer> observerList = new ArrayList<>();
    private QuackObservable duck;


    public Observable(QuackObservable duck) {
        this.duck = duck;
    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observerList.iterator();
        while (iterator.hasNext()) {
            Observer item = iterator.next();
            item.update(duck);
        }
    }

}
