package com.healist.nettycar.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-27 上午10:06
 */
@Data
public class Car {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 汽车编号
     */
    String carNumber;

    /**
     * 当前驾驶员
     */
    String driver;

    /**
     * 经纬度
     */
    String latitude;

    String longitude;

    /**
     * 车速
     */
    int speed;

    /**
     * 上报时间
     */
    Date reportDate;

    /**
     * 是否报警
     */
    boolean warning;

    /**
     * 有无故障
     */
    boolean breakdown;

    /**
     * 水温
     */
    int waterTemperature;

    /**
     * 油温
     */
    int oilTemperature;

    /**
     * 转速
     */
    int rotatingSpeed;

    /**
     * 电压
     */
    int voltage;

    /**
     * 机油压力
     */
    int oilPressure;

    /**
     * 档位
     */
    int stalls;

    /**
     * IP地址
     */
    String ip;

    /**
     * 创建时间
     */
    Date gmtCreate;



//    /**
//     * 动力类型
//     */
//    String powerType;
//
//    /**
//     * 油量
//     */
//    int oilAmount;
//
//    /**
//     * 开机or关机
//     */
//    boolean running;
//
//    /**
//     * 是否锁车
//     */
//    boolean locked;
//
//    /**
//     * 座椅开关状态（1：正常，0：不正常）
//     */
//    byte chairSwitchState;
//
//    /**
//     * 是否系上安全带
//     */
//    boolean seatBelt;
//
//    /**
//     * 手制动状态（1：正常，0：不正常）
//     */
//    byte handBreak;

}
