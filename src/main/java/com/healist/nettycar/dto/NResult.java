package com.healist.nettycar.dto;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午6:16
 */
public class NResult {

    public int code;

    public String desc;

    public Object detail;


    public NResult(NCode code) {
        this.code = code.codeValue;
        this.desc = code.getDesc();
    }

    public NResult(NCode code, Object detail) {
        this.code = code.codeValue;
        this.desc = code.getDesc();
        this.detail = detail;
    }

    public NResult(NCode code, String desc) {
        this.code = code.codeValue;
        this.desc = desc;
    }


    public static enum NCode {

        SUCCESS(1000, "成功"),
        TOO_OFTEN(1001, "请求过于频繁"),
        TIMESTAMP_ERROR(1002, "请求时间戳错误"),
        ACCOUNT_NOT_EXIST(1003, "帐号不存在"),
        AES_ERROR(1004, "加解密失败"),
        STATUS_FORBIDEN(1005, "帐号状态无效"),
        CLOUN_MUSIC_IS_ACCOUNT(1006, "云音乐账号已是音箱账号"),
        CLOUN_MUSIC_IS_ACCOUNT_CAN_NOT_MERGE(1007, "云音乐账号跟手机账号绑定音箱超过上限"),
        BUSSINESS_ERROR(2000, "业务逻辑错误"),
        YXREGISTER_ERROR(2001, "注册云信账户失败"),
        LOGIN_FAIL(2002, "登录失败"),
        PARAM_ERROR(3000, "参数错误"),
        PARAM_ERROR_REPEAT(3001, "名称唯一"),
        PARAM_ERROR_UNIQUE(3002, "参数唯一"),
        PARAM_ERROR_OUTTIME(3003, "提醒时间已过"),
        PARAM_ERROR_PLAYLIST_NOT_CAN(3004, "歌单无法播放"),
        CLOCK_TIME_SAME(3005, "存在相同闹钟"),
        REMIND_TIME_SAME(3006, "存在相同提醒"),
        FORBIDDEN_REQUEST(4003, "拒绝服务"),
        RESOURCE_NOT_FOUND(4004, "资源未找到"),
        RESOURCE_HAS_EXIST(4009, "资源已存在"),
        THIRD_SC_INTERNAL_SERVER_ERROR(4001, "第三方接口异常"),
        UNKNOW_ERROR(9999, "系统错误");

        private int codeValue;
        private String desc;

        private NCode(int codeValue, String desc) {
            this.codeValue = codeValue;
            this.desc = desc;
        }

        public int getCodeValue() {
            return this.codeValue;
        }

        public void setCodeValue(int codeValue) {
            this.codeValue = codeValue;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }
}
