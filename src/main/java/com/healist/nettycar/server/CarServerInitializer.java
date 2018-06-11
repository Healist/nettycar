package com.healist.nettycar.server;

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
 * @Create 2018-03-14 下午5:17
 */
public class CarServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;
    private static final int LENGTH_FIELD_LENGTH = 4;
    private static final int LENGTH_FIELD_OFFSET = 2;
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

          /*
            基于分隔符的协议解析
          */
//        ByteBuf delimiter = Unpooled.copiedBuffer(Constant.JOINER.getBytes());
//        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, delimiter));
//        pipeline.addLast("decoder", new StringDecoder());
//        pipeline.addLast("encoder", new StringEncoder());
//        pipeline.addLast("handler", new CarServerHandler());

        /*
            基于变长度度协议解析
         */
        pipeline.addLast(new CustomDecoder(MAX_FRAME_LENGTH, LENGTH_FIELD_LENGTH, LENGTH_FIELD_OFFSET
                , LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP, false));
        pipeline.addLast(new CarServerHandler());

        System.out.println(socketChannel.remoteAddress() + "已连接！");
    }
}
