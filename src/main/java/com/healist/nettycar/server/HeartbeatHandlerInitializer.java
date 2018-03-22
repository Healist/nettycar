package com.healist.nettycar.server;

import com.healist.nettycar.enums.IdleStateEnums;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class HeartbeatHandlerInitializer extends ChannelInitializer<Channel> {

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new IdleStateHandler(IdleStateEnums.READ_IDEL_TIME_OUT.num,
				IdleStateEnums.WRITE_IDEL_TIME_OUT.num, IdleStateEnums.ALL_IDEL_TIME_OUT.num, TimeUnit.SECONDS));
		pipeline.addLast(new HeartbeatServerHandler());
	}
}