package com.yinghuaicc.stars.task.scheduled;

import com.yinghuaicc.stars.common.utils.json.GsonUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.controller.config.system.SystemResource;
import com.yinghuaicc.stars.repository.mapper.external.ExternalMapper;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.model.contract.Contract;
import com.yinghuaicc.stars.repository.model.external.ExternalOrg;
import com.yinghuaicc.stars.repository.model.region.Company;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.task.dto.OrgResponseDTO;
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
 * @Description: 同步外部系统组织架构数据
 * @Modified:
 */
@Component
public class ExternalOrgSync {

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

    @Autowired
    private RegionMapper regionMapper;

    /**
     *@Author:Fly Created in 2018/7/15 下午6:17
     *@Description: 获取外部系统组织机构数据,每天晚上11点59分执行
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
        parameter.put("dataType", "org");

        ResponseEntity responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<String>(gsonUtil.toJson(parameter), httpHeaders),
                new ParameterizedTypeReference<ResultDTO<OrgResponseDTO>>(){});

        List<OrgResponseDTO> result = this.checkGetOrgResult(responseEntity);

        if (Objects.nonNull(result) && result.size()>0){

            this.updateOrgDataBases(result);

            this.updateDepartment(result);

            this.updateCompany(result);
        }
    }

    /**
     *@Author:Fly Created in 2018/7/15 下午6:58
     *@Description: 检查并返回结果
     */
    private List<OrgResponseDTO> checkGetOrgResult(ResponseEntity responseEntity){

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
     *@Description: 更新外部组织架构数据信息
     */
    private void updateOrgDataBases(List<OrgResponseDTO> result){

        externalMapper.removeOrgByIds(result.stream().map(OrgResponseDTO::getId).collect(Collectors.toList()));

        externalMapper.saveOrg(MapperFactoryUtil.mapperList(result, ExternalOrg.class).stream().map(externalOrg -> {

            externalOrg.setCreateTime(LocalDateTime.now());
            externalOrg.setModifyTime(LocalDateTime.now());
            externalOrg.setCreateUser("system");
            externalOrg.setModifyUser("system");

            return externalOrg;
        }).collect(Collectors.toList()));

    }

    /**
     *@Author:Fly Created in 2018/7/17 下午6:40
     *@Description: 更新内部部门信息
     */
    private void updateDepartment(List<OrgResponseDTO> result){

        List<Department> departments = result.stream()
                .filter(orgResponseDTO -> "dept".equals(orgResponseDTO.getType()))
                .map(orgResponseDTO -> {

                    return new Department()
                            .setId(orgResponseDTO.getId())
                            .setNum(BusinessNum.DEPARTMENT+ UuidUtil.randomUUID())
                            .setName(orgResponseDTO.getName())
                            .setParentId(orgResponseDTO.getParentId())
                            .setType(2)
                            .setCreateTime(LocalDateTime.now())
                            .setModifyTime(LocalDateTime.now())
                            .setCreateUser("system")
                            .setModifyUser("system");
                }).collect(Collectors.toList());

        if (Objects.nonNull(departments) && departments.size() > 0){

            tissueMapper.removeDepartmentByIds(departments.stream().map(Department::getId).collect(Collectors.toList()));

            tissueMapper.saveDepartment(departments);
        }
    }

    /**
     *@Author:Fly Created in 2018/7/17 下午6:41
     *@Description: 更新内部公司信息
     */
    private void updateCompany(List<OrgResponseDTO> result){

        List<Company> companies = result.stream()
                .filter(orgResponseDTO -> "company".equals(orgResponseDTO.getType()))
                .map(orgResponseDTO -> {

                    return new Company()
                            .setId(orgResponseDTO.getId())
                            .setNum(BusinessNum.COMPANY+UuidUtil.randomUUID())
                            .setName(orgResponseDTO.getName())
                            .setParentId(orgResponseDTO.getParentId())
                            .setType(2)
                            .setCreateTime(LocalDateTime.now())
                            .setModifyTime(LocalDateTime.now())
                            .setCreateUser("system")
                            .setModifyUser("system");
                }).collect(Collectors.toList());

        if (Objects.nonNull(companies) && companies.size() > 0){

            regionMapper.removeCompanyByIds(companies.stream().map(Company::getId).collect(Collectors.toList()));

            regionMapper.saveCompany(companies);
        }
    }
}
