package com.yinghuaicc.stars.service.sso;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.controller.config.system.SystemResource;
import com.yinghuaicc.stars.controller.config.utils.EndecryptUtil;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.mapper.token.TokenMapper;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.token.AppToken;
import com.yinghuaicc.stars.repository.model.token.Token;
import com.yinghuaicc.stars.service.sso.dto.request.AppSsoRequestDTO;
import com.yinghuaicc.stars.service.sso.dto.request.SsoRequestDTO;
import com.yinghuaicc.stars.service.tissue.dto.response.EmployeeLoginInfoResponseDTO;
import com.yinghuaicc.stars.service.tissue.dto.response.EmployeeLoginTokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/24 下午4:52
 * @Description: 单点登录
 * @Modified:
 */
@Service
public class SsoServiceImpl implements SsoService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private EndecryptUtil endecryptUtil;

    @Autowired
    private SystemResource systemResource;

    /**
     *@Author:Fly Created in 2018/7/24 下午4:53
     *@Description: 单点登录
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EmployeeLoginTokenResponseDTO ssoLogin(SsoRequestDTO ssoRequestDTO) {

        List<Employee> employees =
                tissueMapper.findEmployeeByUserName(
                        endecryptUtil.get3DESDecrypt(ssoRequestDTO.getUserName(),systemResource.getSsoPrivateKey()));

        if (Objects.isNull(employees)||employees.size()==0){

            throw exceptionUtil.throwCustomException("SSO_LOGIN_002");
        }

        Employee employee = employees.get(0);

//        List<Token> tokens =
//                tokenMapper.findTokenByEmployeeId(employee.getId());

//        Token token = null;
//
//        //修改用户的token信息
//        if (Objects.nonNull(tokens)&&tokens.size()>0){
//
//            token = tokens.get(0);
//
//            List<String> uuids = UuidUtil.batchRandomUUID(2);
//
//            token.setAccessToken(uuids.get(0))
//                    .setRefreshToken(uuids.get(1))
//                    .setEmployeeId(employee.getId())
//                    .setCreateUser(employee.getId())
//                    .setModifyUser(employee.getId())
//                    .setCreateTime(LocalDateTime.now())
//                    .setModifyTime(LocalDateTime.now());
//        }

        return new EmployeeLoginTokenResponseDTO()
                .setAccessToken(endecryptUtil.get3DESEncrypt(employee.getUserName(),systemResource.getSsoPrivateKey()))
//                .setRefreshToken(token.getRefreshToken())
                .setEmployeeLoginInfoResponseDTO(
                        MapperFactoryUtil.mapperObject(employee, EmployeeLoginInfoResponseDTO.class));
    }

    /**
     *@Author:Fly Created in 2018/7/25 下午5:01
     *@Description: 移动端单点登录
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EmployeeLoginTokenResponseDTO appSsoLogin(AppSsoRequestDTO appSsoRequestDTO) {

        List<Employee> employees =
                tissueMapper.findEmployeeByUserName(
                        endecryptUtil.get3DESDecrypt(appSsoRequestDTO.getThirdUserName(),systemResource.getSsoPrivateKey()));

        if (Objects.isNull(employees)||employees.size()==0){

            throw exceptionUtil.throwCustomException("APP_SSO_LOGIN_002");
        }

        Employee employee = employees.get(0);

//        List<Token> tokens =
//                tokenMapper.findTokenByEmployeeId(employee.getId());
//
//        Token token = null;
//
//        //修改用户的token信息
//        if (Objects.nonNull(tokens)&&tokens.size()==0){
//
//            token = tokens.get(0);
//
//            List<String> uuids = UuidUtil.batchRandomUUID(2);
//
//            token.setAccessToken(uuids.get(0))
//                    .setRefreshToken(uuids.get(1))
//                    .setEmployeeId(employee.getId())
//                    .setCreateUser(employee.getId())
//                    .setModifyUser(employee.getId())
//                    .setCreateTime(LocalDateTime.now())
//                    .setModifyTime(LocalDateTime.now());
//        }

        return new EmployeeLoginTokenResponseDTO()
                .setAccessToken(endecryptUtil.get3DESEncrypt(employee.getUserName(),systemResource.getSsoPrivateKey()))
//                .setRefreshToken(token.getRefreshToken())
                .setEmployeeLoginInfoResponseDTO(
                        MapperFactoryUtil.mapperObject(employee.setUserName(endecryptUtil.get3DESEncrypt(employee.getUserName(),systemResource.getSsoPrivateKey())), EmployeeLoginInfoResponseDTO.class));

    }
}
