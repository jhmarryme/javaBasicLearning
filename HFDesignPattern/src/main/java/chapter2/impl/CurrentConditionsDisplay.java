package chapter2.impl;

import chapter2.DisplayElement;
import chapter2.Observer;
import lombok.Data;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:20
 */
@Data
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private float temperature;

    private float humidity;

    private float pressure;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

}
