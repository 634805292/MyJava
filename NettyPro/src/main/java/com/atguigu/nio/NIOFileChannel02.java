package com.atguigu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/30 18:42
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        //创建文件输入流
        File file = new File("d:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将通道的数据读入到Buffer
        fileChannel.read(byteBuffer);
        //将byteBuffer的字节转成字符串
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
