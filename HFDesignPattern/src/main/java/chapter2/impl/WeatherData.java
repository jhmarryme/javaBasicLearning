package chapter2.impl;

import chapter2.Observer;
import chapter2.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:11
 */

@Data
public class WeatherData implements Subject {

    private float temperature;

    private float humidity;

    private float pressure;

    private List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index > 0) {
            observers.remove(index);
        }
    }

    public void notifyObserves() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObserves();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
