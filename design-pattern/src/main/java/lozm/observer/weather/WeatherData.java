package lozm.observer.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach((item) -> {
            Observer observer = (Observer) item;
            observer.update(temperature, humidity, pressure);
        });
    }

    public void measurementChanged() {
        notifyObservers();
    }

    /**
     * for test
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = humidity;
        measurementChanged();
    }

}
