package com.yinghuaicc.stars.controller.config.aop.pc;

import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.controller.config.system.SystemResource;
import com.yinghuaicc.stars.controller.config.utils.EndecryptUtil;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.mapper.token.TokenMapper;
import com.yinghuaicc.stars.repository.model.region.Project;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectData;
import com.yinghuaicc.stars.repository.model.token.Token;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午10:43
 * @Description:
 * @Modified:
 */
@Component
@Aspect
public class IdentityCheck {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private SystemResource systemResource;

    @Autowired
    private EndecryptUtil endecryptUtil;

    /**
     *@Author:Fly Created in 2018/7/3 上午11:03
     *@Description: 设置切面：用户登录、刷新AccessToken无需进行AOP
     */
    @Before("execution(* com.yinghuaicc.stars.controller.business.pc..*.*(..)) " +
            "&& !execution(* com.yinghuaicc.stars.controller.business.pc.tissue.TissueController.employeeLogin(..)) " +
            "&& !execution(* com.yinghuaicc.stars.controller.business.pc.token.TokenController.refreshToken(..))" +
            "&& !execution(* com.yinghuaicc.stars.controller.business.pc.sso.SSOLoginController.ssoLogin(..))")
    public void checkToken(JoinPoint pro) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String accessToken = request.getHeader("ACCESS-TOKEN");

        if (StringUtils.isEmpty(accessToken)){

            throw exceptionUtil.throwCustomException("AOP_CHECK_TOKEN_001");
        }

//        Token token = tokenMapper.findByAccessToken(accessToken);
//
//        if (Objects.isNull(token)){
//
//            throw exceptionUtil.throwCustomException("AOP_CHECK_TOKEN_002");
//        }
//
//        //判断Token使用时间，Token失效后需要重新刷新，获取新的Token，
//        if (LocalDateTimeUtils.betweenTwoTime(token.getModifyTime(), LocalDateTime.now(), ChronoUnit.MINUTES) > Long.valueOf(systemResource.getTokenAbleMinutes())){
//
//            throw exceptionUtil.throwCustomException("AOP_CHECK_TOKEN_003");
//        }

        this.setAopResourceEmployeeBean(accessToken);

//        Object proceed = pro.proceed();

//        return proceed;
    }

    /**
     *@Author:Fly Created in 2018/7/3 下午1:45
     *@Description: 将账户属性进行注入
     */
    private void setAopResourceEmployeeBean(String employeeUserName){

        AopResourceEmployeeBean aopResourceEmployeeBean =
                applicationContext.getBean(AopResourceEmployeeBean.class);

        List<Employee> employees = tissueMapper.findEmployeeByUserName(endecryptUtil.get3DESDecrypt(employeeUserName,systemResource.getSsoPrivateKey()));

        if (Objects.isNull(employees)||employees.size()==0){

            throw exceptionUtil.throwCustomException("AOP_CHECK_TOKEN_002");
        }

        Employee employee = employees.get(0);

        aopResourceEmployeeBean
                .setId(employee.getId())
                .setName(employee.getName())
                .setNum(employee.getNum())
                .setPhone(employee.getPhone())
                .setUserName(employee.getUserName())
                .setProjectIds(this.getProjectIds(employee.getId()));
    }

    /**
     *@Author:Fly Created in 2018/7/6 下午12:57
     *@Description: 获取数据权限
     */
    private List<String> getProjectIds(String employeeId){

        //如果是超级管理员则获取全部数据权限
        if ("1".equals(employeeId)){

            List<Project> projects = regionMapper.findProjectAll();

            return Objects.isNull(projects)||projects.size()==0
                    ?
                    null
                    :
                    projects.stream().map(Project::getId).collect(Collectors.toList());
        }

        List<EmployeeProjectData> employeeProjectData =
                tissueMapper.findEmployeeProjectDataByEmployeeId(employeeId);

        return Objects.isNull(employeeProjectData)||employeeProjectData.size()==0
                ?
                null
                :
                employeeProjectData.stream().map(EmployeeProjectData::getProjectId).collect(Collectors.toList());
    }
}
