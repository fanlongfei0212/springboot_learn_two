-- 初始化角色基础数据
INSERT IGNORE INTO
  `yhcc_role`
VALUES
  ('e8314e6c86f946cb8b6afff421eaff6c', '总经理', NOW(), NOW(), 'system', 'system'),
  ('0cf542a6cc4147c7b271eba9155bd4f1', '副总', NOW(), NOW(), 'system', 'system'),
  ('d7d079a76ee34b7aa75da2822e5e8af7', '运营总监', NOW(), NOW(), 'system', 'system'),
  ('3efe2c6f9be1414abc0e8055e5f2f921', '运营经理', NOW(), NOW(), 'system', 'system'),
  ('f9b2507440754264885f99946bfde304', '主管', NOW(), NOW(), 'system', 'system');

-- 初始化菜单基础数据
INSERT IGNORE INTO
  `yhcc_menu`
VALUES
  ('ab554862cec74ce3bbdb209e067ee28c', '首页', 1, NULL , 'ONE', '/index' , 1, NOW(), NOW(), 'system', 'system'),
  ('ea78156548304912ba15866769f8232c', '项目管理', 1, NULL , 'ONE', '/projecManage' , 2, NOW(), NOW(), 'system', 'system'),
  ('3ac1e9409a59421d8aab463b8042279a', '品牌管理', 1, NULL , 'ONE', '/indicatorsManage' , 3, NOW(), NOW(), 'system', 'system'),
  ('2fe2ed895194421a8abdb21c9a41ebfa', '签约管理', 1, NULL , 'ONE', '/qianyue' , 4, NOW(), NOW(), 'system', 'system'),
  ('708f1224ef3c4c4d836321134cc071b1', '数据管理', 1, NULL , 'ONE', '/dataManage' , 5, NOW(), NOW(), 'system', 'system'),
  ('db34210cc50041848195a0f7e052f9aa', '帮扶计划', 1, NULL , 'ONE', '/evaluationTpl' , 6, NOW(), NOW(), 'system', 'system'),
  ('97412ee91385480c97125dd9ff020007', '评估模板', 1, NULL , 'ONE', '/organizationStructure' , 7, NOW(), NOW(), 'system', 'system'),
  ('44201603df904c3890932bda1863cfa1', '系统平台', 1, NULL , 'ONE', '/dataDictionary' , 8, NOW(), NOW(), 'system', 'system'),
  ('64e85b403de347eeba2126c9e22aad14', '项目管理', 0, 'ea78156548304912ba15866769f8232c', 'TOW', '/projecManage/projec/list', 1, NOW(), NOW(), 'system', 'system'),
  ('a5055ee8b4154c79bf889e024346a930', '楼层管理', 0, 'ea78156548304912ba15866769f8232c', 'TOW', '/projecManage/floor/list', 2, NOW(), NOW(), 'system', 'system'),
  ('7988cfe210ff4959a3d0ec106e0eff87', '铺位管理', 0, 'ea78156548304912ba15866769f8232c', 'TOW', '/projecManage/store/list', 3, NOW(), NOW(), 'system', 'system'),
  ('3c575f3b36614496b52d714685e87929', '品牌管理', 0, '3ac1e9409a59421d8aab463b8042279a', 'TOW', '/indicatorsManage/indicators/list', 1, NOW(), NOW(), 'system', 'system'),
  ('f7f3be432ac24846926805951d634cab', '签约管理', 0, '2fe2ed895194421a8abdb21c9a41ebfa', 'TOW', '/qianyue/qianyue/list', 1, NOW(), NOW(), 'system', 'system'),
  ('7842e7a34c2443ceae25beb817b7339b', '三角理论', 0, '2fe2ed895194421a8abdb21c9a41ebfa', 'TOW', '/qianyue/sanjiao/list', 2, NOW(), NOW(), 'system', 'system'),
  ('6343dbdcc70041b1a909d73f76ec3d02', '动态三角形', 0, '708f1224ef3c4c4d836321134cc071b1', 'TOW', '/dataManage/dongtai/list', 1, NOW(), NOW(), 'system', 'system'),
  ('6d020f29d8f5433a9a6da556c9602fba', '标准三角形', 0, '708f1224ef3c4c4d836321134cc071b1', 'TOW', '/dataManage/version/list', 2, NOW(), NOW(), 'system', 'system'),
  ('1be992713572491290b01405ac1109d0', '区间设置', 0, '708f1224ef3c4c4d836321134cc071b1', 'TOW', '/dataManage/trigonometric/list', 3, NOW(), NOW(), 'system', 'system'),
  ('b7bf1e92f22149c19f8ec08c9b90dbee', '数据维护', 0, '708f1224ef3c4c4d836321134cc071b1', 'TOW', '/dataManage/shuju/list', 4, NOW(), NOW(), 'system', 'system'),
  ('ea9b25a1cf364b7cb4d106baa5ecafcb', '项目帮扶', 0, 'db34210cc50041848195a0f7e052f9aa', 'TOW', '/evaluationTpl/template/list', 1, NOW(), NOW(), 'system', 'system'),
  ('59b00750e02241f6b8760b29603591b4', '楼层帮扶', 0, 'db34210cc50041848195a0f7e052f9aa', 'TOW', '/evaluationTpl/evaluation/list', 2, NOW(), NOW(), 'system', 'system'),
  ('d8a27eb4345a47e8a14ff949c2ccf771', '业种帮扶', 0, 'db34210cc50041848195a0f7e052f9aa', 'TOW', '/evaluationTpl/yetaibangfu/list', 3, NOW(), NOW(), 'system', 'system'),
  ('e0c5732abc2f4b7bbe38fb3f64ebe0f6', '帮扶内容', 0, 'db34210cc50041848195a0f7e052f9aa', 'TOW', '/evaluationTpl/bangfuneirong/list', 4, NOW(), NOW(), 'system', 'system'),
  ('6c2718fc72124c61a118f39553baf07b', '模板管理', 0, '97412ee91385480c97125dd9ff020007', 'TOW', '/organizationStructure/organization/list', 1, NOW(), NOW(), 'system', 'system'),
  ('29280b8fd1424f838561384b36ba6b58', '业态管理', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/brand/list', 1, NOW(), NOW(), 'system', 'system'),
  ('a0a59134ad2f46db9caa899223d1e660', '业种管理', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/formats/list', 2, NOW(), NOW(), 'system', 'system'),
  ('ad7650125def45219731e3e96333e1c6', '适配值', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/megabite/list', 3, NOW(), NOW(), 'system', 'system'),
  ('88b932284366429db27ba95ece901b19', '区间公司', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/qujiangongsi/list', 4, NOW(), NOW(), 'system', 'system'),
  ('83d493362c4c408b809526ad2d54a4b2', '组织管理', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/zuzhiguanli/list', 5, NOW(), NOW(), 'system', 'system'),
  ('53e40db2e67242ad8863afc4303426e4', '人员管理', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/renyuanguanli/list', 6, NOW(), NOW(), 'system', 'system'),
  ('a460c19404774f8a98af51a1af86ff4a', '角色管理', 0, '44201603df904c3890932bda1863cfa1', 'TOW', '/dataDictionary/jueseguanli/list', 7, NOW(), NOW(), 'system', 'system');

-- 初始化角色菜单关系基础数据(切记，如果客户修改了默认的角色菜单关系，会导致的问题：项目重新启动时会将所有角色的菜单进行所有菜单补全，第一次以后的测试以及生产环境将这段脚本进行注释)
INSERT IGNORE INTO
  `yhcc_role_menu_relation`
VALUES
-- 总经理角色菜单权限，默认拥有所有权限
  ('169217d17ed14283b9d3f7a35cb99f36', 'e8314e6c86f946cb8b6afff421eaff6c', 'ab554862cec74ce3bbdb209e067ee28c', NOW(), NOW(), 'system', 'system'),
  ('c6a28646492e42be80454dcd054322f0', 'e8314e6c86f946cb8b6afff421eaff6c', 'ea78156548304912ba15866769f8232c', NOW(), NOW(), 'system', 'system'),
  ('478e9b6958a24570a09eef747e37668a', 'e8314e6c86f946cb8b6afff421eaff6c', '3ac1e9409a59421d8aab463b8042279a', NOW(), NOW(), 'system', 'system'),
  ('81def6165c804b48a691f9041498db06', 'e8314e6c86f946cb8b6afff421eaff6c', '2fe2ed895194421a8abdb21c9a41ebfa', NOW(), NOW(), 'system', 'system'),
  ('93f85f9c71774980a2377ef9a65c4dfe', 'e8314e6c86f946cb8b6afff421eaff6c', '708f1224ef3c4c4d836321134cc071b1', NOW(), NOW(), 'system', 'system'),
  ('fa1a49c857074113b33305af8b485093', 'e8314e6c86f946cb8b6afff421eaff6c', 'db34210cc50041848195a0f7e052f9aa', NOW(), NOW(), 'system', 'system'),
  ('b02dcd8a53d540bda0cde2a149771a76', 'e8314e6c86f946cb8b6afff421eaff6c', '97412ee91385480c97125dd9ff020007', NOW(), NOW(), 'system', 'system'),
  ('41ab244256984329992152f8cbeaba90', 'e8314e6c86f946cb8b6afff421eaff6c', '44201603df904c3890932bda1863cfa1', NOW(), NOW(), 'system', 'system'),
-- 副总角色菜单权限，默认拥有所有权限
  ('4b64e4cf240f48919f37b6557f72ab96', '0cf542a6cc4147c7b271eba9155bd4f1', 'ab554862cec74ce3bbdb209e067ee28c', NOW(), NOW(), 'system', 'system'),
  ('4255838017f24a1eba2375930d138faa', '0cf542a6cc4147c7b271eba9155bd4f1', 'ea78156548304912ba15866769f8232c', NOW(), NOW(), 'system', 'system'),
  ('a6aa057a36f14dacb54ded157288fb1c', '0cf542a6cc4147c7b271eba9155bd4f1', '3ac1e9409a59421d8aab463b8042279a', NOW(), NOW(), 'system', 'system'),
  ('c5263ac900f84593a740fac2ec946190', '0cf542a6cc4147c7b271eba9155bd4f1', '2fe2ed895194421a8abdb21c9a41ebfa', NOW(), NOW(), 'system', 'system'),
  ('7e69b1ec590f46dc8c4b4f920a4c7dad', '0cf542a6cc4147c7b271eba9155bd4f1', '708f1224ef3c4c4d836321134cc071b1', NOW(), NOW(), 'system', 'system'),
  ('677b488a109b4bbd9e8823c04a100f71', '0cf542a6cc4147c7b271eba9155bd4f1', 'db34210cc50041848195a0f7e052f9aa', NOW(), NOW(), 'system', 'system'),
  ('e1d49480e3054e1b95a7f60aadcd7568', '0cf542a6cc4147c7b271eba9155bd4f1', '97412ee91385480c97125dd9ff020007', NOW(), NOW(), 'system', 'system'),
  ('26c1eb4dcf7349a8b20a56723cabdfe7', '0cf542a6cc4147c7b271eba9155bd4f1', '44201603df904c3890932bda1863cfa1', NOW(), NOW(), 'system', 'system'),
-- 运营总监角色菜单权限，默认拥有所有权限
  ('f729460e387142e68ed36d1c3b6617f6', 'd7d079a76ee34b7aa75da2822e5e8af7', 'ab554862cec74ce3bbdb209e067ee28c', NOW(), NOW(), 'system', 'system'),
  ('3ecb944d1f8b4f1c8d103d828802b45a', 'd7d079a76ee34b7aa75da2822e5e8af7', 'ea78156548304912ba15866769f8232c', NOW(), NOW(), 'system', 'system'),
  ('cb30b814bae0491f9edfad18773125bd', 'd7d079a76ee34b7aa75da2822e5e8af7', '3ac1e9409a59421d8aab463b8042279a', NOW(), NOW(), 'system', 'system'),
  ('36024979437d4b58a51ea16c1ba2a998', 'd7d079a76ee34b7aa75da2822e5e8af7', '2fe2ed895194421a8abdb21c9a41ebfa', NOW(), NOW(), 'system', 'system'),
  ('b7e1818f4f3f4b1993b8ef9dbba1a6fb', 'd7d079a76ee34b7aa75da2822e5e8af7', '708f1224ef3c4c4d836321134cc071b1', NOW(), NOW(), 'system', 'system'),
  ('f5366b41d7ce4ff8b32a23820d556710', 'd7d079a76ee34b7aa75da2822e5e8af7', 'db34210cc50041848195a0f7e052f9aa', NOW(), NOW(), 'system', 'system'),
  ('4de473b6d95549059d80d21a83ef21fe', 'd7d079a76ee34b7aa75da2822e5e8af7', '97412ee91385480c97125dd9ff020007', NOW(), NOW(), 'system', 'system'),
  ('728f4394067943c79689f1d5e50cadef', 'd7d079a76ee34b7aa75da2822e5e8af7', '44201603df904c3890932bda1863cfa1', NOW(), NOW(), 'system', 'system'),
-- 运营经理角色菜单权限，默认拥有所有权限
  ('ae690721212c46d6ade8c9a3a7774d6e', '3efe2c6f9be1414abc0e8055e5f2f921', 'ab554862cec74ce3bbdb209e067ee28c', NOW(), NOW(), 'system', 'system'),
  ('f84686cf28844459ac0bcb4a2a3f716f', '3efe2c6f9be1414abc0e8055e5f2f921', 'ea78156548304912ba15866769f8232c', NOW(), NOW(), 'system', 'system'),
  ('edc1a35da19946af905288321db715b7', '3efe2c6f9be1414abc0e8055e5f2f921', '3ac1e9409a59421d8aab463b8042279a', NOW(), NOW(), 'system', 'system'),
  ('3e06dd9d45e34533b4f700d8e42d80b3', '3efe2c6f9be1414abc0e8055e5f2f921', '2fe2ed895194421a8abdb21c9a41ebfa', NOW(), NOW(), 'system', 'system'),
  ('5f9b47309f0b4967a50ce901fca2f8be', '3efe2c6f9be1414abc0e8055e5f2f921', '708f1224ef3c4c4d836321134cc071b1', NOW(), NOW(), 'system', 'system'),
  ('b50908e4a725444e9677516208db000e', '3efe2c6f9be1414abc0e8055e5f2f921', 'db34210cc50041848195a0f7e052f9aa', NOW(), NOW(), 'system', 'system'),
  ('416452871c4e4452a4266ef21e27db4c', '3efe2c6f9be1414abc0e8055e5f2f921', '97412ee91385480c97125dd9ff020007', NOW(), NOW(), 'system', 'system'),
  ('7349fa7e4f4b49359c31492e5480f988', '3efe2c6f9be1414abc0e8055e5f2f921', '44201603df904c3890932bda1863cfa1', NOW(), NOW(), 'system', 'system'),
-- 主管角色菜单权限，默认拥有所有权限
  ('1f6dd72b317d4e27ba7171de0fbe24f4', 'f9b2507440754264885f99946bfde304', 'ab554862cec74ce3bbdb209e067ee28c', NOW(), NOW(), 'system', 'system'),
  ('497b33e0b68b4c04b7398cb2ced9aada', 'f9b2507440754264885f99946bfde304', 'ea78156548304912ba15866769f8232c', NOW(), NOW(), 'system', 'system'),
  ('7b61d677a454482c968aa217791c94e9', 'f9b2507440754264885f99946bfde304', '3ac1e9409a59421d8aab463b8042279a', NOW(), NOW(), 'system', 'system'),
  ('d17422a3f07145c1bb28375e6ba9ebf0', 'f9b2507440754264885f99946bfde304', '2fe2ed895194421a8abdb21c9a41ebfa', NOW(), NOW(), 'system', 'system'),
  ('63087a797e1c41ac893d7b65190d9588', 'f9b2507440754264885f99946bfde304', '708f1224ef3c4c4d836321134cc071b1', NOW(), NOW(), 'system', 'system'),
  ('cde4b0f647934bf78bed5e6b567f3037', 'f9b2507440754264885f99946bfde304', 'db34210cc50041848195a0f7e052f9aa', NOW(), NOW(), 'system', 'system'),
  ('d9e4835ed7c44e20a77ec98b33a74590', 'f9b2507440754264885f99946bfde304', '97412ee91385480c97125dd9ff020007', NOW(), NOW(), 'system', 'system'),
  ('aee432116bbe41d98e7027aa9a808474', 'f9b2507440754264885f99946bfde304', '44201603df904c3890932bda1863cfa1', NOW(), NOW(), 'system', 'system');

-- 初始化超级管理员数据
INSERT IGNORE INTO
  `yhcc_employee`
VALUES
  ('1', 'YHCC_EMP_ADMIN', '超级管理员', '-----------' , '', 'admincc', 'admincc', 1, 1, '', NOW(), NOW(), 'system', 'system');

-- 初始化超级管理员角色数据
INSERT IGNORE INTO
  `yhcc_employee_role_relation`
VALUES
  ('b71234c3e8ea4eada16478f7f03ccfe3', '1', 'e8314e6c86f946cb8b6afff421eaff6c', NOW(), NOW(), 'system', 'system'),
  ('3887161d5fb6457e9b4072058b1b2060', '1', '0cf542a6cc4147c7b271eba9155bd4f1', NOW(), NOW(), 'system', 'system'),
  ('888a651f99bf45789c6260b06b277717', '1', 'd7d079a76ee34b7aa75da2822e5e8af7', NOW(), NOW(), 'system', 'system'),
  ('7683a68b357a4578bcc6d026a6d0fbb6', '1', '3efe2c6f9be1414abc0e8055e5f2f921', NOW(), NOW(), 'system', 'system'),
  ('ae6a525b4420402390276999c4b13f12', '1', 'f9b2507440754264885f99946bfde304', NOW(), NOW(), 'system', 'system');

-- 初始化区域数据
INSERT IGNORE INTO
  `yhcc_area`
VALUES
  ('faeb3a0f47ec4c03aee01c5b524c537f', 'YHCC_AREA_7da8d8fe8f8644df8a8ce7d8ede0b625', '总部', 1, NOW(), NOW(), 'system', 'system'),
  ('33555d2bec0f4cd699f0d56463158c95', 'YHCC_AREA_42882f3e82cb415d9398117ccf7855e2', '华北区', 2, NOW(), NOW(), 'system', 'system'),
  ('fab4934d231c494c98e9c76fbbcb670b', 'YHCC_AREA_2b76222461074fb79482605e1451b2c5', '华中区', 2, NOW(), NOW(), 'system', 'system'),
  ('51a170905b434292b5426f34f116ad4e', 'YHCC_AREA_012ef1c9c22b4402a8d50233dc1edb63', '华东区', 2, NOW(), NOW(), 'system', 'system'),
  ('20f2423ac5134958a2f542598773410c', 'YHCC_AREA_1977ce264c004a0081d7c9e24d374cf0', '华南区', 2, NOW(), NOW(), 'system', 'system'),
  ('3084d4354b94435aaae659cca7b8ff08', 'YHCC_AREA_e98dd26f6cbe48d3b4b832d229576b0e', '华西北区', 2, NOW(), NOW(), 'system', 'system'),
  ('1571735ab0eb4e5a8c391755d38f4e9a', 'YHCC_AREA_6dc012e720d44788b45413b6aa90b3bc', '华西南区', 2, NOW(), NOW(), 'system', 'system');

-- 初始化城市数据
INSERT IGNORE INTO
  `yhcc_city`
VALUES
  ('517201a5ca5d46e98efc1e850897a639', 'YHCC_CITY_cc8148fac52e4f80a6ab4ea18c7e1e20', '河北省', NOW(), NOW(), 'system', 'system'),
  ('05445ce310ab4d229e36ee0f82d324ab', 'YHCC_CITY_8acc57ab1d2c4f9495c3f42e895f5f42', '山东省', NOW(), NOW(), 'system', 'system'),
  ('a8421ecdfe114f78ae616e112870f782', 'YHCC_CITY_200700341b6b413788b97dbb889a2de5', '辽宁省', NOW(), NOW(), 'system', 'system'),
  ('a44b1566634845b2a0c3442cd38fd775', 'YHCC_CITY_7a173455f34f4e40ba899a17b855ba19', '黑龙江省', NOW(), NOW(), 'system', 'system'),
  ('696af527c2554175907d576a6d83fa38', 'YHCC_CITY_357a9e6a568a41a7877d03803e56a604', '吉林省', NOW(), NOW(), 'system', 'system'),
  ('83c44c746f2e4a3a8b3e249f18dae0ce', 'YHCC_CITY_5e645893276c42a0a46b0aab245525bb', '甘肃省', NOW(), NOW(), 'system', 'system'),
  ('c754fef9585445bea333cb9fe0cf34b6', 'YHCC_CITY_f0d378efa392492fa015e5b89ca27eaa', '青海省', NOW(), NOW(), 'system', 'system'),
  ('1d45d1189e9d4fb883f6905b4fe44fac', 'YHCC_CITY_3f24818790e646f09a4e43213104e6bd', '河南省', NOW(), NOW(), 'system', 'system'),
  ('7079d076fc0947ad85f1ff67dcd91808', 'YHCC_CITY_bf97f54f3c7245cd9cf3acb3f74b9a21', '江苏省', NOW(), NOW(), 'system', 'system'),
  ('51075ad2fbc64955a047a044f4d43ee8', 'YHCC_CITY_e9390f793a484b05a8d8fad656fb02c4', '湖北省', NOW(), NOW(), 'system', 'system'),
  ('4ab81554af4f47d9ac1a1e0726921a36', 'YHCC_CITY_3d53763378df4788b61fd8a174cef171', '湖南省', NOW(), NOW(), 'system', 'system'),
  ('ebfda05722e54e438b71838f4372e5b3', 'YHCC_CITY_87c34207acce476cbdb4712d59872ebd', '江西省', NOW(), NOW(), 'system', 'system'),
  ('5d7bbb96df7a423d9b6667f1d939f9df', 'YHCC_CITY_599cab9be3a742e0bf3e43ed392c4320', '浙江省', NOW(), NOW(), 'system', 'system'),
  ('1a5cd03193524c10bc0a81eea535dd98', 'YHCC_CITY_6fb5c9f729fb4fd789ca51d004bc2a44', '广东省', NOW(), NOW(), 'system', 'system'),
  ('f8271ee817a34b54ac0e53a6366bb712', 'YHCC_CITY_84b26bf83d0d49f0b003f631749b2be9', '云南省', NOW(), NOW(), 'system', 'system'),
  ('562fb30717224d8889d6b7266f6f5fc4', 'YHCC_CITY_a2bc7062f4ed4278bb88222fb5501338', '福建省', NOW(), NOW(), 'system', 'system'),
  ('371e4f06cd7145a88d609cf747bdc034', 'YHCC_CITY_6eda9b2b6af744f685b2a09650df9672', '台湾省', NOW(), NOW(), 'system', 'system'),
  ('f8ea89adfd68497db38a1a2798d0dd73', 'YHCC_CITY_00587334af2745eb81f6c8941d5ee7c4', '海南省', NOW(), NOW(), 'system', 'system'),
  ('ddb5ee723583424f871e44bc417a6d9f', 'YHCC_CITY_6cb3dbbc87344a4c89a206d303f31e1e', '山西省', NOW(), NOW(), 'system', 'system'),
  ('4b82e71bf20746a18c953804abeaeefc', 'YHCC_CITY_fcb6fba440384737936bc092bc520421', '四川省', NOW(), NOW(), 'system', 'system'),
  ('ae94ab8c57454f37a46e59e1a09121a3', 'YHCC_CITY_32f9902f4bf84561a1c1a8fc2a9774b7', '陕西省', NOW(), NOW(), 'system', 'system'),
  ('498e325f3c834c7bae9e4432c3988cfd', 'YHCC_CITY_68c650c9853f47609adfa529900bdbe4', '贵州省', NOW(), NOW(), 'system', 'system'),
  ('2e073bb67b6040d9b99f60b7c3b805b3', 'YHCC_CITY_82973d94ef6d4db09da6bf8b4355a078', '安徽省', NOW(), NOW(), 'system', 'system'),
  ('92542bbff0444f1096e3b7549f621dd0', 'YHCC_CITY_18d9464360fd4560a48be2d532d6112b', '重庆市', NOW(), NOW(), 'system', 'system'),
  ('57bd63597e3643ff8712b71ce286f2f7', 'YHCC_CITY_39d2b30e4c7d40848826cfa7172a0bb4', '北京市', NOW(), NOW(), 'system', 'system'),
  ('7b5c4346a28b4d33b0251bf31109a6ca', 'YHCC_CITY_e593ba5ccff6479b9e0e067db37a8efe', '上海市', NOW(), NOW(), 'system', 'system'),
  ('bd5e4ead829a4125b9431424e849172f', 'YHCC_CITY_43c09ddaeb14471198e4ec6dc7aba8e0', '天津市', NOW(), NOW(), 'system', 'system'),
  ('af3105a8e2cc48148fa2d45d113d87a4', 'YHCC_CITY_5ed71dfe68004511bb2c2270aba55a2a', '广西壮族自治区', NOW(), NOW(), 'system', 'system'),
  ('2db9e3830698455c9de1c9eda8010deb', 'YHCC_CITY_d91eb6134ab0439e92edaa2198f6e427', '内蒙古自治区', NOW(), NOW(), 'system', 'system'),
  ('4d1a1cc438f048a88d462d3f6f813933', 'YHCC_CITY_e298d8167e234478b01c8e569e66ddf5', '西藏自治区', NOW(), NOW(), 'system', 'system'),
  ('2f36239760cb4fe68a585d96af66c628', 'YHCC_CITY_3a95b7da589941ba84427c236c8c9d79', '新疆维吾尔自治区', NOW(), NOW(), 'system', 'system'),
  ('f59acf8861b446c3a1fbb2dd58f64de5', 'YHCC_CITY_eabab378e42e4ab9b92c9fe618fce085', '宁夏回族自治区', NOW(), NOW(), 'system', 'system'),
  ('6536cfb1452a4e859527ce7d795d87a7', 'YHCC_CITY_9b5262d254f6447a8deb84744c724662', '澳门特别行政区', NOW(), NOW(), 'system', 'system'),
  ('7c63acc50cf14fb59bd7d252bc80a764', 'YHCC_CITY_1e9c04052b124daf9e2e7bfe11eff632', '香港特别行政区', NOW(), NOW(), 'system', 'system');