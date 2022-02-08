package com.srs.imooc.Thread.weather;

/**
 * @author shaorensheng
 * @date 2022/2/8
 */
public class GenerateWeather implements Runnable {

    Weather weather;

    public GenerateWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.weather.generate();
        }
    }
}
