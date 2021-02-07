package com.atguigu.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import sun.nio.cs.ext.MS874;

import java.net.URI;

/**
 *  SimpleChannelInboundHandler 是 ChannelInboundHandlerAdapter 的子类
 *  HttpObject 表示客户端和服务器端相互通讯的数据被封装从 HttpObject
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/2 11:56
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     *  读取客户端数据
     * @param channelHandlerContext
     * @param httpObject
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        //判断httpObject是不是httprequest请求
        if (httpObject instanceof HttpObject){
            System.out.println("httpObject 类型" +  httpObject.getClass());
            System.out.println("客户端地址" +  channelHandlerContext.channel().remoteAddress());
            //获取到
            HttpRequest httpRequest = (HttpRequest) httpObject;
            //获取uri
            URI uri = new URI(httpRequest.uri());

            //回复信息给浏览器 [http协议]
            ByteBuf content = Unpooled.copiedBuffer("hello，我是服务器", CharsetUtil.UTF_8);
            //构造一个http的响应，即httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
            //将构建好的response 返回
            channelHandlerContext.writeAndFlush(response);

        }
    }
}
