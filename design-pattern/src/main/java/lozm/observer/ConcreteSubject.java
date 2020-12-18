package lozm.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observerList;
    private String state;


    public ConcreteSubject() {
        this.observerList = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observerList.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update();
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

}
