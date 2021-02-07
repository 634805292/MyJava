package com.atguigu.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/2 11:59
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器
        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        /*
        加入一个netty提供的httpServerCodec codec => [coder - decoder]
        HttpServerCodec说明：
            1.HttpServerCodec是netty提供的处理http的编码解码器
         */
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        // 增加一个自定义的Handler
        pipeline.addLast("MyTestHttpServerHandler",new TestHttpServerHandler());
    }
}
