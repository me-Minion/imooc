package com.srs.imooc.reflect.i18n;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class Application {


    public static void say() {
        Properties properties = new Properties();
        String path = Application.class.getResource("/i18n-config.properties").getPath();
        try {
            path = URLDecoder.decode(path, "UTF-8");
            properties.load(new FileInputStream(path));
            String language = properties.getProperty("language");
            System.out.println(language);
            //通过properties文件，在运行时知道，实际调用的是哪个类
            //实现I18N接口，通过修改配置文件，达到动态切换调用对象
            I18N i18N = (I18N) Class.forName(language).newInstance();
            System.out.println(i18N.say());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        say();
    }

}
