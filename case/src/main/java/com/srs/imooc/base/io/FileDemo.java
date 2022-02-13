package com.srs.imooc.base.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {


    public static void main(String[] args) {
        File file = new File("File", "Monday.docx");
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
                if (newFile) {
                    System.out.println("文件创建成功!");
                    System.out.println("文件名称：" + file.getName());
                    System.out.println("文件上级目录：" + file.getParent());
                    System.out.println("文件/目录：" + (file.isFile() ? "这是一个文件" : "这是一个目录"));
                    file.setReadable(true);
                    file.setWritable(true);
                    System.out.println("读写性："+ file.canRead() + " "+ file.canWrite());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
