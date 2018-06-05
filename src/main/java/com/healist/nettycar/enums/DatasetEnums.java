package com.healist.nettycar.enums;

import lombok.Getter;

/**
 * @Author healist
 * @Description
 * @Create 2018-06-05 上午10:29
 */
public enum DatasetEnums {

    /*
    左闭右开
     */
    EQUIPMENT_NUM(4,5);


    @Getter
    int start;

    @Getter
    int end;


    DatasetEnums(int start, int end) {
        this.start = start;
        this.end = end;
    }


}
