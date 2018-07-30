package com.yinghuaicc.stars.task.scheduled;

import com.yinghuaicc.stars.common.utils.json.GsonUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.controller.config.system.SystemResource;
import com.yinghuaicc.stars.repository.mapper.external.ExternalMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.model.external.ExternalEmployee;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.task.dto.EmployeeResponseDTO;
import com.yinghuaicc.stars.task.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 下午5:53
 * @Description: 同步外部系统人员数据
 * @Modified:
 */
@Component
public class ExternalEmployeeSync {

    @Autowired
    private SystemResource systemResource;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GsonUtil gsonUtil;

    @Autowired
    private ExternalMapper externalMapper;

    @Autowired
    private TissueMapper tissueMapper;

    /**
     *@Author:Fly Created in 2018/7/15 下午6:17
     *@Description: 获取外部系统人员数据,每天晚上11点59分执行
     */
//    @Scheduled(fixedRate = 200000)
    @Scheduled(cron = "0 59 23 ? * *")
    @Transactional(rollbackFor = Exception.class)
    public void getOrg(){

        String url = systemResource.getExternalUrl()+"platform-app/sys/org/user/queryUserOrOrgList";

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> parameter = new HashMap<String, String>();

        parameter.put("tendCode", "test_test009");
        parameter.put("dataType", "user");

        ResponseEntity responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<String>(gsonUtil.toJson(parameter), httpHeaders),
                new ParameterizedTypeReference<ResultDTO<EmployeeResponseDTO>>(){});

        List<EmployeeResponseDTO> result = this.checkGetOrgResult(responseEntity);

        if (Objects.nonNull(result) && result.size()>0){

            this.updateEmployeeDataBases(result);

            this.updateMyEmployeeDataBases(result);
        }
    }

    /**
     *@Author:Fly Created in 2018/7/15 下午6:58
     *@Description: 检查并返回结果
     */
    private List<EmployeeResponseDTO> checkGetOrgResult(ResponseEntity responseEntity){

        if (responseEntity.getStatusCodeValue() == 200){

            if (responseEntity.getBody() instanceof ResultDTO){

                ResultDTO resultDTO = (ResultDTO)responseEntity.getBody();

                if (resultDTO.isSuccess()){

                    return resultDTO.getResult();
                }
            }
        }

        return null;
    }

    /**
     *@Author:Fly Created in 2018/7/15 下午7:19
     *@Description: 更新外部员工数据信息
     */
    private void updateEmployeeDataBases(List<EmployeeResponseDTO> result){

        externalMapper.removeEmployeeByIds(result.stream().map(EmployeeResponseDTO::getId).collect(Collectors.toList()));

        externalMapper.saveEmployee(MapperFactoryUtil.mapperList(result, ExternalEmployee.class).stream().map(externalEmployee -> {

            externalEmployee.setModifyTime(LocalDateTime.now());
            externalEmployee.setCreateTime(LocalDateTime.now());
            externalEmployee.setCreateUser("system");
            externalEmployee.setModifyUser("system");

            return externalEmployee;

        }).collect(Collectors.toList()));

    }

    /**
     *@Author:Fly Created in 2018/7/17 下午4:12
     *@Description: 更新内部员工数据
     */
    private void updateMyEmployeeDataBases(List<EmployeeResponseDTO> result){

        tissueMapper.removeEmployeeByExternal(result.stream().map(EmployeeResponseDTO::getId).collect(Collectors.toList()));

        tissueMapper.saveEmployeeByExternal(result.stream().map(employeeResponseDTO -> {

            return new Employee()
                    .setId(employeeResponseDTO.getId())
                    .setNum(BusinessNum.EMPLOYEE+ UuidUtil.randomUUID())
                    .setName(employeeResponseDTO.getRealName())
                    .setUserName(employeeResponseDTO.getLoginName())
                    .setEmail(employeeResponseDTO.getEmail())
                    .setPhone(employeeResponseDTO.getMobile())
                    .setPassword("123456")
                    .setState("0".equals(employeeResponseDTO.getStatus())?true:false)
                    .setType(2)
                    .setOrgId(employeeResponseDTO.getBelongOrgId())
                    .setCreateUser("system")
                    .setModifyUser("system")
                    .setModifyTime(LocalDateTime.now())
                    .setCreateTime(LocalDateTime.now());


        }).collect(Collectors.toList()));
    }
}
