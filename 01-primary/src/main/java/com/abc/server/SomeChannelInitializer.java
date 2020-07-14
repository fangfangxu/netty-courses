package com.abc.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

//管道初始化器
public class SomeChannelInitializer extends ChannelInitializer<SocketChannel> {

   //当Channel被创建完毕后就会触发该方法的执行，用于
    //初始化Channel
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
       //从Channel中获取pipeline
        ChannelPipeline pipeline = ch.pipeline();
        //将HttpServerCodec处理器放入到pipeline的最后
        //HttpServerCodec是什么？HttpRequestDecoder  与HttpResponseEncoder的复合体
        //HttpRequestDecoder Http请求解码器，将Channel中的ByteBuf数据解码为HttpRequest对象
        //HttpResponseEncoder Http请求编码器，将HttpResponse对象编码为将要在Channel中发送的ByteBuf数据
        //Client        管道           Server
        //    byteBuffer-->httpRequest  叫解码
        //    byteBuffer<--httpResponse 叫编码
        pipeline.addLast(new HttpServerCodec());
        //将自定义的处理器放入到pipeline的最后
        pipeline.addLast(null);



    }
}
