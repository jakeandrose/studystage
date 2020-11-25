package com.example.filetest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest {

    /**
     * 简单测试向文件当中写入内容
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        String s = "这是一个字符串写入文件测试";
        byte []bytes = s.getBytes();
        File file = new File("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);

    }

    /**
     * 简单测试读取文件内容
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        byte []bytes = new byte[1024];
        File file = new File("a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int actualByte = fileInputStream.read(bytes,0,1024);
        System.out.println(new String(bytes,0,actualByte));
    }

}
