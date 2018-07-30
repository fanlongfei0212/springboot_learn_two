package com.yinghuaicc.stars.common.utils.exception;

import com.yinghuaicc.stars.config.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @Author:Fly
 * @Date:Create in 2018/5/31 下午4:32
 * @Description: 异常工具类
 * @Modified:
 */
@Component
public class ExceptionUtil {

    @Autowired
    private Environment environment;

    /**
     *@Author:Fly Created in 2018/5/31 下午4:35
     *@Description: 生成自定义异常
     */
    public CustomException throwCustomException(String errorCode){

        if(StringUtils.isEmpty(errorCode)){

            new CustomException("sys001", "errorCode不能为空");
        }

        String errorMessage = environment.getProperty(errorCode);

        return StringUtils.isEmpty(errorMessage)
                ?
                new CustomException("sys002", "请设置有效的errorCode")
                :
                new CustomException(errorCode, errorMessage);
    }

    /**
     *@Author:Fly Created in 2018/6/24 下午6:38
     *@Description: 生产动态异常
     */
    public CustomException throwCustomDynamicException(String errorCode, String errorMessage){

        return StringUtils.isEmpty(errorCode)
                ?
                new CustomException("sys001", "errorCode不能为空")
                :
                (StringUtils.isEmpty(errorMessage)
                        ?
                        new CustomException("sys005", "使用动态异常，errorMessage不能为空")
                        :
                        new CustomException(errorCode, errorMessage));
    }
}
