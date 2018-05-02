package com.healist.nettycar.server.handler;

import com.healist.nettycar.common.constant.Constant;
import com.healist.nettycar.entity.Car;
import com.healist.nettycar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午7:34
 */
@Component
public class MessageHandler {

    private static Car car = new Car();

    private static CarService carService;

    @Autowired
    private CarService carServiceTemp;

    @PostConstruct
    public void init() {
        carService = carServiceTemp;
    }

    public static void handleMsg(String str) {
        switch (str) {
            case Constant.CAR_STATE:

                break;

            case Constant.ID:

                break;
            case Constant.CAR_POS:

                break;
            case Constant.CAR_DRIVER:

                break;
            case Constant.WATER_TEMP:

                break;
            case Constant.OIL_TEMP:

                break;
            case Constant.ROTATING_SPEED:

                break;
            case Constant.CAR_SPEED:

                break;
            case Constant.CAR_STOLLS:

                break;
            case Constant.OIL_PRESSURE:

                break;
            case Constant.VOLTAGE:

                break;
            case Constant.EXCEPTION:

                break;
            case Constant.TIME:

                break;
            case Constant.END:
                // 结束操作，储存数据并且生成新对象
                if(car != null) {
                    carService.insertInfo(car);
                }
                car = new Car();
                break;
            default:
                break;
        }
    }

}
