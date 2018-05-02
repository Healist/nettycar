package com.healist.nettycar.common.exception;

import com.healist.nettycar.dto.NResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author healist
 * @Description
 * @Create 2018-05-02 下午6:12
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public NResult processServerException(Exception ex) {
        logger.error("未捕捉异常:", ex);
        return new NResult(NResult.NCode.UNKNOW_ERROR, ex.toString());
    }

}
