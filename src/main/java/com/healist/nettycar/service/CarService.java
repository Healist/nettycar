package com.healist.nettycar.service;

import com.healist.nettycar.dao.CarMapper;
import com.healist.nettycar.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-23 下午3:50
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;


    public int insertInfo(Car car) {
        int res = carMapper.insertInfo(car);
        if(res > 0) System.out.println("insert success");
        return res;
    }


    public int getCarByBumber(String carNumber) {
        return carMapper.getCarByNumber(carNumber);
    }
}
