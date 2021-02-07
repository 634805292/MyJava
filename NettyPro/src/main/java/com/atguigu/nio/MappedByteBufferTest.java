package com.atguigu.nio;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer可以让文件直接在内存(堆外内存)修改，操作系统不需要拷贝一次
 *
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/30 19:27
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("2.txt", "rw");
        //获取对应的文件通道
        FileChannel channel = randomAccessFile.getChannel();
        /*
            参数1：FileChannel.MapMode.READ_WRITE 读写模式
            参数2：0  可以直接修改的起始位置
            参数3：5   映射到内存的大小，即将2.txt的多少个字节映射到内存
                        可以直接修改的范围就是0-5
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0, (byte) 'H');
        map.put(3, (byte) '9');
        System.out.println("修改成功");

    }
}
