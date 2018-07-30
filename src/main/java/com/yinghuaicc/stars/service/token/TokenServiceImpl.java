package com.yinghuaicc.stars.service.token;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.repository.mapper.token.TokenMapper;
import com.yinghuaicc.stars.repository.model.token.AppToken;
import com.yinghuaicc.stars.repository.model.token.Token;
import com.yinghuaicc.stars.service.token.dto.response.RefreshAppTokenResponseDTO;
import com.yinghuaicc.stars.service.token.dto.response.RefreshTokenResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午1:38
 * @Description: Token服务
 * @Modified:
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TokenMapper tokenMapper;

    /**
     *@Author:Fly Created in 2018/7/3 上午1:43
     *@Description: 刷新AccessToken
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public RefreshTokenResponseDTO refreshToken(String refreshToken) {

        if (StringUtils.isEmpty(refreshToken)){

            throw exceptionUtil.throwCustomException("TOKEN_REFRESH_TOKEN_001");
        }

        //查询Token信息
        Token token = tokenMapper.findByRefreshToken(refreshToken);

        if (Objects.isNull(token)){

            throw exceptionUtil.throwCustomException("TOKEN_REFRESH_TOKEN_002");
        }

        tokenMapper.editTokenByRefreshToken(token
                .setAccessToken(UuidUtil.randomUUID())
                .setModifyTime(LocalDateTime.now()));

        return MapperFactoryUtil.mapperObject(token, RefreshTokenResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/25 下午4:44
     *@Description: 刷新AppAccessToken
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public RefreshAppTokenResponseDTO refreshAppToken(String refreshToken) {

        //查询AppToken信息
        AppToken appToken = tokenMapper.findByRefreshAppToken(refreshToken);

        if (Objects.isNull(appToken)){

            throw exceptionUtil.throwCustomException("APP_TOKEN_REFRESH_TOKEN_001");
        }

        tokenMapper.editTokenByRefreshAppToken(appToken
                .setAccessToken(UuidUtil.randomUUID())
                .setModifyTime(LocalDateTime.now()));

        return MapperFactoryUtil.mapperObject(appToken, RefreshAppTokenResponseDTO.class);
    }
}
