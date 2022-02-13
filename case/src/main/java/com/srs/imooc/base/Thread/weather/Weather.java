package com.srs.imooc.base.Thread.weather;

/**
 * @author shaorensheng
 * @date 2022/2/8
 */
public class Weather {

    private Integer temperature;

    private Integer humidity;

    /**
     * 是否生成了天气
     */
    private volatile boolean flag = false;

    public Weather() {
    }

    public Weather(Integer temperature, Integer humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public synchronized void generate() {
        try {
            while (flag) {
                //已经生成天气信息，就等着
                wait();
            }
            Thread.sleep(5000);
            this.setTemperature((int)(Math.random() * 40));
            this.setHumidity((int)(Math.random() * 100));
            System.out.println("生成天气数据【温度：" + this.getTemperature() + "，湿度：" + this.getHumidity() + "】");

            flag = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void read() {
        try {
            while (!flag) {
                //没有生成天气信息，就等着
                wait();
            }
            Thread.sleep(100);
            System.out.println("读取天气数据【温度：" + this.getTemperature() + "，湿度：" + this.getHumidity() + "】");
            flag = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
