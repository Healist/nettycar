package com.healist.nettycar.dto;

import lombok.Data;

/**
 * @Author healist
 * @Description
 * @Create 2018-06-10 上午10:37
 */
@Data
public class CustomMsg {

    /**
     * 开始标识
     */
    private byte start;

    /**
     * 命令标识
     */
    private byte flag;

    /**
     * 应答类型
     */
    private byte reply;


    /**
     * 设备类型
     */
    private byte type;

    /**
     * 叉车唯一编码 固定长度为10byte
     */
    private String uuid;

    /**
     * 数据单元长度
     */
    private int length;

    /**
     * 消息正文
     */
    private String body;

    /**
     * 结束标识
     */
    private byte end;

    public CustomMsg() {}

    public CustomMsg(byte start, byte flag, byte reply, byte type, String uuid, int length, String body, byte end) {
        this.start = start;
        this.flag = flag;
        this.reply = reply;
        this.type = type;
        this.uuid = uuid;
        this.length = length;
        this.body = body;
        this.end = end;
    }



}
