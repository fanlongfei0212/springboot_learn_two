package com.yinghuaicc.stars.service.target;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.target.TargetMapper;
import com.yinghuaicc.stars.repository.model.target.Target;
import com.yinghuaicc.stars.service.target.dto.request.EditTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.FindTargetAllListRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.IsAbleTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.SaveTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.response.FindTargetAllListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:42
 * @Description:
 * @Modified:
 */
@Service
public class TargetServiceImpl implements TargetService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TargetMapper targetMapper;

    /**
     *@Author:Fly Created in 2018/7/7 下午2:43
     *@Description: 添加指标
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTarget(SaveTargetRequestDTO saveTargetRequestDTO, String loginEmployeeId) {

        if (1 != saveTargetRequestDTO.getTargetType()
                &&
                2 != saveTargetRequestDTO.getTargetType()
                &&
                3 != saveTargetRequestDTO.getTargetType()){

            throw exceptionUtil.throwCustomException("TARGET_SAVE_TARGET_004");
        }

        if (targetMapper.countTargetByNameOrShowName(saveTargetRequestDTO.getName(), null)>0
                ||
                targetMapper.countTargetByNameOrShowName(saveTargetRequestDTO.getShowName(), null)>0){

            throw exceptionUtil.throwCustomException("TARGET_SAVE_TARGET_005");
        }

        targetMapper.saveTarget(
                MapperFactoryUtil.mapperObject(saveTargetRequestDTO, Target.class)
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.TARGET+UuidUtil.randomUUID())
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午2:43
     *@Description: 编辑指标
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editTarget(EditTargetRequestDTO editTargetRequestDTO, String loginEmployeeId) {

        if (1 != editTargetRequestDTO.getTargetType()
                &&
                2 != editTargetRequestDTO.getTargetType()
                &&
                3 != editTargetRequestDTO.getTargetType()){

            throw exceptionUtil.throwCustomException("TARGET_EDIT_TARGET_004");
        }

        if (targetMapper.countTargetByNameOrShowName(editTargetRequestDTO.getName(), editTargetRequestDTO.getId())>0
                ||
                targetMapper.countTargetByNameOrShowName(editTargetRequestDTO.getShowName(), editTargetRequestDTO.getId())>0){

            throw exceptionUtil.throwCustomException("TARGET_EDIT_TARGET_007");
        }

        Target target = targetMapper.findTargetById(editTargetRequestDTO.getId());

        if (Objects.isNull(target)){

            throw exceptionUtil.throwCustomException("TARGET_EDIT_TARGET_008");
        }

        targetMapper.editTarget(
                target
                        .setName(editTargetRequestDTO.getName())
                        .setShowName(editTargetRequestDTO.getShowName())
                        .setState(editTargetRequestDTO.isState())
                        .setTargetType(editTargetRequestDTO.getTargetType())
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午2:44
     *@Description: 删除指标
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeTarget(String id) {

        targetMapper.removeTarget(id);
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午2:44
     *@Description: 禁用/启用
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void isAbleTarget(IsAbleTargetRequestDTO isAbleTargetRequestDTO, String loginEmployeeId) {

        Target target = targetMapper.findTargetById(isAbleTargetRequestDTO.getId());

        if (Objects.isNull(target)){

            throw exceptionUtil.throwCustomException("TARGET_ISABLE_TARGET_003");
        }

        targetMapper.editTarget(
                target.setState(isAbleTargetRequestDTO.isState())
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午2:44
     *@Description: 分页查询指标
     */
    @Override
    public ResultPageList<FindTargetAllListResponseDTO> findTargetList(FindTargetAllListRequestDTO findTargetAllListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindTargetAllListResponseDTO> result =
                MapperFactoryUtil.mapperList(
                        targetMapper.findTargetList(
                                MapperFactoryUtil.mapperObject(findTargetAllListRequestDTO,
                                        Target.class)),
                        FindTargetAllListResponseDTO.class);

        return new ResultPageList<FindTargetAllListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
