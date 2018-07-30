-- 创建员工表
CREATE TABLE IF NOT EXISTS `yhcc_employee`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (100),
  `name` VARCHAR (100),
  `phone` VARCHAR (100),
  `email` VARCHAR (100),
  `user_name` VARCHAR (100),
  `password` VARCHAR (100),
  `state` TINYINT (1),
  `type` int(11),
  `org_id` VARCHAR (100),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建部门表
CREATE TABLE IF NOT EXISTS `yhcc_department`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (100),
  `name` VARCHAR (100),
  `parent_id` VARCHAR (50),
  `type` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建部门员工关系表
CREATE TABLE IF NOT EXISTS `yhcc_employee_department_relation`(

  `id` VARCHAR (50) NOT NULL,
  `employee_id` VARCHAR (50),
  `department_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建员工角色关系表
CREATE TABLE IF NOT EXISTS `yhcc_employee_role_relation`(

  `id` VARCHAR (50) NOT NULL,
  `employee_id` VARCHAR (50),
  `role_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建角色表
CREATE TABLE IF NOT EXISTS `yhcc_role`(

  `id` VARCHAR (50) NOT NULL,
  `name` VARCHAR (100),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建菜单表
CREATE TABLE IF NOT EXISTS `yhcc_menu`(

  `id` VARCHAR (50) NOT NULL,
  `name` VARCHAR (100),
  `is_root` TINYINT (1),
  `parent_id` VARCHAR (50),
  `menu_type` VARCHAR (50),
  `url` VARCHAR (255),
  `sort` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建角色菜单关系表
CREATE TABLE IF NOT EXISTS `yhcc_role_menu_relation`(

  `id` VARCHAR (50) NOT NULL,
  `role_id` VARCHAR (50),
  `menu_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建Token表
CREATE TABLE IF NOT EXISTS `yhcc_token`(

  `id` VARCHAR (50) NOT NULL,
  `access_token` VARCHAR (50),
  `refresh_token` VARCHAR (50),
  `employee_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`),
  UNIQUE KEY (`employee_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建AppToken表
CREATE TABLE IF NOT EXISTS `yhcc_app_token`(

  `id` VARCHAR (50) NOT NULL,
  `access_token` VARCHAR (50),
  `refresh_token` VARCHAR (50),
  `employee_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (50),
  `modify_user` VARCHAR (50),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建区域表
CREATE TABLE IF NOT EXISTS `yhcc_area`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (100),
  `level` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目负责人组员表
CREATE TABLE IF NOT EXISTS `yhcc_employee_project_relation_team`(

  `id` VARCHAR (50) NOT NULL,
  `employee_id` VARCHAR (50),
  `project_id` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目表
CREATE TABLE IF NOT EXISTS `yhcc_project`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `area_id` VARCHAR (50),
  `company_id` VARCHAR (50),
  `name` VARCHAR (50),
  `project_head_id` VARCHAR (50),
  `project_audit_id` VARCHAR (50),
  `state` TINYINT (1),
  `acreage` decimal(18,2),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建公司表
CREATE TABLE IF NOT EXISTS `yhcc_company`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (50),
  `parent_id` VARCHAR (50),
  `type` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目图片表
CREATE TABLE IF NOT EXISTS `yhcc_project_image`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `url` VARCHAR (500),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建员工项目数据权限表
CREATE TABLE IF NOT EXISTS `yhcc_employee_project_data`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `employee_id` VARCHAR (500),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建城市表(直辖市+省)
CREATE TABLE IF NOT EXISTS `yhcc_city`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (500),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建指标表
CREATE TABLE IF NOT EXISTS `yhcc_target`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (500),
  `show_name` VARCHAR (500),
  `state` TINYINT (1),
  `target_type` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建业态表
CREATE TABLE IF NOT EXISTS `yhcc_business_form`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (100),
  `name` VARCHAR (500),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建业种表
CREATE TABLE IF NOT EXISTS `yhcc_business_species`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (100),
  `business_form_id` VARCHAR (50),
  `name` VARCHAR (500),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建区间设置表
CREATE TABLE IF NOT EXISTS `yhcc_interval_conf`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `dimension` int(11),
  `type` int(11),
  `business_form_id` VARCHAR (50),
  `business_species_id` VARCHAR (50),
  `yx` int(11),
  `lh` int(11),
  `ts` int(11),
  `hl` int(11),
  `ks` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形表
CREATE TABLE IF NOT EXISTS `yhcc_triangle`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `dimension` int(11),
  `business_form_id` VARCHAR (50),
  `business_species_id` VARCHAR (50),
  `probably_profits` decimal(18,2),
  `price` decimal(18,2),
  `rent_ratio` decimal(18,2),
  `gp_degree` decimal(18,2),
  `adapter` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建楼栋表
CREATE TABLE IF NOT EXISTS `yhcc_building`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `company_id` VARCHAR (50),
  `project_id` VARCHAR (50),
  `name` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建楼层表
CREATE TABLE IF NOT EXISTS `yhcc_floor`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `company_id` VARCHAR (50),
  `project_id` VARCHAR (50),
  `building_id` VARCHAR (50),
  `name` VARCHAR (50),
  `location` VARCHAR (50),
  `acreage` decimal(18,2),
  `state` TINYINT (1),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建铺位表
CREATE TABLE IF NOT EXISTS `yhcc_room`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (50),
  `company_id` VARCHAR (50),
  `project_id` VARCHAR (50),
  `building_id` VARCHAR (50),
  `floor_id` VARCHAR (50),
  `state` int(11),
  `acreage` decimal(18,2),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建品牌表
CREATE TABLE IF NOT EXISTS `yhcc_brand`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `name` VARCHAR (50),
  `business_form_id` VARCHAR (50),
  `business_species_id` VARCHAR (50),
  `brand_type` int(11),
  `state` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建公式表
CREATE TABLE IF NOT EXISTS `yhcc_formula`(

  `id` VARCHAR (50) NOT NULL,
  `num` VARCHAR (50),
  `target_id` VARCHAR (50),
  `target_name` VARCHAR (50),
  `operation_formula` VARCHAR (500),
  `result_formula` VARCHAR (500),
  `state` TINYINT (1),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建外部组织机构数据表
CREATE TABLE IF NOT EXISTS `yhcc_external_org`(

  `id` VARCHAR (100) NOT NULL,
  `name` VARCHAR (255),
  `parent_id` VARCHAR (100),
  `type` VARCHAR (50),
  `code` VARCHAR (50),
  `status` VARCHAR (10),
  `delflag` TINYINT (1),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建外部员工数据表
CREATE TABLE IF NOT EXISTS `yhcc_external_employee`(

  `id` VARCHAR (50) NOT NULL,
  `real_name` VARCHAR (50),
  `login_name` VARCHAR (50),
  `email` VARCHAR (50),
  `belong_org_id` VARCHAR (50),
  `mobile` VARCHAR (50),
  `status` VARCHAR (10),
  `delflag` TINYINT (1),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建签约表
CREATE TABLE IF NOT EXISTS `yhcc_contract`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `floor_id` VARCHAR (50),
  `room_id` VARCHAR (50),
  `brand_id` VARCHAR (50),
  `status` TINYINT (1),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建帮扶内容表
CREATE TABLE IF NOT EXISTS `yhcc_help_context`(

  `id` VARCHAR (50) NOT NULL,
  `context` VARCHAR (255),
  `type` int(11),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目帮扶计划表
CREATE TABLE IF NOT EXISTS `yhcc_help_project`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `yx_help_context` VARCHAR (50),
  `lh_help_context` VARCHAR (50),
  `ts_help_context` VARCHAR (50),
  `hl_help_context` VARCHAR (50),
  `ks_help_context` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建楼层帮扶计划表
CREATE TABLE IF NOT EXISTS `yhcc_help_floor`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `floor_id` VARCHAR (50),
  `yx_help_context` VARCHAR (50),
  `lh_help_context` VARCHAR (50),
  `ts_help_context` VARCHAR (50),
  `hl_help_context` VARCHAR (50),
  `ks_help_context` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建业种帮扶计划表
CREATE TABLE IF NOT EXISTS `yhcc_help_business_species`(

  `id` VARCHAR (50) NOT NULL,
  `project_id` VARCHAR (50),
  `business_form_id` VARCHAR (50),
  `business_species_id` VARCHAR (50),
  `yx_help_context` VARCHAR (50),
  `lh_help_context` VARCHAR (50),
  `ts_help_context` VARCHAR (50),
  `hl_help_context` VARCHAR (50),
  `ks_help_context` VARCHAR (50),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建三角理论表
CREATE TABLE IF NOT EXISTS `yhcc_triangle`(
  `id` VARCHAR (50) NOT NULL,
  `contract_id` VARCHAR (50),
  `rent`decimal(18,2),
  `property_fee` decimal(18,2),
  `staff_emp` decimal(18,2),
  `fitment` decimal(18,2),
  `agency_fee` decimal(18,2),
  `profit` decimal(18,2),
  `guest_flow` int(11),
   `sale` decimal(18,2),
   `fitted` int(11),
   `status` VARCHAR (4),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建每日溢租率表
CREATE TABLE IF NOT EXISTS `yhcc_day_rent`(
  `id` VARCHAR (50) NOT NULL,
  `contract_id` VARCHAR (50),
   `moonRentid` VARCHAR (50),
  `rent`decimal(18,2),
  `property_fee` decimal(18,2),
  `staff_emp` decimal(18,2),
  `fitment` decimal(18,2),
  `agency_fee` decimal(18,2),
  `profit` decimal(18,2),
  `status` VARCHAR (4),
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建每月溢租率表
CREATE TABLE IF NOT EXISTS `yhcc_moon_rent`(
  `id` VARCHAR (50) NOT NULL,
  `contract_id` VARCHAR (50),
  `rent_verssion_id` VARCHAR (50),
  `rent` decimal(18,2),
  `property_fee` decimal(18,2),
  `staff_emp` decimal(18,2),
  `fitment` decimal(18,2),
  `agency_fee` decimal(18,2),
  `profit` decimal(18,2),
  `yearsmoon` DATETIME,
  `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建版本溢租率导入表
CREATE TABLE IF NOT EXISTS `yhcc_rent_verssion`(
  `id` VARCHAR (50) NOT NULL,
  `rent_verssion_name` VARCHAR (50) ,
  `sum_target` int(11),
  `targetcount` int(11),
  `untargetcount` int(11),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建版本适配值导入表
CREATE TABLE IF NOT EXISTS `yhcc_fitted_verssion`(
  `id` VARCHAR (50) NOT NULL,
  `fitted_verssion_name` VARCHAR (50) ,
   `temp_id` VARCHAR (50) ,
  `sum_target` int(11),
  `targetcount` int(11),
  `untargetcount` int(11),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建季度适配值表
CREATE TABLE IF NOT EXISTS `yhcc_quarter_fitted`(
  `id` VARCHAR (50) NOT NULL,
  `contract_id` VARCHAR (50),
  `fitted_verssion_id` VARCHAR (50) ,
  `contract_name` VARCHAR (50),
  `project_name` VARCHAR (50),
  `floor_name` VARCHAR (50),
  `room_name` VARCHAR (50),
  `condition_name` VARCHAR (50),
  `majo_name` VARCHAR (50),
  `contract_status` VARCHAR (50),
  `market_position` int(5),
  `brand_position` int(5),
  `brand_image` int(5),
  `rental_rate` decimal(18,2),
  `chain_degree`  decimal(18,2),
  `complaint_degree`decimal(18,2),
  `layout_degree` decimal(18,2),
   `create_time` DATETIME,
   `start_time` DATETIME,
   `end_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建版本客销度导入表
CREATE TABLE IF NOT EXISTS `yhcc_guest_verssion`(
  `id` VARCHAR (50) NOT NULL,
  `guest_verssion_name` VARCHAR (50),
  `sum_target` int(11),
  `targetcount` int(11),
  `untargetcount` int(11),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
  `different` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建每日客销度表
CREATE TABLE IF NOT EXISTS `yhcc_day_guest`(
   `id` VARCHAR (50) NOT NULL,
   `guest_verssion_id` VARCHAR (50),
   `contract_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `floor_name` VARCHAR (50),
   `room_name` VARCHAR (50),
   `contract_name` VARCHAR (50),
   `condition_name` VARCHAR (50),
   `majo_name` VARCHAR (50),
  `passenger_flow`  decimal(18,2),
  `saleroom`  decimal(18,2),
  `profits`  decimal(18,2),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目客销度表
CREATE TABLE IF NOT EXISTS `yhcc_project_guest`(
   `id` VARCHAR (50) NOT NULL,
   `guest_verssion_id` VARCHAR (50),
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
  `passenger_flow`  decimal(18,2),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建楼层客销度表
CREATE TABLE IF NOT EXISTS `yhcc_floor_guest`(
   `id` VARCHAR (50) NOT NULL,
   `guest_verssion_id` VARCHAR (50),
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
    `floor_id` VARCHAR (50),
   `floor_name` VARCHAR (50),
  `passenger_flow`  decimal(18,2),
   `create_time` DATETIME,
  `modify_time` DATETIME,
  `create_user` VARCHAR (100),
  `modify_user` VARCHAR (100),
  `status` VARCHAR (4),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建项目客销度区间设置表
CREATE TABLE IF NOT EXISTS `yhcc_project_guest_interval`(
   `id` VARCHAR (50) NOT NULL,
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `maxvalue` decimal(18,2),
   `interval_rate` decimal(18,2),
   `yx` int(11),
   `lh` int(11),
   `ts` int(11),
   `hl` int(11),
   `ks` int(11),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建楼层客销度区间设置表
CREATE TABLE IF NOT EXISTS `yhcc_floor_guest_interval`(

  `id` VARCHAR (50) NOT NULL,
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
    `floor_id` VARCHAR (50),
   `floor_name` VARCHAR (50),
   `maxvalue` decimal(18,2),
   `interval_rate` decimal(18,2),
   `yx` int(11),
   `lh` int(11),
   `ts` int(11),
   `hl` int(11),
   `ks` int(11),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建业态客销度区间设置表
CREATE TABLE IF NOT EXISTS `yhcc_condition_guest_interval`(
  `id` VARCHAR (50) NOT NULL,
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `condition_id` VARCHAR (50),
   `condition_name` VARCHAR (50),
   `majo_id` VARCHAR (50),
   `majo_name` VARCHAR (50),
   `maxvalue` decimal(18,2),
   `interval_rate` decimal(18,2),
   `yx` int(11),
   `lh` int(11),
   `ts` int(11),
   `hl` int(11),
   `ks` int(11),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形项目溢租率设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_project_rent`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `rant` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
   `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建标准三角形楼层溢租率设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_floor_rent`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `floor_id` VARCHAR (50),
   `floor_name` VARCHAR (50),
   `rant` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
     `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形业态溢租率设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_condition_rent`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `condition_id` VARCHAR (50),
   `condition_name` VARCHAR (50),
   `majo_id` VARCHAR (50),
   `majo_name` VARCHAR (50),
   `rant` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
     `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形项目适配值设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_project_fitted`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `fitted` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
   `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建标准三角形楼层适配值设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_floor_fitted`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `floor_id` VARCHAR (50),
   `floor_name` VARCHAR (50),
   `fitted` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
     `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形业态适配值设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_condition_fitted`(
  `id` VARCHAR (50) NOT NULL,
   `standard_verssion_id` VARCHAR (50),
   `standard_verssion_name` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `condition_id` VARCHAR (50),
   `condition_name` VARCHAR (50),
   `majo_id` VARCHAR (50),
   `majo_name` VARCHAR (50),
   `fitted` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
     `status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建标准三角形品牌客销度设置表
CREATE TABLE IF NOT EXISTS `yhcc_standard_condition_sale`(
  `id` VARCHAR (50) NOT NULL,
  `sale_verssion_id` VARCHAR (50),
   `sale_verssion_name` VARCHAR (50),
   `contract_id` VARCHAR (50),
   `project_id` VARCHAR (50),
   `project_name` VARCHAR (50),
   `contract_name` VARCHAR (50),
   `condition_id` VARCHAR (50),
   `condition_name` VARCHAR (50),
   `majo_id` VARCHAR (50),
   `majo_name` VARCHAR (50),
   `gross_rate` int (4),
   `per_sale` int (4),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   `create_user` VARCHAR (100),
   `modify_user` VARCHAR (100),
   `sign_status` VARCHAR (4),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;