package com.srs.imooc.base.Thread.weather;

/**
 * @author shaorensheng
 * @date 2022/2/8
 */
public class ReadWeather implements Runnable {

    Weather weather;

    public ReadWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.weather.read();
        }
    }
}
