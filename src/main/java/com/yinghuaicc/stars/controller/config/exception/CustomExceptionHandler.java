package com.yinghuaicc.stars.controller.config.exception;

import com.yinghuaicc.stars.config.exception.CustomException;
import com.yinghuaicc.stars.config.response.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/31 下午4:49
 * @Description: 异常捕获Controller
 * @Modified:
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment environment;

    /**
     *@Author:Fly Created in 2018/5/31 下午8:25
     *@Description: 异常捕获以及处理
     */
    @ExceptionHandler(value = Exception.class)
    public JsonResult customHandler(Exception e, HttpServletRequest httpServletRequest){

        logger.error("调用地址："+httpServletRequest.getRequestURI());

        e.printStackTrace();

        return this.rulingExceptionType(e);
    }

    /**
     *@Author:Fly Created in 2018/6/15 下午5:27
     *@Description: 校验类型裁决
     */
    private JsonResult rulingExceptionType(Exception exception){

        return exception instanceof CustomException
                ?
                this.customException((CustomException) exception)
                :
                (exception instanceof MethodArgumentNotValidException
                        ?
                        this.methodArgumentNotValidException(((MethodArgumentNotValidException) exception))
                        :
                        this.otherException());
    }

    /**
     *@Author:Fly Created in 2018/6/15 下午5:36
     *@Description: 其他异常处理
     */
    private JsonResult otherException(){

        return JsonResult.error("sys003", "系统异常");
    }

    /**
     *@Author:Fly Created in 2018/6/15 下午5:22
     *@Description: 自定义异常处理
     */
    private JsonResult customException(CustomException customException){

        return JsonResult.error(customException.getErrorCode(), customException.getErrorMessage());
    }

    /**
     *@Author:Fly Created in 2018/6/15 下午5:25
     *@Description: 校验异常处理
     */
    private JsonResult methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

        String errorCode = methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        String errorMessage = environment.getProperty(errorCode);

        return StringUtils.isEmpty(errorCode)||StringUtils.isEmpty(errorMessage)
                ?
                JsonResult.error("sys004", "注解校验配置异常信息不存在")
                :
                JsonResult.error(errorCode, errorMessage);
    }
}
