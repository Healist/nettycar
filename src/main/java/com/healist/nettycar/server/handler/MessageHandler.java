package com.healist.nettycar.server.handler;

import com.alibaba.fastjson.JSON;
import com.healist.nettycar.common.constant.Constant;
import com.healist.nettycar.common.utils.ToolUtils;
import com.healist.nettycar.dto.CustomMsg;
import com.healist.nettycar.enums.DatasetEnums;
import com.healist.nettycar.model.Car;
import com.healist.nettycar.enums.CarStatusEnums;
import com.healist.nettycar.enums.CarWarnEnums;
import com.healist.nettycar.service.CarService;
import io.netty.channel.Channel;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午7:34
 */
@Component
public class MessageHandler {

    private static Car car = new Car();

//    private static ThreadLocal<Car> contextHolder = new ThreadLocal<>();

    private static CarService carService;

    @Autowired
    private CarService carServiceTemp;

    @PostConstruct
    public void init() {
        carService = carServiceTemp;
    }

    public static boolean handleLogout(String req) {
        return true;
    }


    public static boolean handleLogin(String str) {
        if(str.startsWith(Constant.START) && str.endsWith(Constant.END)) {
            String carNumber = getItemFromStr(str, DatasetEnums.EQUIPMENT_NUM);
            int count = carService.getCarByBumber(carNumber);
            return count > 0;
        }
        return false;
    }

    private static String getItemFromStr(String str, DatasetEnums equipmentNum) {
        int start = equipmentNum.getStart();
        int end = equipmentNum.getEnd();
        return str.substring(start, end);
    }

    public static void handleBytesMsg(CustomMsg msg, Channel incoming) {
        String str = "ID:8fb580bda9d8Q1TI:1525334150Q1S1:1Q1W1:35Q1W2:120Q1D1:007Q1I1:" +
                "45Q1I2:80Q1I3:120Q1I4:100Q1I5:1Q1I6:200Q1I7:150Q1ENDQ1";
        String[] arr = str.split(Constant.JOINER);
        for(String item : arr) {
            handleMsg(item, incoming);
        }
    }

    public static void handleMsg(String str, Channel incoming) {
        String[] arr;
        String key = "";
        if(!str.contains(Constant.SPLITTER) && !str.equalsIgnoreCase(Constant.END)) {
            ReferenceCountUtil.release(str);
            return;
        }
        if(!str.equalsIgnoreCase(Constant.END)) {
            arr = str.split(Constant.SPLITTER);
            key = arr[0];
            str = arr[1];
        }
        else {
            key = str;
        }

        switch (key) {
            case Constant.CAR_STATE:
                if(str.equals(String.valueOf(CarStatusEnums.RUNNING.getNum()))) {
                    car.setBreakdown(CarStatusEnums.RUNNING.isBreakDown());
                }
                else if (str.equals(String.valueOf(CarStatusEnums.DOWN.getNum()))){
                    car.setBreakdown(CarStatusEnums.DOWN.isBreakDown());
                }
                break;

            case Constant.ID:
                car.setCarNumber(str);
                car.setIp(incoming.remoteAddress().toString());
                break;

            case Constant.CAR_POS1:
                car.setLongitude(str);
                break;

            case Constant.CAR_POS2:
                car.setLatitude(str);
                break;

            case Constant.CAR_DRIVER:
                car.setDriver(str);
                break;

            case Constant.WATER_TEMP:
                if (StringUtils.isNumeric(str)) {
                    car.setWaterTemperature(Integer.valueOf(str));
                }
                break;

            case Constant.OIL_TEMP:
                if (StringUtils.isNumeric(str)) {
                    car.setOilTemperature(Integer.valueOf(str));
                }
                break;

            case Constant.ROTATING_SPEED:
                if (StringUtils.isNumeric(str)) {
                    car.setRotatingSpeed(Integer.valueOf(str));
                }
                break;

            case Constant.CAR_SPEED:
                if (StringUtils.isNumeric(str)) {
                    car.setSpeed(Integer.valueOf(str));
                }
                break;

            case Constant.CAR_STOLLS:
                if (StringUtils.isNumeric(str)) {
                    car.setStalls(Integer.valueOf(str));
                }
                break;

            case Constant.OIL_PRESSURE:
                if (StringUtils.isNumeric(str)) {
                    car.setOilPressure(Integer.valueOf(str));
                }
                break;

            case Constant.VOLTAGE:
                if (StringUtils.isNumeric(str)) {
                    car.setVoltage(Integer.valueOf(str));
                }
                break;

            case Constant.EXCEPTION:
                car.setWarning(CarWarnEnums.ERROR.isWarning());
                break;

            case Constant.TIME:
                car.setReportDate(ToolUtils.timestamp2Date(str));
                break;

            case Constant.END:
                // 结束操作，储存数据并且生成新对象
                System.out.println(JSON.toJSONString(car));

                if(car != null) {
                    car.setGmtCreate(new Date());
                    int res = carService.insertInfo(car);
                    if(res > 0) {
                        System.out.println("叉车编号："+car.getCarNumber() + " 上报数据入库成功！");
                    }
                }
                car = new Car();
                break;

            default:
                break;
        }
    }


}
