package lozm.observer.weather;

import lozm.observer.ConcreteObserver1;
import lozm.observer.ConcreteObserver2;
import lozm.observer.ConcreteSubject;
import lozm.observer.Observer;

public class ObserverApplication {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        concreteSubject.registerObserver(observer1);
        concreteSubject.registerObserver(observer2);
        concreteSubject.setState("ready");
    }

}
