package com.yinghuaicc.stars.service.cqrs.formula;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.formula.dto.request.FindFormulaCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.formula.dto.response.FindFormulaListCQRSListResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:34
 * @Description: 公式
 * @Modified:
 */
public interface FormulaCQRSService {

    /**
     *@Author:Fly Created in 2018/7/13 下午3:31
     *@Description: 公式列表
     */
    ResultPageList<FindFormulaListCQRSListResponseDTO> formulaList(FindFormulaCQRSListRequestDTO findFormulaCQRSListRequestDTO, PageParam pageParam);

}
