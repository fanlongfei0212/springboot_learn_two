package com.yinghuaicc.stars.service.help;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.help.HelpMapper;
import com.yinghuaicc.stars.repository.model.help.HelpContext;
import com.yinghuaicc.stars.repository.model.help.HelpPlanBusinessSpecies;
import com.yinghuaicc.stars.repository.model.help.HelpPlanFloor;
import com.yinghuaicc.stars.repository.model.help.HelpPlanProject;
import com.yinghuaicc.stars.service.help.HelpService;
import com.yinghuaicc.stars.service.help.dto.request.*;
import com.yinghuaicc.stars.service.help.dto.response.FindHelpContextListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午4:19
 * @Description: 帮扶计划
 * @Modified:
 */
@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private HelpMapper helpMapper;


    /**
     *@Author:Fly Created in 2018/7/19 下午4:25
     *@Description: 添加帮扶内容
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveHelpContext(SaveHelpContextRequestDTO saveHelpContextRequestDTO, String loginEmployeeId) {

        helpMapper.saveHelpContext(
                Stream.of(
                        MapperFactoryUtil.mapperObject(saveHelpContextRequestDTO, HelpContext.class)
                                .setId(UuidUtil.randomUUID())
                                .setCreateUser(loginEmployeeId)
                                .setModifyUser(loginEmployeeId)
                                .setModifyTime(LocalDateTime.now())
                                .setCreateTime(LocalDateTime.now()))
                        .collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午4:25
     *@Description: 编辑帮扶内容
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editHelpContext(EditHelpContextRequestDTO editHelpContextRequestDTO, String loginEmployeeId) {

        HelpContext helpContext = helpMapper.findHelpContextById(editHelpContextRequestDTO.getId());

        if (Objects.isNull(helpContext)){

            throw exceptionUtil.throwCustomException("EDIT_HELP_CONTEXT_004");
        }

        helpMapper.editHelpContext(
                helpContext
                        .setType(editHelpContextRequestDTO.getType())
                        .setContext(editHelpContextRequestDTO.getContext())
                        .setModifyTime(LocalDateTime.now())
                        .setModifyUser(loginEmployeeId));
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午4:26
     *@Description: 删除帮扶内容
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeHelpContext(String id) {

        helpMapper.removeHelpContext(id);
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午4:26
     *@Description: 帮扶内容列表
     */
    @Override
    public ResultPageList<FindHelpContextListResponseDTO> findHelpContextList(PageParam pageParam, Integer type) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<HelpContext> result = helpMapper.findHelpContextList(type);

        return new ResultPageList<FindHelpContextListResponseDTO>()
                .setResultList(MapperFactoryUtil.mapperList(result, FindHelpContextListResponseDTO.class))
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午5:11
     *@Description: 全部帮扶内容
     */
    @Override
    public List<FindHelpContextListResponseDTO> findHelpContextAll(Integer type) {

        return MapperFactoryUtil.mapperList(helpMapper.findHelpContextList(type),
                FindHelpContextListResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午3:24
     *@Description: 添加项目帮扶计划
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveHelpPlanProject(SaveHelpPlanProjectRequestDTO saveHelpPlanProjectRequestDTO, String loginEmployeeId) {

        HelpPlanProject helpPlanProject = helpMapper.findHelpPlanProjectByProjectId(saveHelpPlanProjectRequestDTO.getProjectId());

        if (Objects.isNull(helpPlanProject)){

            helpPlanProject = new HelpPlanProject()
                    .setId(UuidUtil.randomUUID())
                    .setProjectId(saveHelpPlanProjectRequestDTO.getProjectId())
                    .setCreateUser(loginEmployeeId)
                    .setModifyUser(loginEmployeeId)
                    .setModifyTime(LocalDateTime.now())
                    .setCreateTime(LocalDateTime.now());
        }

        if (saveHelpPlanProjectRequestDTO.getType().equals("yx")){

            helpPlanProject.setYxHelpContext(
                    saveHelpPlanProjectRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanProjectRequestDTO.getType().equals("lh")){

            helpPlanProject.setLhHelpContext(
                    saveHelpPlanProjectRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanProjectRequestDTO.getType().equals("ts")){

            helpPlanProject.setTsHelpContext(
                    saveHelpPlanProjectRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanProjectRequestDTO.getType().equals("hl")){

            helpPlanProject.setHlHelpContext(
                    saveHelpPlanProjectRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanProjectRequestDTO.getType().equals("ks")){

            helpPlanProject.setKsHelpContext(
                    saveHelpPlanProjectRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }

        if (helpMapper.countHelpPlanProjectByProjectId(saveHelpPlanProjectRequestDTO.getProjectId())==0){

            helpMapper.saveHelpPlanProject(Stream.of(helpPlanProject).collect(Collectors.toList()));
        }else {

            helpMapper.updateHelpPlanProject(helpPlanProject.setModifyUser(loginEmployeeId).setModifyTime(LocalDateTime.now()));
        }
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午8:21
     *@Description: 添加层帮扶计划
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveHelpPlanFloor(SaveHelpPlanFloorRequestDTO saveHelpPlanFloorRequestDTO, String loginEmployeeId) {

        HelpPlanFloor helpPlanFloor =
                helpMapper.findHelpPlanFloorByProjectIdAndFloorId(
                        saveHelpPlanFloorRequestDTO.getProjectId(), saveHelpPlanFloorRequestDTO.getFloorId());

        if (Objects.isNull(helpPlanFloor)){

            helpPlanFloor = new HelpPlanFloor()
                    .setId(UuidUtil.randomUUID())
                    .setProjectId(saveHelpPlanFloorRequestDTO.getProjectId())
                    .setFloorId(saveHelpPlanFloorRequestDTO.getFloorId())
                    .setCreateUser(loginEmployeeId)
                    .setModifyUser(loginEmployeeId)
                    .setModifyTime(LocalDateTime.now())
                    .setCreateTime(LocalDateTime.now());
        }

        if (saveHelpPlanFloorRequestDTO.getType().equals("yx")){

            helpPlanFloor.setYxHelpContext(
                    saveHelpPlanFloorRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanFloorRequestDTO.getType().equals("lh")){

            helpPlanFloor.setLhHelpContext(
                    saveHelpPlanFloorRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanFloorRequestDTO.getType().equals("ts")){

            helpPlanFloor.setTsHelpContext(
                    saveHelpPlanFloorRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanFloorRequestDTO.getType().equals("hl")){

            helpPlanFloor.setHlHelpContext(
                    saveHelpPlanFloorRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanFloorRequestDTO.getType().equals("ks")){

            helpPlanFloor.setKsHelpContext(
                    saveHelpPlanFloorRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }

        if (helpMapper.countHelpPlanFloorByProjectIdAndFloorId(saveHelpPlanFloorRequestDTO.getProjectId(), saveHelpPlanFloorRequestDTO.getFloorId())==0){

            helpMapper.saveHelpPlanFloor(Stream.of(helpPlanFloor).collect(Collectors.toList()));
        }else {

            helpMapper.editHelpPlanFloor(helpPlanFloor.setModifyUser(loginEmployeeId).setModifyTime(LocalDateTime.now()));
        }
    }

    /**
     *@Author:Fly Created in 2018/7/21 下午1:36
     *@Description: 添加业种帮扶计划
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveHelpPlanHelpPlanBusinessSpecies(SaveHelpPlanBusinessSpeciesRequestDTO saveHelpPlanBusinessSpeciesRequestDTO, String loginEmployeeId) {

        HelpPlanBusinessSpecies helpPlanBusinessSpecies =
                helpMapper.findHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(
                        saveHelpPlanBusinessSpeciesRequestDTO.getProjectId(),
                        saveHelpPlanBusinessSpeciesRequestDTO.getBusinessFormId(),
                        saveHelpPlanBusinessSpeciesRequestDTO.getBusinessSpeciesId());

        if (Objects.isNull(helpPlanBusinessSpecies)){

            helpPlanBusinessSpecies =
                    new HelpPlanBusinessSpecies()
                            .setId(UuidUtil.randomUUID())
                            .setProjectId(saveHelpPlanBusinessSpeciesRequestDTO.getProjectId())
                            .setBusinessFormId(saveHelpPlanBusinessSpeciesRequestDTO.getBusinessFormId())
                            .setBusinessSpeciesId(saveHelpPlanBusinessSpeciesRequestDTO.getBusinessSpeciesId())
                            .setCreateUser(loginEmployeeId)
                            .setModifyUser(loginEmployeeId)
                            .setModifyTime(LocalDateTime.now())
                            .setCreateTime(LocalDateTime.now());
        }

        if (saveHelpPlanBusinessSpeciesRequestDTO.getType().equals("yx")){

            helpPlanBusinessSpecies.setYxHelpContext(
                    saveHelpPlanBusinessSpeciesRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanBusinessSpeciesRequestDTO.getType().equals("lh")){

            helpPlanBusinessSpecies.setLhHelpContext(
                    saveHelpPlanBusinessSpeciesRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanBusinessSpeciesRequestDTO.getType().equals("ts")){

            helpPlanBusinessSpecies.setTsHelpContext(
                    saveHelpPlanBusinessSpeciesRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanBusinessSpeciesRequestDTO.getType().equals("hl")){

            helpPlanBusinessSpecies.setHlHelpContext(
                    saveHelpPlanBusinessSpeciesRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }else if (saveHelpPlanBusinessSpeciesRequestDTO.getType().equals("ks")){

            helpPlanBusinessSpecies.setKsHelpContext(
                    saveHelpPlanBusinessSpeciesRequestDTO.getHelpContext().stream().collect(Collectors.joining("</br>")));
        }

        if (helpMapper.countHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(saveHelpPlanBusinessSpeciesRequestDTO.getProjectId(), saveHelpPlanBusinessSpeciesRequestDTO.getBusinessFormId(), saveHelpPlanBusinessSpeciesRequestDTO.getBusinessSpeciesId())==0){

            helpMapper.saveHelpPlanBusinessSpecies(Stream.of(helpPlanBusinessSpecies).collect(Collectors.toList()));
        }else {

            helpMapper.editHelpPlanBusinessSpecies(helpPlanBusinessSpecies.setModifyUser(loginEmployeeId).setModifyTime(LocalDateTime.now()));
        }
    }
}
