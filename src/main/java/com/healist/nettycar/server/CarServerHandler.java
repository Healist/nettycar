package com.healist.nettycar.server;

import com.healist.nettycar.dto.CustomMsg;
import com.healist.nettycar.server.handler.MessageHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-14 下午5:23
 */
public class CarServerHandler extends SimpleChannelInboundHandler<Object> {

    private ChannelGroup channels = CarChannelGroup.getInstance();

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();

        // Broadcast a message to multiple Channels
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入\n");

        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();

        // Broadcast a message to multiple Channels
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开\n");

        // A closed Channel is automatically removed from ChannelGroup,
        // so there is no need to do "channels.remove(ctx.channel());"
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
        Channel incoming = ctx.channel();
        if(obj instanceof CustomMsg) {
            CustomMsg customMsg = (CustomMsg) obj;
            MessageHandler.handleBytesMsg(customMsg, incoming);
            System.out.println("received: " + customMsg);
        }
//        System.out.println("received:" + s);
//        MessageHandler.handleMsg(s, incoming);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("nettyCar:"+incoming.remoteAddress()+"在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("nettyCar:"+incoming.remoteAddress()+"掉线");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("nettyCar:"+incoming.remoteAddress()+"异常退出");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
