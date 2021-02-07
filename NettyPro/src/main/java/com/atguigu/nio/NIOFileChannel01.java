package com.atguigu.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/30 18:29
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello world!";
        //创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
        //通过输出流，获取对应的FileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将String放入到ByteBuffer
        byteBuffer.put(str.getBytes());
        //对ByteBuffer进行反转
        byteBuffer.flip();
        //将ByteBuffer写入到fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
