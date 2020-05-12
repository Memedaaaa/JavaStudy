package com.lg.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 16:28 2020/4/25
 */

public class ImageToByte {
    public static void main(String[] args) throws IOException {
        /*
         *将图片转换成二进制字节流
         */
        byte[] imageByte;
        File file1 = new File("C:\\Users\\akon\\Pictures\\Saved Pictures\\psb (1).jpg");//需要转换成二进制字节流的文件的绝对路径
        FileInputStream fls = new FileInputStream(file1);
        imageByte = new byte[(int) file1.length()];
        fls.read(imageByte);
        String strBuffer = new String(imageByte);
        System.out.println(strBuffer);
        fls.close();
        try
        {
            // 创建文件对象
            File fileText = new File("C:\\Users\\akon\\Pictures\\Saved Pictures\\img1.txt");
            // 向文件写入对象写入信息
            FileWriter fileWriter = new FileWriter(fileText);

            // 写文件
            fileWriter.write(strBuffer);
            // 关闭
            fileWriter.close();
        }
        catch (IOException e)
        {
            //
            e.printStackTrace();
        }
        /*
         *将二进制字节流转换成图片
         */
        File file2 = new File("C:\\Users\\akon\\Pictures\\Saved Pictures\\psb (1.1).jpg");//发现不管是jpg还是jpeg或者是png甚至是gif都能将图片显示出来....
        FileOutputStream fos = new FileOutputStream(file2);
        fos.write(imageByte);
        fos.close();
    }

}