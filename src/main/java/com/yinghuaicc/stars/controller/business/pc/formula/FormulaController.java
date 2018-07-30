package com.yinghuaicc.stars.controller.business.pc.formula;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.cqrs.formula.FormulaCQRSService;
import com.yinghuaicc.stars.service.cqrs.formula.dto.request.FindFormulaCQRSListRequestDTO;
import com.yinghuaicc.stars.service.formula.FormulaService;
import com.yinghuaicc.stars.service.formula.dto.request.EditFormulaRequestDTO;
import com.yinghuaicc.stars.service.formula.dto.request.SaveFormulaRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午3:35
 * @Description: 公式Controller
 * @Modified:
 */
@RestController
@RequestMapping(value = "/formula")
public class FormulaController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private FormulaCQRSService formulaCQRSService;

    /**
     *@Author:Fly Created in 2018/7/13 下午3:36
     *@Description: 添加公式
     */
    @PostMapping(value = "/save/formula")
    public JsonResult saveFormula(@Validated @RequestBody SaveFormulaRequestDTO saveFormulaRequestDTO){

        formulaService.saveFormula(
                saveFormulaRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午3:38
     *@Description: 编辑公式
     */
    @PostMapping(value = "/edit/formula")
    public JsonResult editFormula(@Validated @RequestBody EditFormulaRequestDTO editFormulaRequestDTO){

        formulaService.editFormula(
                editFormulaRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午4:14
     *@Description: 删除公式
     */
    @GetMapping(value = "/remove/formula/{id}")
    public JsonResult removeFormula(@PathVariable String id){

        formulaService.removeFormula(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午4:16
     *@Description: 公式详情
     */
    @GetMapping(value = "/find/formula/by/{id}")
    public JsonResult findFormulaById(@PathVariable String id){

        return JsonResult.success(formulaService.findFormulaById(id));
    }

    /**
     *@Author:Fly Created in 2018/7/13 下午4:17
     *@Description: 公式列表
     */
    @PostMapping(value = "/find/formula/list")
    public JsonResult findFormulaList(@RequestBody FindFormulaCQRSListRequestDTO findFormulaCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                formulaCQRSService.formulaList(findFormulaCQRSListRequestDTO, pageParam));
    }
}
