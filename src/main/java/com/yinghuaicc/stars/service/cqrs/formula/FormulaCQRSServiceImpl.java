package com.yinghuaicc.stars.service.cqrs.formula;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.formula.FormulaCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.formula.dto.request.FindFormulaCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.formula.dto.response.FindFormulaListCQRSListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:34
 * @Description:公式
 * @Modified:
 */
@Service
public class FormulaCQRSServiceImpl implements FormulaCQRSService{

    @Autowired
    private FormulaCQRSMapper formulaCQRSMapper;


    /**
     *@Author:Fly Created in 2018/7/13 下午3:32
     *@Description: 公式列表
     */
    @Override
    public ResultPageList<FindFormulaListCQRSListResponseDTO> formulaList(FindFormulaCQRSListRequestDTO findFormulaCQRSListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<FindFormulaListCQRSListResponseDTO> result =
                formulaCQRSMapper.formulaListCQRS(findFormulaCQRSListRequestDTO);

        return new ResultPageList<FindFormulaListCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }
}
