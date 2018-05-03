package com.healist.nettycar.controller;

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

}
