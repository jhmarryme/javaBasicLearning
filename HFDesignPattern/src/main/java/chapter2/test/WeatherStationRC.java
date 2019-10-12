package chapter2.test;

import chapter2.impl.CurrentConditionsDisplayRC;
import chapter2.impl.WeatherDataRC;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:24
 */
public class WeatherStationRC {

    public static void main(String[] args) {
        WeatherDataRC weatherData = new WeatherDataRC();

        CurrentConditionsDisplayRC currentConditionsDisplayRC = new CurrentConditionsDisplayRC(weatherData);

        weatherData.setMeasurements(2, 13, 5);
        weatherData.setMeasurements(1, 17, 2);
        weatherData.setMeasurements(5, 19, 4);
    }

}
