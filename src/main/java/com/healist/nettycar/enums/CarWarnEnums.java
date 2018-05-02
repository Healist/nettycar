package com.healist.nettycar.enums;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午10:50
 */
public enum CarWarnEnums {

    /**
     * 运行状态
     */
    ERROR(true, 1),

    /**
     * 熄火状态
     */
    GOOD(false, 0);


    boolean warning;
    int num;

    CarWarnEnums(boolean warning, int num) {
        this.warning = warning;
        this.num = num;
    }

    public boolean isWarning() {
        return warning;
    }

    public int getNum() {
        return num;
    }
}
