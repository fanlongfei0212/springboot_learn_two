package com.yinghuaicc.stars.service.cqrs.triangle;


import com.yinghuaicc.stars.repository.mapper.Intervalset.ConditionGuestIntervalMapper;
import com.yinghuaicc.stars.repository.mapper.Intervalset.FloorGuestIntervalMapper;
import com.yinghuaicc.stars.repository.mapper.Intervalset.ProjectGuestIntervalMapper;
import com.yinghuaicc.stars.repository.mapper.cqrs.brand.BrandCQRSMapper;
import com.yinghuaicc.stars.repository.mapper.cqrs.contract.ContractCQRSMapper;
import com.yinghuaicc.stars.repository.mapper.help.HelpMapper;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.standard.*;
import com.yinghuaicc.stars.repository.mapper.triangle.*;
import com.yinghuaicc.stars.repository.model.help.HelpPlanBusinessSpecies;
import com.yinghuaicc.stars.repository.model.help.HelpPlanFloor;
import com.yinghuaicc.stars.repository.model.help.HelpPlanProject;
import com.yinghuaicc.stars.repository.model.region.Floor;
import com.yinghuaicc.stars.repository.model.region.Project;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ConditionGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ConditionGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.FloorGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ProjectGuestIntervalResponseDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.response.BrandCQRSInfoResponseDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractTriangleCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractTriangleCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardBrandSaleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.*;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TriangleCQRSServiceImpl implements TriangleCQRSService{

    @Autowired
    private TriangleMapper triangleMapper;
    //品牌服务
    @Autowired
    private BrandCQRSMapper brandCQRSMapper;
    //签约服务
    @Autowired
    private ContractCQRSMapper contractCQRSMapper;
    //溢租率
    @Autowired
    private DayRentMapper dayRentMapper;
    //季度适配值
    @Autowired
    private QuarterFittedMapper quarterFittedMapper;
    //每日客销度
    @Autowired
    private DayGuestMapper dayGuestMapper;

    //标准三角形品牌溢租率
    @Autowired
    private StandardConditionRentMapper standardConditionRentMapper;
    //标准三角形品牌溢租率
    @Autowired
    private StandardConditionFittedMapper standardConditionFittedMapper;
    //标准三角形客销度
    @Autowired
    private StandardBrandSaleMapper standardBrandSaleMapper;

    //区间设置品牌客销度
    @Autowired
    private ConditionGuestIntervalMapper conditionGuestIntervalMapper;
    //帮扶计划
    @Autowired
    private HelpMapper helpMapper;

    //标准三角形项目溢租率
    @Autowired
    private StandardProjectRentMapper standardProjectRentMapper;
    //标准三角形项目适配值
    @Autowired
    private StandardProjectFittedMapper standardProjectFittedMapper;

    //项目帮扶计划
    @Autowired
    private ProjectGuestIntervalMapper projectGuestIntervalMapper;
    //项目mapper
    @Autowired
    private RegionMapper regionMapper;
    //项目客销度
    @Autowired
    private ProjectGuestMapper projectGuestMapper;

    //楼层客销度
    @Autowired
    private FloorGuestMapper floorGuestMapper;

    //标准是三角形楼层级溢租率
    @Autowired
    private StandardFloorRentMapper standardFloorRentMapper;

    //标准三角形楼层级适配值
    @Autowired
    private StandardFloorFittedMapper standardFloorFittedMapper;

    //楼层客销度区间设置
    @Autowired
    private FloorGuestIntervalMapper floorGuestIntervalMapper;



    /**
     * 通过品牌id 查询品牌三角形
     * @param brandTriangleRequestDTO
     * @return
     */
    @Override
    public BrandTriangleResponseDTO findBrandTriangleByBrandId(BrandTriangleRequestDTO brandTriangleRequestDTO) {
        BrandTriangleResponseDTO brandTriangleResponseDTO = getBrandTriangleResponseDTO(brandTriangleRequestDTO);
        return brandTriangleResponseDTO;
    }

    /**
     * 获取品牌三角形
     * @param brandTriangleRequestDTO
     * @return
     */
    private BrandTriangleResponseDTO getBrandTriangleResponseDTO(BrandTriangleRequestDTO brandTriangleRequestDTO) {
        //品牌三角理论展示数据
        BrandTriangleResponseDTO brandTriangleResponseDTO = new BrandTriangleResponseDTO();

        //品牌id
        String brandId = brandTriangleRequestDTO.getBrandId();
        //通过品牌id查询品牌信息（品牌id、业态id、业种id）
        BrandCQRSInfoResponseDTO brandCQRSInfoResponseDTO = brandCQRSMapper.brandInfoCQRS(brandId);
        //业态id
        String conditionId = brandCQRSInfoResponseDTO.getBusinessFormId();
        String conditionName = brandCQRSInfoResponseDTO.getBusinessFormName();
        //业种id
        String majoId = brandCQRSInfoResponseDTO.getBusinessSpeciesId();
        String majoName = brandCQRSInfoResponseDTO.getBusinessSpeciesId();

        ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO= new ContractTriangleCQRSListRequestDTO();
        contractTriangleCQRSListRequestDTO.setProjectId(brandTriangleRequestDTO.getProjectId());
        contractTriangleCQRSListRequestDTO.setFloorId(brandTriangleRequestDTO.getFloorId());
        contractTriangleCQRSListRequestDTO.setBrandId(brandTriangleRequestDTO.getBrandId());
        contractTriangleCQRSListRequestDTO.setBusinessFormId(brandTriangleRequestDTO.getConditionId());
        //通过品牌id查询签约表（签约id、项目id、楼层id、铺位id）
        List<ContractTriangleCQRSListResponseDTO> contractCQRSList =  contractCQRSMapper.findContractTriangleCQRSListResponseDTO(contractTriangleCQRSListRequestDTO);
        ContractTriangleCQRSListResponseDTO  contractTriangleCQRSListResponseDTO = contractCQRSList.get(0);

        //项目id
        String projectId = brandTriangleRequestDTO.getProjectId();
        //签约id
        String contractId = contractTriangleCQRSListResponseDTO.getId();
        //查询面积
        BigDecimal area = contractTriangleCQRSListResponseDTO.getAcreage();

        //通过签约id+当天时间查询溢租率租费信息
        DayRentResponseDTO dayRentResponseDTO = dayRentMapper.findDayRentResponseDTOByContractId(contractId,LocalDateTime.now());
        //租金
        BigDecimal rent = dayRentResponseDTO.getRent();
        //物业费
        BigDecimal propertyFee = dayRentResponseDTO.getPropertyFee();
        //员工成本
        BigDecimal  staffEmp = dayRentResponseDTO.getStaffEmp();
        //装修折旧
        BigDecimal fitment = dayRentResponseDTO.getFitment();
        //代理费
        BigDecimal  agencyFee = dayRentResponseDTO.getAgencyFee();

        //通过签约id+当天时间查询适配值信息，然后计算出品牌适配值
        QuarterFittedResponseDTO quarterFittedResponseDTO = quarterFittedMapper.findQuarterFittedResponseDTOByContractId(contractId,LocalDateTime.now());
        //市场定位
        Integer marketPosition = quarterFittedResponseDTO.getMarketPosition();
        //品牌定位
        Integer brandPosition = quarterFittedResponseDTO.getBrandPosition();
        //品牌形象
        Integer brandImage = quarterFittedResponseDTO.getBrandImage();
        //租费收缴率
        BigDecimal rentalRate = quarterFittedResponseDTO.getRentalRate();
        //连锁跟进度
        BigDecimal chainDegree = quarterFittedResponseDTO.getChainDegree();
        //客服投诉率
        BigDecimal complaintDegree = quarterFittedResponseDTO.getComplaintDegree();
        //企划配合度
        BigDecimal layoutDegree = quarterFittedResponseDTO.getLayoutDegree();
        //配合度
        BigDecimal phd = rentalRate.add(chainDegree).add(complaintDegree).add(layoutDegree);
        brandTriangleResponseDTO.setTriangleFitted(new BigDecimal(marketPosition+brandPosition+brandImage).multiply(phd));

        //通过签约id+当天时间查询客销度（客流量、销售额）计算客销度
        DayGuestResponseDTO dayGuestResponseDTO = dayGuestMapper.findDayGuestByDayGuestByContractId(contractId,LocalDateTime.now());

        //客流量
        BigDecimal passengerFlow = dayGuestResponseDTO.getPassengerFlow();
        //销售额
        BigDecimal saleroom = dayGuestResponseDTO.getSaleroom();
        BigDecimal triangleguest= passengerFlow.divide(area).multiply(saleroom.divide(area));
        //动态三角形客销度
        brandTriangleResponseDTO.setTriangleGuest(triangleguest);

        //通过项目id、业态id、业种id查询标准三角形溢租率
        StandardConditionRentRequestDTO standardConditionRentRequestDTO = new StandardConditionRentRequestDTO();
        standardConditionRentRequestDTO.setProjectId(projectId);
        standardConditionRentRequestDTO.setConditionId(conditionId);
        standardConditionRentRequestDTO.setMajoId(majoId);
        standardConditionRentRequestDTO.setConditionName(conditionName);
        standardConditionRentRequestDTO.setMajoName(majoName);
        List<StandardConditionRentResponseDTO> standardConditionRentResponseDTOS = standardConditionRentMapper.findStandardConditionRentByStandardConditionRentCQRS(standardConditionRentRequestDTO);

        //设置标准三角形溢租率
        brandTriangleResponseDTO.setStandardRent(standardConditionRentResponseDTOS.get(0).getRent());

        //通过项目id、业态id、业种id查询标准三角形适配值
        StandardConditionFittedRequestDTO standardConditionFittedRequestDTO = new  StandardConditionFittedRequestDTO();
        standardConditionFittedRequestDTO.setProjectId(projectId);
        standardConditionFittedRequestDTO.setConditionId(conditionId);
        standardConditionFittedRequestDTO.setConditionName(conditionName);
        standardConditionFittedRequestDTO.setMajoId(majoId);
        standardConditionFittedRequestDTO.setMajoName(majoName);
        List<StandardConditionFittedResponseDTO> standardConditionFittedResponseDTOS = standardConditionFittedMapper.findStandardConditionFittedByStandardConditionFittedCQRS(standardConditionFittedRequestDTO);
        //设置品牌适配值
        brandTriangleResponseDTO.setStandardFitted(standardConditionFittedResponseDTOS.get(0).getFitted());

        //通过签约id查询标准三角形客销度
        StandardBrandSaleRequestDTO standardBrandSaleRequestDTO  = new StandardBrandSaleRequestDTO();
        standardBrandSaleRequestDTO.setContractId(contractId);
        standardBrandSaleRequestDTO.setProjectId(projectId);
        List<StandardBrandSaleResponseDTO> standardBrandSaleResponseDTOs =  standardBrandSaleMapper.findStandardBrandSaleByStandardBrandSaleCQRS(standardBrandSaleRequestDTO);
        //毛利率
        BigDecimal grossRate =  standardBrandSaleResponseDTOs.get(0).getGrossRate();
        //客单价
        BigDecimal perSale =  standardBrandSaleResponseDTOs.get(0).getPerSale();

        //BigDecimal jlr =净利润=销售收入*毛利率-rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);
        BigDecimal jlr =saleroom.multiply(grossRate).subtract(rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee));

        //动态三角形溢租率=净利润/租费
        brandTriangleResponseDTO.setTriangleRent(jlr.divide(rent.add(propertyFee).add(fitment)));

        //销售收入
        BigDecimal saleIn = rent.add(propertyFee).add(fitment).add(staffEmp).add(agencyFee).divide(grossRate);
        //标准三角形客流量
        BigDecimal standardPassengerFlow = saleIn.divide(perSale);
        //标准三角形客销度
        brandTriangleResponseDTO.setStandardGuest(standardPassengerFlow.divide(area).multiply(saleIn.divide(area)));

        //通过项目id、品牌id、业态id、业种id 查询 客销度区间
        ConditionGuestIntervalRequestDTO conditionGuestIntervalRequestDTO = new ConditionGuestIntervalRequestDTO();
        conditionGuestIntervalRequestDTO.setProjectId(projectId);
        conditionGuestIntervalRequestDTO.setConditionId(conditionId);
        conditionGuestIntervalRequestDTO.setMajoId(majoId);
        List<ConditionGuestIntervalResponseDTO> conditionGuestIntervalResponseDTOs = conditionGuestIntervalMapper.findConditionGuestIntervalByConditionGuestIntervalCQRS(conditionGuestIntervalRequestDTO);
        //优秀
        Integer yx = conditionGuestIntervalResponseDTOs.get(0).getYx();
        //良好
        Integer lh = conditionGuestIntervalResponseDTOs.get(0).getLh();
        //提升
        Integer ts = conditionGuestIntervalResponseDTOs.get(0).getTs();
        //合格
        Integer hl = conditionGuestIntervalResponseDTOs.get(0).getHl();
        //亏损
        Integer ks = conditionGuestIntervalResponseDTOs.get(0).getKs();
        Map<String ,Integer> guestMap = new HashMap<String ,Integer>();
        guestMap.put("yx",yx);
        guestMap.put("lh",lh);
        guestMap.put("ts",ts);
        guestMap.put("hl",hl);
        guestMap.put("ks",ks);
        //品牌客销度区间设置
        brandTriangleResponseDTO.setIntervalGuest(guestMap);

        //设置溢租率区间
        Map<String ,Integer>   rentMap = new HashMap<String ,Integer>();
        rentMap.put("yx",350);
        rentMap.put("lh",300);
        rentMap.put("ts",200);
        rentMap.put("hl",100);
        rentMap.put("ks",0);
        brandTriangleResponseDTO.setIntervalGuest(rentMap);
        //设置适配值区间
        Map<String ,Integer>   fittedMap = new HashMap<String ,Integer>();
        fittedMap.put("yx",10000);
        fittedMap.put("lh",9000);
        fittedMap.put("ts",8000);
        fittedMap.put("hl",7000);
        fittedMap.put("ks",6400);
        brandTriangleResponseDTO.setIntervalGuest(fittedMap);

        //查询帮扶计划
        HelpPlanBusinessSpecies helpPlanBusinessSpecies = helpMapper.findHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(projectId,conditionId,majoId);

        if(triangleguest.compareTo(new BigDecimal(yx))==-1 && triangleguest.compareTo(new BigDecimal(lh))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanBusinessSpecies.getYxHelpContext());
        }else if (triangleguest.compareTo(new BigDecimal(lh))==-1 && triangleguest.compareTo(new BigDecimal(ts))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanBusinessSpecies.getLhHelpContext());
        }else if (triangleguest.compareTo(new BigDecimal(ts))==-1 && triangleguest.compareTo(new BigDecimal(hl))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanBusinessSpecies.getTsHelpContext());
        }else if (triangleguest.compareTo(new BigDecimal(hl))==-1 && triangleguest.compareTo(new BigDecimal(ks))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanBusinessSpecies.getLhHelpContext());
        }else{
            brandTriangleResponseDTO.setGuestContent("无");
        }
        return brandTriangleResponseDTO;
    }

    /**
     * 通过项目id 查询项目三角形
     * @param brandTriangleRequestDTO
     * @return
     */
    @Override
    public BrandTriangleResponseDTO findBrandTriangleByProjectId(BrandTriangleRequestDTO brandTriangleRequestDTO) {
        //项目三角形返回值
        BrandTriangleResponseDTO brandTriangleResponseDTO = new BrandTriangleResponseDTO();

        //1、通过项目id 查询所有签约品牌id集合（签约id、项目id、楼层id、铺位id）
        ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO = new ContractTriangleCQRSListRequestDTO();
        contractTriangleCQRSListRequestDTO.setProjectId(brandTriangleRequestDTO.getProjectId());
        List<ContractTriangleCQRSListResponseDTO> contractCQRSList =  contractCQRSMapper.findContractTriangleCQRSListResponseDTO(contractTriangleCQRSListRequestDTO);
        //2.循环获取品牌的三角理论
        //通过项目id查询项目面积
        Project project =  regionMapper.findProjectById(brandTriangleRequestDTO.getProjectId());
        //项目面积
        BigDecimal projectArea =   project.getAcreage();

        //品牌面积累计
        BigDecimal areas = new BigDecimal(0);
        //维度净利润
        BigDecimal projectJlr = new BigDecimal(0);
        //维度溢租率租费
        BigDecimal projectRent = new BigDecimal(0);
        //维度固定成本
        BigDecimal fixedCost = new BigDecimal(0);

        ProjectGuestResponseDTO projectGuestResponseDTO = projectGuestMapper.findProjectGuestByProjectId(brandTriangleRequestDTO.getProjectId());
        //维度客流（去对应维度）
        BigDecimal projectGuest =projectGuestResponseDTO.getPassengerFlow();//获取项目客流

        //维度销售
        BigDecimal projectSale = new BigDecimal(0);
        //适配值权重合计
        BigDecimal projectFitted = new BigDecimal(0);

        //标准三角形客流量累计
        BigDecimal standardPassengerFlows = new BigDecimal(0);

        contractCQRSList.forEach(contractTriangleCQRSListResponseDTO->{
           String contractId = contractTriangleCQRSListResponseDTO.getId();
            //项目id
             String projectId = contractTriangleCQRSListResponseDTO.getProjectId();
            //项目名称
            String projectName = contractTriangleCQRSListResponseDTO.getProjectName();
            //品牌名称
            String brandName = contractTriangleCQRSListResponseDTO.getBrandName();
            //品牌id
            String brandId = contractTriangleCQRSListResponseDTO.getBrandId();
            //楼层id
            String floorId = contractTriangleCQRSListResponseDTO.getFloorId();
            //楼层名称
            String floorName = contractTriangleCQRSListResponseDTO.getFloorName();
            //铺位id
            String roomId = contractTriangleCQRSListResponseDTO.getRoomId();
            //铺位名称
            String roomName = contractTriangleCQRSListResponseDTO.getRoomName();
            //业态id
            String businessFormId = contractTriangleCQRSListResponseDTO.getBusinessFormId();
            //业态名称
            String businessFormName = contractTriangleCQRSListResponseDTO.getBusinessFormName();
            //业种id
            String businessSpeciesId = contractTriangleCQRSListResponseDTO.getBusinessSpeciesId();
            //业种名称
            String businessSpeciesName = contractTriangleCQRSListResponseDTO.getBusinessSpeciesName();
            //面积
            BigDecimal acreage = contractTriangleCQRSListResponseDTO.getAcreage();

            //品牌面积累计
            areas.add(acreage);

            //通过签约id+当天时间查询溢租率租费信息
            DayRentResponseDTO dayRentResponseDTO = dayRentMapper.findDayRentResponseDTOByContractId(contractId,LocalDateTime.now());
            //租金
            BigDecimal rent = dayRentResponseDTO.getRent();
            //物业费
            BigDecimal propertyFee = dayRentResponseDTO.getPropertyFee();
            //员工成本
            BigDecimal  staffEmp = dayRentResponseDTO.getStaffEmp();
            //装修折旧
            BigDecimal fitment = dayRentResponseDTO.getFitment();
            //代理费
            BigDecimal  agencyFee = dayRentResponseDTO.getAgencyFee();
            //租费累加
            projectRent.add(rent).add(propertyFee).add(fitment);
            //固定成本累加
            fixedCost.add(rent).add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);

            //通过签约id+当天时间查询适配值信息，然后计算出品牌适配值
            QuarterFittedResponseDTO quarterFittedResponseDTO = quarterFittedMapper.findQuarterFittedResponseDTOByContractId(contractId,LocalDateTime.now());
            //市场定位
            Integer marketPosition = quarterFittedResponseDTO.getMarketPosition();
            //品牌定位
            Integer brandPosition = quarterFittedResponseDTO.getBrandPosition();
            //品牌形象
            Integer brandImage = quarterFittedResponseDTO.getBrandImage();
            //租费收缴率
            BigDecimal rentalRate = quarterFittedResponseDTO.getRentalRate();
            //连锁跟进度
            BigDecimal chainDegree = quarterFittedResponseDTO.getChainDegree();
            //客服投诉率
            BigDecimal complaintDegree = quarterFittedResponseDTO.getComplaintDegree();
            //企划配合度
            BigDecimal layoutDegree = quarterFittedResponseDTO.getLayoutDegree();

            BigDecimal shd = new BigDecimal(marketPosition+brandPosition+brandImage);
            //配合度
            BigDecimal phd = rentalRate.add(chainDegree).add(complaintDegree).add(layoutDegree);

            //品牌权重适配值
            projectFitted.add(
                    (shd.multiply(phd).multiply(acreage.divide(projectArea)))
                    );

            //通过签约id+当天时间查询客销度（客流量、销售额）计算客销度
            DayGuestResponseDTO dayGuestResponseDTO = dayGuestMapper.findDayGuestByDayGuestByContractId(contractId,LocalDateTime.now());

          /*  //客流量
            BigDecimal passengerFlow = dayGuestResponseDTO.getPassengerFlow();*/
            //销售额获取并累加
            BigDecimal saleroom = dayGuestResponseDTO.getSaleroom();
            projectSale.add(saleroom);

            //通过签约id查询标准三角形客销度
            StandardBrandSaleRequestDTO standardBrandSaleRequestDTO  = new StandardBrandSaleRequestDTO();
            standardBrandSaleRequestDTO.setContractId(contractId);
            standardBrandSaleRequestDTO.setProjectId(projectId);
            List<StandardBrandSaleResponseDTO> standardBrandSaleResponseDTOs =  standardBrandSaleMapper.findStandardBrandSaleByStandardBrandSaleCQRS(standardBrandSaleRequestDTO);
            //毛利率
            BigDecimal grossRate =  standardBrandSaleResponseDTOs.get(0).getGrossRate();
            //客单价
            BigDecimal perSale =  standardBrandSaleResponseDTOs.get(0).getPerSale();

            //BigDecimal jlr =净利润=销售收入*毛利率-rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);
            BigDecimal jlr =saleroom.multiply(grossRate).subtract(rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee));
            //净利润累计
            projectJlr.add(jlr);


            //销售收入
//            BigDecimal saleIn = rent.add(propertyFee).add(fitment).add(staffEmp).add(agencyFee).divide(grossRate);
            //标准三角形客流量
            BigDecimal standardPassengerFlow = saleroom.divide(perSale);
            standardPassengerFlows.add(standardPassengerFlow);

        });

        //动态三角形溢租率=净利润之和/租费之和
        brandTriangleResponseDTO.setTriangleRent(projectJlr.divide(projectRent));
        //动态三角形适配值
        brandTriangleResponseDTO.setTriangleFitted(projectFitted);
        //动态三角形客销度
        BigDecimal trangleGuest = projectGuest.divide(projectArea).multiply(projectSale.divide(projectArea));
        brandTriangleResponseDTO.setTriangleGuest(trangleGuest);


        //通过项目id查询标准三角形溢租率
        StandardProjectRentResponseDTO standardProjectResponseDTOS = standardProjectRentMapper.findStandardProjectRentByProjectId(brandTriangleRequestDTO.getProjectId());
        BigDecimal standardRent = standardProjectResponseDTOS.getRent();
        //设置标准三角形溢租率
        brandTriangleResponseDTO.setStandardRent(standardRent);

        //通过项目id查询标准三角形适配值
        StandardProjectFittedResponseDTO standardProjectFittedRequestDTO =  standardProjectFittedMapper.findstandardProjectFittedByProjectId(brandTriangleRequestDTO.getProjectId());
        //设置标准中三角形适配值
        brandTriangleResponseDTO.setStandardFitted(standardProjectFittedRequestDTO.getFitted());
        //获取标准项目三角形客销度
        brandTriangleResponseDTO.setStandardGuest(standardPassengerFlows.divide(projectArea).multiply(projectSale.divide(projectArea)));

        ProjectGuestIntervalResponseDTO projectGuestIntervalByProjectId  =  projectGuestIntervalMapper.findProjectGuestIntervalByProjectId(brandTriangleRequestDTO.getProjectId());
        //优秀
        Integer yx = projectGuestIntervalByProjectId.getYx();
        //良好
        Integer lh = projectGuestIntervalByProjectId.getLh();
        //提升
        Integer ts = projectGuestIntervalByProjectId.getTs();
        //合格
        Integer hl = projectGuestIntervalByProjectId.getHl();
        //亏损
        Integer ks = projectGuestIntervalByProjectId.getKs();
        Map<String ,Integer> guestMap = new HashMap<String ,Integer>();
        guestMap.put("yx",yx);
        guestMap.put("lh",lh);
        guestMap.put("ts",ts);
        guestMap.put("hl",hl);
        guestMap.put("ks",ks);
        //品牌客销度区间设置
        brandTriangleResponseDTO.setIntervalGuest(guestMap);

        //设置溢租率区间
        Map<String ,Integer>   rentMap = new HashMap<String ,Integer>();
        rentMap.put("yx",350);
        rentMap.put("lh",300);
        rentMap.put("ts",200);
        rentMap.put("hl",100);
        rentMap.put("ks",0);
        brandTriangleResponseDTO.setIntervalGuest(rentMap);
        //设置适配值区间
        Map<String ,Integer>   fittedMap = new HashMap<String ,Integer>();
        fittedMap.put("yx",10000);
        fittedMap.put("lh",9000);
        fittedMap.put("ts",8000);
        fittedMap.put("hl",7000);
        fittedMap.put("ks",6400);
        brandTriangleResponseDTO.setIntervalGuest(fittedMap);

        //查询帮扶计划
        HelpPlanProject  helpPlanProject = helpMapper.findHelpPlanProjectByProjectId(brandTriangleRequestDTO.getProjectId());

        if(trangleGuest.compareTo(new BigDecimal(yx))==-1 && trangleGuest.compareTo(new BigDecimal(lh))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanProject.getYxHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(lh))==-1 && trangleGuest.compareTo(new BigDecimal(ts))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanProject.getLhHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(ts))==-1 && trangleGuest.compareTo(new BigDecimal(hl))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanProject.getTsHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(hl))==-1 && trangleGuest.compareTo(new BigDecimal(ks))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanProject.getLhHelpContext());
        }else{
            brandTriangleResponseDTO.setGuestContent("无");
        }

        return brandTriangleResponseDTO;
    }

    /**
     * 通过项目id 、楼层id 查询楼层三角形
     * @param brandTriangleRequestDTO
     * @return
     */
    @Override
    public BrandTriangleResponseDTO findBrandTriangleByFloorId(BrandTriangleRequestDTO brandTriangleRequestDTO) {
        //楼层三角形返回值
        BrandTriangleResponseDTO brandTriangleResponseDTO = new BrandTriangleResponseDTO();

        String projectId = brandTriangleRequestDTO.getProjectId();
        String floorId = brandTriangleRequestDTO.getFloorId();

        //通过项目id与楼层id 查询签约信息
        ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO = new ContractTriangleCQRSListRequestDTO();
        contractTriangleCQRSListRequestDTO.setProjectId(projectId);
        contractTriangleCQRSListRequestDTO.setFloorId(floorId);
        List<ContractTriangleCQRSListResponseDTO> contractCQRSList =  contractCQRSMapper.findContractTriangleCQRSListResponseDTO(contractTriangleCQRSListRequestDTO);

        //通过项目id查询项目面积
        Floor floor =  regionMapper.findFloorById(floorId);
        //项目面积
        BigDecimal floorArea = floor.getAcreage();

        //品牌面积累计
        BigDecimal areas = new BigDecimal(0);
        //维度净利润
        BigDecimal floorJlr = new BigDecimal(0);
        //维度溢租率租费
        BigDecimal floorRent = new BigDecimal(0);
        //维度固定成本
        BigDecimal fixedCost = new BigDecimal(0);


        FloorGuestResponseDTO floorGuestResponseDTO = floorGuestMapper.findFloorGuestByProjectId(projectId,floorId);
        //维度客流（去对应维度）
        BigDecimal floorGuest =floorGuestResponseDTO.getPassengerFlow();//获取楼层客流

        //累计维度销售
        BigDecimal floorSale = new BigDecimal(0);
        //适配值权重合计
        BigDecimal floorFitted = new BigDecimal(0);

        //标准三角形客流量累计
        BigDecimal standardPassengerFlows = new BigDecimal(0);

        contractCQRSList.forEach(contractTriangleCQRSListResponseDTO->{
            String contractId = contractTriangleCQRSListResponseDTO.getId();

            //项目名称
            String projectName = contractTriangleCQRSListResponseDTO.getProjectName();
            //品牌名称
            String brandName = contractTriangleCQRSListResponseDTO.getBrandName();
            //品牌id
            String brandId = contractTriangleCQRSListResponseDTO.getBrandId();
            //楼层名称
            String floorName = contractTriangleCQRSListResponseDTO.getFloorName();
            //铺位id
            String roomId = contractTriangleCQRSListResponseDTO.getRoomId();
            //铺位名称
            String roomName = contractTriangleCQRSListResponseDTO.getRoomName();
            //业态id
            String businessFormId = contractTriangleCQRSListResponseDTO.getBusinessFormId();
            //业态名称
            String businessFormName = contractTriangleCQRSListResponseDTO.getBusinessFormName();
            //业种id
            String businessSpeciesId = contractTriangleCQRSListResponseDTO.getBusinessSpeciesId();
            //业种名称
            String businessSpeciesName = contractTriangleCQRSListResponseDTO.getBusinessSpeciesName();
            //面积
            BigDecimal acreage = contractTriangleCQRSListResponseDTO.getAcreage();

            //品牌面积累计
            areas.add(acreage);

            //通过签约id+当天时间查询溢租率租费信息
            DayRentResponseDTO dayRentResponseDTO = dayRentMapper.findDayRentResponseDTOByContractId(contractId,LocalDateTime.now());
            //租金
            BigDecimal rent = dayRentResponseDTO.getRent();
            //物业费
            BigDecimal propertyFee = dayRentResponseDTO.getPropertyFee();
            //员工成本
            BigDecimal  staffEmp = dayRentResponseDTO.getStaffEmp();
            //装修折旧
            BigDecimal fitment = dayRentResponseDTO.getFitment();
            //代理费
            BigDecimal  agencyFee = dayRentResponseDTO.getAgencyFee();
            //租费累加
            floorRent.add(rent).add(propertyFee).add(fitment);
            //固定成本累加
            fixedCost.add(rent).add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);

            //通过签约id+当天时间查询适配值信息，然后计算出品牌适配值
            QuarterFittedResponseDTO quarterFittedResponseDTO = quarterFittedMapper.findQuarterFittedResponseDTOByContractId(contractId,LocalDateTime.now());
            //市场定位
            Integer marketPosition = quarterFittedResponseDTO.getMarketPosition();
            //品牌定位
            Integer brandPosition = quarterFittedResponseDTO.getBrandPosition();
            //品牌形象
            Integer brandImage = quarterFittedResponseDTO.getBrandImage();
            //租费收缴率
            BigDecimal rentalRate = quarterFittedResponseDTO.getRentalRate();
            //连锁跟进度
            BigDecimal chainDegree = quarterFittedResponseDTO.getChainDegree();
            //客服投诉率
            BigDecimal complaintDegree = quarterFittedResponseDTO.getComplaintDegree();
            //企划配合度
            BigDecimal layoutDegree = quarterFittedResponseDTO.getLayoutDegree();

            BigDecimal shd = new BigDecimal(marketPosition+brandPosition+brandImage);
            //配合度
            BigDecimal phd = rentalRate.add(chainDegree).add(complaintDegree).add(layoutDegree);

            //品牌权重适配值
            floorFitted.add(
                    (shd.multiply(phd).multiply(acreage.divide(floorArea)))
            );

            //通过签约id+当天时间查询客销度（客流量、销售额）计算客销度
            DayGuestResponseDTO dayGuestResponseDTO = dayGuestMapper.findDayGuestByDayGuestByContractId(contractId,LocalDateTime.now());

          /*  //客流量
            BigDecimal passengerFlow = dayGuestResponseDTO.getPassengerFlow();*/
            //销售额获取并累加
            BigDecimal saleroom = dayGuestResponseDTO.getSaleroom();
            floorSale.add(saleroom);

            //通过签约id查询标准三角形客销度
            StandardBrandSaleRequestDTO standardBrandSaleRequestDTO  = new StandardBrandSaleRequestDTO();
            standardBrandSaleRequestDTO.setContractId(contractId);
            standardBrandSaleRequestDTO.setProjectId(projectId);
            List<StandardBrandSaleResponseDTO> standardBrandSaleResponseDTOs =  standardBrandSaleMapper.findStandardBrandSaleByStandardBrandSaleCQRS(standardBrandSaleRequestDTO);
            //毛利率
            BigDecimal grossRate =  standardBrandSaleResponseDTOs.get(0).getGrossRate();
            //客单价
            BigDecimal perSale =  standardBrandSaleResponseDTOs.get(0).getPerSale();

            //BigDecimal jlr =净利润=销售收入*毛利率-rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);
            BigDecimal jlr =saleroom.multiply(grossRate).subtract(rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee));
            //净利润累计
            floorJlr.add(jlr);

            //标准三角形客流量 = 销售额除以客单价
            BigDecimal standardPassengerFlow = saleroom.divide(perSale);
            standardPassengerFlows.add(standardPassengerFlow);

        });

        //动态三角形溢租率=净利润之和/租费之和
        brandTriangleResponseDTO.setTriangleRent(floorJlr.divide(floorRent));
        //动态三角形适配值
        brandTriangleResponseDTO.setTriangleFitted(floorFitted);
        //动态三角形客销度
        BigDecimal trangleGuest = floorGuest.divide(floorArea).multiply(floorSale.divide(floorArea));
        brandTriangleResponseDTO.setTriangleGuest(trangleGuest);

        //通过项目id、楼层id查询标准三角形溢租率
        StandardFloorRentResponseDTO standardFloorResponseDTO = standardFloorRentMapper.findStandardFloorRentByProjectIdAndFloorId(projectId,floorId);
        BigDecimal standardRent = standardFloorResponseDTO.getRent();
        //设置标准三角形溢租率
        brandTriangleResponseDTO.setStandardRent(standardRent);

        //通过项目id、楼层id查询标准三角形适配值
