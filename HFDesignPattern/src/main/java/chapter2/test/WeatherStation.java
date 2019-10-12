package chapter2.test;

import chapter2.impl.CurrentConditionsDisplay;
import chapter2.impl.WeatherData;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:24
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(2, 3, 5);
        weatherData.setMeasurements(1, 7, 2);
        weatherData.setMeasurements(5, 9, 4);
    }

}
