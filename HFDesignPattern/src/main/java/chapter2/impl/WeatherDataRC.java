package chapter2.impl;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Observable;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:36
 */
@Getter
@NoArgsConstructor
public class WeatherDataRC extends Observable {
    private float temperature;

    private float humidity;

    private float pressure;


    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
