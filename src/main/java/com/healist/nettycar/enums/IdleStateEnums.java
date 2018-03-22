package com.healist.nettycar.enums;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-22 下午3:53
 */
public enum IdleStateEnums {

    /**
     * 读超时
     */
    READ_IDEL_TIME_OUT(4, "读超时"),

    /**
     * 写超时
     */
    WRITE_IDEL_TIME_OUT(5, "写超时"),

    /**
     * 所有超时
     */
    ALL_IDEL_TIME_OUT(7, "所有超时");

    public int num;
    public String value;

    IdleStateEnums(int num, String value) {
        this.num = num;
        this.value = value;
    }

}
