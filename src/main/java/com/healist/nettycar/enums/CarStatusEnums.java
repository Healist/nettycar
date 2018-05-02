package com.healist.nettycar.enums;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午10:43
 */
public enum CarStatusEnums {

    /**
     * 运行状态
     */
    RUNNING(true, 1),

    /**
     * 熄火状态
     */
    DOWN(false, 0);


    boolean breakDown;
    int num;

    CarStatusEnums(boolean breakDown, int num) {
        this.breakDown = breakDown;
        this.num = num;
    }


    public boolean isBreakDown() {
        return breakDown;
    }

    public int getNum() {
        return num;
    }
}
