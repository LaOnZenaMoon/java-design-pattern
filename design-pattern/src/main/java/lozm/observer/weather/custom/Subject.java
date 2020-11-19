package lozm.observer.weather.custom;

public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
