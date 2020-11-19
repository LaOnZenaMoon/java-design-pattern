package lozm.observer.weather.custom;

public class WeatherApplication {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80, 64, 30.4f);
    }

}
