package com.srs.imooc.base.io;

import java.io.*;

public class FileInputDemo {


    public static void main(String[] args) {
        File file = new File("speech.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            int n = 0;
            System.out.print("文本内容：");
            int count = 0;
            while ((n = fis.read()) != -1) {
                System.out.print((char)n);
                count ++;
            }
            System.out.println();
            System.out.println("统计结果：" + file.getName() + "文件中共有" + count + "个字节");
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
