package com.healist.nettycar.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 说明：心跳服务器处理器
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年11月6日
 */
@Slf4j
public class HeartbeatServerHandler extends ChannelInboundHandlerAdapter {
	
	// Return a unreleasable view on the given ByteBuf
	// which will just ignore release and retain calls.
	private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled
			.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat",
					CharsetUtil.UTF_8));


	private ChannelGroup channels = CarChannelGroup.getInstance();

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {

		Channel channel = ctx.channel();

		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			String type = "";
			if (event.state() == IdleState.READER_IDLE) {
				type = "read idle";
			} else if (event.state() == IdleState.WRITER_IDLE) {
				type = "write idle";
			} else if (event.state() == IdleState.ALL_IDLE) {
				type = "all idle";
			}

			ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(
					ChannelFutureListener.CLOSE_ON_FAILURE);

			// 去除socket具柄，然后关闭连接
			channels.remove(channel);
			channel.close();

			// log
			System.out.println( ctx.channel().remoteAddress()+"超时类型：" + type);
			log.error( ctx.channel().remoteAddress()+"超时类型：" + type );

		} else {
			super.userEventTriggered(ctx, evt);
		}
	}
}
