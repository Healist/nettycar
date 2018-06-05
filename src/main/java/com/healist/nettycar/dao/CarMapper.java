package com.healist.nettycar.dao;

import com.healist.nettycar.model.Car; /**
 * @Author healist
 * @Description
 * @Create 2018-03-23 下午3:50
 */
public interface CarMapper {


    int insertInfo(Car car);

    int getCarByNumber(String carNumber);
}
