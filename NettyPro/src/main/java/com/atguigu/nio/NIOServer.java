package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/31 10:10
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到Selector对象
        Selector selector = Selector.open();
        //绑定一个端口6666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到Selector，关心事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true) {
            //等待1秒，如果没有事件发生，就返回
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            /*
            如果返回>0,获取到相关的SelectionKey集合
                1.如果返回>0，表示已经获取到关注的事件
                2.selector.selectedKeys()返回关注事件的集合
                    通过selectionKeys反向获取通道
             */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历Set<SelectionKey>，使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发发生的事件做相应的处理
                //如果是OP_ACCEPT，即有新的客户端连接
                if (key.isAcceptable()) {
                    //该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个 socketChannel"+socketChannel.hashCode());
                    //将socketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将当前的socketChannel注册到selector,关注事件为OP_READ，同时给该socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //发生OP_READ
                if (key.isReadable()) {
                    //通过key 反向获取到对应的Channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到该channel关联的Buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端："+ new String(buffer.array()));
                }
                //手动从集合中移除当前的selectionKey,防止重复操作
                keyIterator.remove();
            }
        }
    }
}
