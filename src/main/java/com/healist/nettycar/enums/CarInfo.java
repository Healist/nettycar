package com.healist.nettycar.enums;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午6:52
 */
public enum CarInfo {

    CarState("S1", "车辆状态"),
    CarPos("W1", "车辆位置"),
    CarDriver("D1", "叉车司机"),
    WaterTemp("I1", "水温"),
    OilTemp("I2", "油温"),
    RotatingSpeed("I3", "转速"),
    CarSpeed("I4", "叉车速度"),
    CarStolls("I5", "叉车档位"),
    OilPressure("I6", "机油压力"),
    Voltage("I7", "电压"),
    Exception("E1", "异常");



    private CarInfo(String symbol, String desc) {
        this.desc = desc;
        this.symbol = symbol;
    }

    String symbol;
    String desc;

    public String getSymbol() {
        return symbol;
    }

    public String getDesc() {
        return desc;
    }
}
