package com.healist.nettycar.controller;

import com.healist.nettycar.dto.NResult;
import com.healist.nettycar.server.handler.MessageHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author healist
 * @Description
 * @Create 2018-05-03 下午9:34
 */
@RestController
@RequestMapping("/")
public class CarController {


    @RequestMapping("/hello")
    public String SayHello() {
        return "Hello, this project is nettyCar";
    }


    @RequestMapping("login")
    public NResult login(@RequestBody String req){
        boolean flag = MessageHandler.handleLogin(req);
        if(flag) {
            return new NResult(NResult.NCode.SUCCESS);
        }
        return new NResult(NResult.NCode.LOGIN_FAIL);
    }

    @RequestMapping("logout")
    public NResult logout(@RequestBody String req){
        boolean flag = MessageHandler.handleLogout(req);
        if(flag) {
            return new NResult(NResult.NCode.SUCCESS);
        }
        return new NResult(NResult.NCode.LOGIN_FAIL);
    }

}
