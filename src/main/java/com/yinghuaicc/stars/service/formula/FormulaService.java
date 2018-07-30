package com.yinghuaicc.stars.service.formula;

import com.yinghuaicc.stars.service.formula.dto.request.EditFormulaRequestDTO;
import com.yinghuaicc.stars.service.formula.dto.request.SaveFormulaRequestDTO;
import com.yinghuaicc.stars.service.formula.dto.response.FindFormulaByIdResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:48
 * @Description: 公式
 * @Modified:
 */
public interface FormulaService {

    /**
     *@Author:Fly Created in 2018/7/13 下午2:54
     *@Description: 添加公式
     */
    void saveFormula(SaveFormulaRequestDTO saveFormulaRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/13 下午2:54
     *@Description: 编辑公式
     */
    void editFormula(EditFormulaRequestDTO editFormulaRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/13 下午2:54
     *@Description: 删除公式
     */
    void removeFormula(String id);

    /**
     *@Author:Fly Created in 2018/7/13 下午3:19
     *@Description: 公式详情
     */
    FindFormulaByIdResponseDTO findFormulaById(String id);
}