//        StandardFloorResponseDTO standardConditionFittedRequestDTO =  standardProjectFittedMapper.findstandardProjectFittedByProjectId(brandTriangleRequestDTO.getProjectId());
        StandardFloorFittedResponseDTO standardFloorFittedResponseDTO =  standardFloorFittedMapper.findstandardFloorFittedByProjectIdAndFloorId(projectId,floorId);
        //设置标准中三角形适配值
        brandTriangleResponseDTO.setStandardFitted(standardFloorFittedResponseDTO.getFitted());
        //获取标准项目三角形客销度
        brandTriangleResponseDTO.setStandardGuest(standardPassengerFlows.divide(floorArea).multiply(floorSale.divide(floorArea)));

        FloorGuestIntervalResponseDTO floorGuestIntervalResponseDTO  =  floorGuestIntervalMapper.findFloorGuestIntervalByProjectIdAndFloorId(projectId,floorId);//TODO------
        //优秀
        Integer yx = floorGuestIntervalResponseDTO.getYx();
        //良好
        Integer lh = floorGuestIntervalResponseDTO.getLh();
        //提升
        Integer ts = floorGuestIntervalResponseDTO.getTs();
        //合格
        Integer hl = floorGuestIntervalResponseDTO.getHl();
        //亏损
        Integer ks = floorGuestIntervalResponseDTO.getKs();
        Map<String ,Integer> guestMap = new HashMap<String ,Integer>();
        guestMap.put("yx",yx);
        guestMap.put("lh",lh);
        guestMap.put("ts",ts);
        guestMap.put("hl",hl);
        guestMap.put("ks",ks);
        //品牌客销度区间设置
        brandTriangleResponseDTO.setIntervalGuest(guestMap);

        //设置溢租率区间
        Map<String ,Integer>   rentMap = new HashMap<String ,Integer>();
        rentMap.put("yx",350);
        rentMap.put("lh",300);
        rentMap.put("ts",200);
        rentMap.put("hl",100);
        rentMap.put("ks",0);
        brandTriangleResponseDTO.setIntervalGuest(rentMap);
        //设置适配值区间
        Map<String ,Integer>   fittedMap = new HashMap<String ,Integer>();
        fittedMap.put("yx",10000);
        fittedMap.put("lh",9000);
        fittedMap.put("ts",8000);
        fittedMap.put("hl",7000);
        fittedMap.put("ks",6400);
        brandTriangleResponseDTO.setIntervalGuest(fittedMap);

        //查询帮扶计划
        HelpPlanFloor helpPlanFloor = helpMapper.findHelpPlanFloorByProjectIdAndFloorId(projectId,floorId);

        if(trangleGuest.compareTo(new BigDecimal(yx)) == -1 && trangleGuest.compareTo(new BigDecimal(lh)) == 1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getYxHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(lh))==-1 && trangleGuest.compareTo(new BigDecimal(ts))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getLhHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(ts))==-1 && trangleGuest.compareTo(new BigDecimal(hl))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getTsHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(hl))==-1 && trangleGuest.compareTo(new BigDecimal(ks))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getLhHelpContext());
        }else{
            brandTriangleResponseDTO.setGuestContent("无.");
        }

        return brandTriangleResponseDTO;
    }


    @Override
    public BrandTriangleResponseDTO findBrandTriangleByConditionId(BrandTriangleRequestDTO brandTriangleRequestDTO) {
        //项目id
        String projectId = brandTriangleRequestDTO.getProjectId();
        //楼层id
        String floorId = brandTriangleRequestDTO.getFloorId();
        //业态id
        String conditionId = brandTriangleRequestDTO.getConditionId();

        //业态三角形返回值
        BrandTriangleResponseDTO brandTriangleResponseDTO = new BrandTriangleResponseDTO();

        //通过项目id、楼层id、业态id查询签约信息
        ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO = new ContractTriangleCQRSListRequestDTO();
        contractTriangleCQRSListRequestDTO.setProjectId(projectId);
        contractTriangleCQRSListRequestDTO.setFloorId(floorId);
        contractTriangleCQRSListRequestDTO.setBusinessFormId(conditionId);
        List<ContractTriangleCQRSListResponseDTO> contractCQRSList =  contractCQRSMapper.findContractTriangleCQRSListResponseDTO(contractTriangleCQRSListRequestDTO);

        //品牌面积累计
        BigDecimal areas = new BigDecimal(0);
        //维度净利润
        BigDecimal conditionJlr = new BigDecimal(0);
        //维度溢租率租费
        BigDecimal conditionRent = new BigDecimal(0);
        //维度固定成本
        BigDecimal fixedCost = new BigDecimal(0);

        //维度客流合计
        BigDecimal conditionGuest =new BigDecimal(0);//获取楼层客流

        //累计维度销售
        BigDecimal conditionSale = new BigDecimal(0);
        //适配值权重合计
        BigDecimal conditionFitted = new BigDecimal(0);

        //标准三角形客流量累计
        BigDecimal standardPassengerFlows = new BigDecimal(0);
        //循环获取业态面积合计
        contractCQRSList.forEach(contractTriangleCQRSListResponseDTO->{
            //品牌面积累计
            areas.add(contractTriangleCQRSListResponseDTO.getAcreage());
          });


        contractCQRSList.forEach(contractTriangleCQRSListResponseDTO->{
            String contractId = contractTriangleCQRSListResponseDTO.getId();

            //项目名称
            String projectName = contractTriangleCQRSListResponseDTO.getProjectName();
            //品牌名称
            String brandName = contractTriangleCQRSListResponseDTO.getBrandName();
            //品牌id
            String brandId = contractTriangleCQRSListResponseDTO.getBrandId();
            //楼层名称
            String floorName = contractTriangleCQRSListResponseDTO.getFloorName();
            //铺位id
            String roomId = contractTriangleCQRSListResponseDTO.getRoomId();
            //铺位名称
            String roomName = contractTriangleCQRSListResponseDTO.getRoomName();
         /*   //业态id
            String businessFormId = contractTriangleCQRSListResponseDTO.getBusinessFormId();*/
            //业态名称
            String businessFormName = contractTriangleCQRSListResponseDTO.getBusinessFormName();
            //业种id
            String businessSpeciesId = contractTriangleCQRSListResponseDTO.getBusinessSpeciesId();
            //业种名称
            String businessSpeciesName = contractTriangleCQRSListResponseDTO.getBusinessSpeciesName();
            //面积
            BigDecimal acreage = contractTriangleCQRSListResponseDTO.getAcreage();


            //通过签约id+当天时间查询溢租率租费信息
            DayRentResponseDTO dayRentResponseDTO = dayRentMapper.findDayRentResponseDTOByContractId(contractId,LocalDateTime.now());
            //租金
            BigDecimal rent = dayRentResponseDTO.getRent();
            //物业费
            BigDecimal propertyFee = dayRentResponseDTO.getPropertyFee();
            //员工成本
            BigDecimal  staffEmp = dayRentResponseDTO.getStaffEmp();
            //装修折旧
            BigDecimal fitment = dayRentResponseDTO.getFitment();
            //代理费
            BigDecimal  agencyFee = dayRentResponseDTO.getAgencyFee();
            //租费累加
            conditionRent.add(rent).add(propertyFee).add(fitment);
            //固定成本累加
            fixedCost.add(rent).add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);

            //通过签约id+当天时间查询适配值信息，然后计算出品牌适配值
            QuarterFittedResponseDTO quarterFittedResponseDTO = quarterFittedMapper.findQuarterFittedResponseDTOByContractId(contractId,LocalDateTime.now());
            //市场定位
            Integer marketPosition = quarterFittedResponseDTO.getMarketPosition();
            //品牌定位
            Integer brandPosition = quarterFittedResponseDTO.getBrandPosition();
            //品牌形象
            Integer brandImage = quarterFittedResponseDTO.getBrandImage();
            //租费收缴率
            BigDecimal rentalRate = quarterFittedResponseDTO.getRentalRate();
            //连锁跟进度
            BigDecimal chainDegree = quarterFittedResponseDTO.getChainDegree();
            //客服投诉率
            BigDecimal complaintDegree = quarterFittedResponseDTO.getComplaintDegree();
            //企划配合度
            BigDecimal layoutDegree = quarterFittedResponseDTO.getLayoutDegree();

            BigDecimal shd = new BigDecimal(marketPosition+brandPosition+brandImage);
            //配合度
            BigDecimal phd = rentalRate.add(chainDegree).add(complaintDegree).add(layoutDegree);

            //品牌权重适配值
            conditionFitted.add(
                    (shd.multiply(phd).multiply(acreage.divide(areas)))
            );

            //通过签约id+当天时间查询客销度（客流量、销售额）计算客销度
            DayGuestResponseDTO dayGuestResponseDTO = dayGuestMapper.findDayGuestByDayGuestByContractId(contractId,LocalDateTime.now());

          /*  //客流量
            BigDecimal passengerFlow = dayGuestResponseDTO.getPassengerFlow();*/
            //销售额获取并累加
            BigDecimal saleroom = dayGuestResponseDTO.getSaleroom();
            conditionSale.add(saleroom);

            //通过签约id查询标准三角形客销度
            StandardBrandSaleRequestDTO standardBrandSaleRequestDTO  = new StandardBrandSaleRequestDTO();
            standardBrandSaleRequestDTO.setContractId(contractId);
            standardBrandSaleRequestDTO.setProjectId(projectId);
            List<StandardBrandSaleResponseDTO> standardBrandSaleResponseDTOs =  standardBrandSaleMapper.findStandardBrandSaleByStandardBrandSaleCQRS(standardBrandSaleRequestDTO);
            //毛利率
            BigDecimal grossRate =  standardBrandSaleResponseDTOs.get(0).getGrossRate();
            //客单价
            BigDecimal perSale =  standardBrandSaleResponseDTOs.get(0).getPerSale();

            //BigDecimal jlr =净利润=销售收入*毛利率-rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee);
            BigDecimal jlr =saleroom.multiply(grossRate).subtract(rent.add(propertyFee).add(staffEmp).add(fitment).add(agencyFee));
            //净利润累计
            conditionJlr.add(jlr);

            //标准三角形客流量 = 销售额除以客单价
            BigDecimal standardPassengerFlow = saleroom.divide(perSale);
            standardPassengerFlows.add(standardPassengerFlow);

        });

        //动态三角形溢租率=净利润之和/租费之和
        brandTriangleResponseDTO.setTriangleRent(conditionJlr.divide(conditionRent));
        //动态三角形适配值
        brandTriangleResponseDTO.setTriangleFitted(conditionFitted);
        //动态三角形客销度
        BigDecimal trangleGuest = conditionGuest.divide(areas).multiply(conditionSale.divide(areas));
        brandTriangleResponseDTO.setTriangleGuest(trangleGuest);

        //通过项目id、业态id、业种id查询标准三角形溢租率
        StandardConditionRentRequestDTO standardConditionRentRequestDTO = new StandardConditionRentRequestDTO();
        standardConditionRentRequestDTO.setProjectId(projectId);
        standardConditionRentRequestDTO.setConditionId(conditionId);
        List<StandardConditionRentResponseDTO> standardConditionRentResponseDTOs = standardConditionRentMapper.findStandardConditionRentByStandardConditionRentCQRS(standardConditionRentRequestDTO);
        BigDecimal standardRent = standardConditionRentResponseDTOs.get(0).getRent();

        //设置标准三角形溢租率
        brandTriangleResponseDTO.setStandardRent(standardRent);

        //通过项目id、楼层id查询标准三角形适配值
        //通过项目id、业态id、业种id查询标准三角形适配值
        StandardConditionFittedRequestDTO standardConditionFittedRequestDTO = new  StandardConditionFittedRequestDTO();
        standardConditionFittedRequestDTO.setProjectId(projectId);
        standardConditionFittedRequestDTO.setConditionId(conditionId);
        List<StandardConditionFittedResponseDTO> standardConditionFittedResponseDTOs =  standardConditionFittedMapper.findStandardConditionFittedByStandardConditionFittedCQRS(standardConditionFittedRequestDTO);
        //设置标准中三角形适配值
        brandTriangleResponseDTO.setStandardFitted(standardConditionFittedResponseDTOs.get(0).getFitted());
        //获取标准项目三角形客销度
        brandTriangleResponseDTO.setStandardGuest(standardPassengerFlows.divide(areas).multiply(conditionSale.divide(areas)));

        //通过项目id、品牌id、业态id、业种id 查询 客销度区间
        ConditionGuestIntervalRequestDTO conditionGuestIntervalRequestDTO = new ConditionGuestIntervalRequestDTO();
        conditionGuestIntervalRequestDTO.setProjectId(projectId);
        conditionGuestIntervalRequestDTO.setConditionId(conditionId);
        //conditionGuestIntervalRequestDTO.setMajoId(businessSpeciesId); //TODO--------
        List<ConditionGuestIntervalResponseDTO> conditionGuestIntervalResponseDTOs  =  conditionGuestIntervalMapper.findConditionGuestIntervalByConditionGuestIntervalCQRS(conditionGuestIntervalRequestDTO);//TODO---
        //优秀
        Integer yx = conditionGuestIntervalResponseDTOs.get(0).getYx();
        //良好
        Integer lh = conditionGuestIntervalResponseDTOs.get(0).getLh();
        //提升
        Integer ts = conditionGuestIntervalResponseDTOs.get(0).getTs();
        //合格
        Integer hl = conditionGuestIntervalResponseDTOs.get(0).getHl();
        //亏损
        Integer ks = conditionGuestIntervalResponseDTOs.get(0).getKs();
        Map<String ,Integer> guestMap = new HashMap<String ,Integer>();
        guestMap.put("yx",yx);
        guestMap.put("lh",lh);
        guestMap.put("ts",ts);
        guestMap.put("hl",hl);
        guestMap.put("ks",ks);
        //品牌客销度区间设置
        brandTriangleResponseDTO.setIntervalGuest(guestMap);

        //设置溢租率区间
        Map<String ,Integer>   rentMap = new HashMap<String ,Integer>();
        rentMap.put("yx",350);
        rentMap.put("lh",300);
        rentMap.put("ts",200);
        rentMap.put("hl",100);
        rentMap.put("ks",0);
        brandTriangleResponseDTO.setIntervalGuest(rentMap);
        //设置适配值区间
        Map<String ,Integer>   fittedMap = new HashMap<String ,Integer>();
        fittedMap.put("yx",10000);
        fittedMap.put("lh",9000);
        fittedMap.put("ts",8000);
        fittedMap.put("hl",7000);
        fittedMap.put("ks",6400);
        brandTriangleResponseDTO.setIntervalGuest(fittedMap);

        //查询帮扶计划
        HelpPlanFloor helpPlanFloor = helpMapper.findHelpPlanFloorByProjectIdAndFloorId(projectId,floorId);

        if(trangleGuest.compareTo(new BigDecimal(yx))==-1 && trangleGuest.compareTo(new BigDecimal(lh))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getYxHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(lh))==-1 && trangleGuest.compareTo(new BigDecimal(ts))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getLhHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(ts))==-1 && trangleGuest.compareTo(new BigDecimal(hl))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getTsHelpContext());
        }else if (trangleGuest.compareTo(new BigDecimal(hl))==-1 && trangleGuest.compareTo(new BigDecimal(ks))==1){
            brandTriangleResponseDTO.setGuestContent(helpPlanFloor.getLhHelpContext());
        }else{
            brandTriangleResponseDTO.setGuestContent("无.");
        }
        return brandTriangleResponseDTO;
    }

    @Override
    public List<AllSalePassengerFlowResponseDTO> findSalePassengerFlowAll() {
        return dayGuestMapper.findSalePassengerFlowAll();
    }
}
