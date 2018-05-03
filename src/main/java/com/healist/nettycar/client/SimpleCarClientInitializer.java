package com.healist.nettycar.client;

import com.healist.nettycar.common.constant.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * @Author healist
 * @Description
 * @Create 2018-03-22 下午2:52
 */
public class SimpleCarClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        ByteBuf delimiter = Unpooled.copiedBuffer(Constant.JOINER.getBytes());
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, delimiter));
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("handler", new SimpleCarClientHandler());
    }

}
