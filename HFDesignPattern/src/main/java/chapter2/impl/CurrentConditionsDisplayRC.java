package chapter2.impl;

import chapter2.DisplayElement;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:41
 */
@Data
public class CurrentConditionsDisplayRC implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    Observable observable;

    public CurrentConditionsDisplayRC(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataRC) {
            WeatherDataRC weatherDataRC = (WeatherDataRC) o;
            this.temperature = weatherDataRC.getTemperature();
            this.humidity = weatherDataRC.getHumidity();
            display();
        }
    }
}
