package com.healist.nettycar.server;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author healist
 * @Description
 * @Create 2018-06-04 上午10:58
 */
@Component
public class StartConfig {

    @PostConstruct
    public void init() {
        Thread carServerThread = new Thread(new CarServer());
        carServerThread.start();
    }

}
