package com.yinghuaicc.stars.service.formula;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.repository.mapper.formula.FormulaMapper;
import com.yinghuaicc.stars.repository.mapper.target.TargetMapper;
import com.yinghuaicc.stars.repository.model.formula.Formula;
import com.yinghuaicc.stars.service.formula.dto.request.EditFormulaRequestDTO;
import com.yinghuaicc.stars.service.formula.dto.request.SaveFormulaRequestDTO;
import com.yinghuaicc.stars.service.formula.dto.response.FindFormulaByIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:49
 * @Description: 公式
 * @Modified:
 */
@Service
public class FormulaServiceImpl implements FormulaService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private FormulaMapper formulaMapper;

    @Autowired
    private TargetMapper targetMapper;


    /**
     *@Author:Fly Created in 2018/7/13 下午2:54
     *@Description: 添加公式
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveFormula(SaveFormulaRequestDTO saveFormulaRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(targetMapper.findTargetById(saveFormulaRequestDTO.getTargetId()))){

            throw exceptionUtil.throwCustomException("FORMULA_SAVE_FORMULA_006");
        }

        formulaMapper.saveFormula(
                Stream.of(MapperFactoryUtil.mapperObject(
                        saveFormulaRequestDTO, Formula.class)
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.FORMULA+UuidUtil.randomUUID())
                        .setModifyUser(loginEmployeeId)
                        .setCreateUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now()))
                        .collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午2:55
     *@Description: 编辑公式
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editFormula(EditFormulaRequestDTO editFormulaRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(targetMapper.findTargetById(editFormulaRequestDTO.getTargetId()))){

            throw exceptionUtil.throwCustomException("FORMULA_EDIT_FORMULA_007");
        }

        Formula formula = formulaMapper.findFormulaById(editFormulaRequestDTO.getId());

        if (Objects.isNull(formula)){

            throw exceptionUtil.throwCustomException("FORMULA_EDIT_FORMULA_008");
        }

        formulaMapper.editFormula(
                formula
                        .setTargetId(editFormulaRequestDTO.getTargetId())
                        .setTargetName(editFormulaRequestDTO.getTargetName())
                        .setOperationFormula(editFormulaRequestDTO.getOperationFormula())
                        .setResultFormula(editFormulaRequestDTO.getResultFormula())
                        .setState(editFormulaRequestDTO.isState())
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午2:55
     *@Description: 删除公式
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeFormula(String id) {

        formulaMapper.removeFormula(id);
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午3:19
     *@Description: 公式详情
     */
    @Override
    public FindFormulaByIdResponseDTO findFormulaById(String id) {

        return MapperFactoryUtil.mapperObject(
                formulaMapper.findFormulaById(id), FindFormulaByIdResponseDTO.class);
    }
}
