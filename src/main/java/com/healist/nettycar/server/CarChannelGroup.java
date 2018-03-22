package com.healist.nettycar.server;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-22 下午3:30
 */
public class CarChannelGroup {

    private volatile static ChannelGroup carGroup;

    private CarChannelGroup() {}

    public synchronized static ChannelGroup getInstance() {
        if(carGroup == null) {
            carGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        }
        return carGroup;
    }

}
