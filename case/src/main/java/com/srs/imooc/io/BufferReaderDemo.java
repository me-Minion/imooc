package com.srs.imooc.io;

import java.io.*;

public class BufferReaderDemo {


    public static void main(String[] args) {
        String msg = "这可真是让人头疼的" +
                "asdasd\r" +
                "asd\n" +
                "asdasd";
        transWriteByBuf(msg);
        transReadByBuf();
    }

    public static void transWriteByBuf(String msg) {
        try {
            FileWriter writer = new FileWriter("demo.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(msg);
            bw.flush();
            bw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void transReadByBuf() {
        try {
            FileReader reader = new FileReader("demo.txt");
            BufferedReader br = new BufferedReader(reader);

            String ss;
            while ((ss=br.readLine()) != null) {
                System.out.println(ss);
            }

            br.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
