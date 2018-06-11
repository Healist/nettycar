package com.healist.nettycar.server;

import com.healist.nettycar.dto.CustomMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.util.Random;

/**
 * @Author healist
 * @Description
 * @Create 2018-06-10 上午10:33
 */
public class CustomDecoder extends LengthFieldBasedFrameDecoder {

    private static final int HEADER_SIZE = 18;

    private byte start;

    private byte flag;

    private byte reply;

    private byte type;

    private String uuid;

    private int length;

    private String body;

    private byte end;

    /**
     *
     * @param maxFrameLength 解码时，处理每个帧数据的最大长度
     * @param lengthFieldOffset 该帧数据中，存放该帧数据的长度的数据的起始位置
     * @param lengthFieldLength 记录该帧数据长度的字段本身的长度
     * @param lengthAdjustment 修改帧数据长度字段中定义的值，可以为负数
     * @param initialBytesToStrip 解析的时候需要跳过的字节数
     * @param failFast 为true，当frame长度超过maxFrameLength时立即报TooLongFrameException异常，为false，读取完整个帧再报异常
     */
    public CustomDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength,
                         int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if(in == null) {
            return null;
        }
//        System.out.println(in.readByte());
//        System.out.println(in.readByte());
//        if(in.readableBytes() < HEADER_SIZE) {
//            throw new Exception("可读信息段比头部信息都小，你在逗我？");
//        }
//        start = in.readByte();
//        if(start != 126) {
//            return null;
//        }
//
//
//        flag = in.readByte();
//        reply = in.readByte();
//        type = in.readByte();
//        uuid = in.readBytes(10).toString();
//        length = in.readInt();
//        if(in.readableBytes() < length) {
//            throw new Exception("body字段你告诉我长度是"+length+",但是真实情况是没有这么多，你又逗我？");
//        }
//        ByteBuf buf = in.readBytes(length);
//        byte[] content = new byte[buf.readableBytes()];
//        buf.readBytes(content);
//        body = new String(content, "UTF-8");
        in.skipBytes(in.readableBytes());
        CustomMsg msg = new CustomMsg();
        initMsg(msg);
        return msg;
    }

    private void initMsg(CustomMsg msg) {

        msg.setStart(((byte) '~'));
        msg.setFlag((byte) '1');
        msg.setReply((byte) '2');
        msg.setType((byte) '3');
        msg.setUuid(random10num());
        msg.setLength(20);
        msg.setBody(random10num2());
        msg.setEnd((byte) '~');
    }


    public String random10num() {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<10; i++) {
            sb.append((int)(10*(Math.random())));
        }
        return sb.toString();
    }

    public String random10num2() {
        int num = (int)(10 * (Math.random()));
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<20; i++) {
            sb.append((int)(new Random().nextInt(6)+1));
        }
        return sb.toString();
    }
}
