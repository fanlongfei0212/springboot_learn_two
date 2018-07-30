package com.yinghuaicc.stars.service.permission;

import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.repository.mapper.permission.PermissionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.model.permission.Menu;
import com.yinghuaicc.stars.repository.model.permission.Role;
import com.yinghuaicc.stars.repository.model.permission.RoleMenuRelation;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeRoleRelation;
import com.yinghuaicc.stars.service.permission.dto.request.ConfRoleMenuRequestDTO;
import com.yinghuaicc.stars.service.permission.dto.request.PackagingConfRoleMenuRequestDTO;
import com.yinghuaicc.stars.service.permission.dto.response.EmployeeRoleResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.LoginMenuResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.RoleAllMenuResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.RoleAllResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午10:20
 * @Description: 权限服务
 * @Modified:
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    /**
     *@Author:Fly Created in 2018/6/27 下午11:23
     *@Description: 查询员工登录菜单
     */
    @Override
    public List<LoginMenuResponseDTO> loginMenus(String employeeId) {

        //超级管理员拥有所有菜单
        if ("1".equals(employeeId)){

            return this.menuAll();
        }

        //获取员工角色
        List<EmployeeRoleRelation> employeeRoleRelations = tissueMapper.findEmployeeRoleRelationByEmployeeId(employeeId);

        if (Objects.isNull(employeeRoleRelations)||employeeRoleRelations.size()==0){

            throw exceptionUtil.throwCustomException("PERMISSION_LOGINMENUS_001");
        }

        //获取角色菜单
        List<RoleMenuRelation> roleMenuRelations =
                permissionMapper.findRoleMenuRelationByRoleId(
                        employeeRoleRelations
                                .stream().map(EmployeeRoleRelation::getRoleId).collect(Collectors.toList())
                                .stream().distinct().collect(Collectors.toList()));

        if (Objects.isNull(roleMenuRelations)||roleMenuRelations.size()==0){

            throw exceptionUtil.throwCustomException("PERMISSION_LOGINMENUS_002");
        }

        //获取所有权限的菜单完整信息
        List<Menu> PermissionMenus =
                permissionMapper.findMenuByMenuId(
                        roleMenuRelations
                                .stream().map(RoleMenuRelation::getMenuId).collect(Collectors.toList())
                                .stream().distinct().collect(Collectors.toList()));

        //获取所有菜单
        List<Menu> menuAll = permissionMapper.findMenuAll();

        return this.menuSort(this.confMenus(PermissionMenus, menuAll));
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午1:54
     *@Description: 查询员工角色
     */
    @Override
    public List<EmployeeRoleResponseDTO> employeeRole(String employeeId) {

        List<String> roleId =
                tissueMapper.findEmployeeRoleRelationByEmployeeId(employeeId)
                        .stream().map(role -> role.getRoleId()).collect(Collectors.toList());
        return Objects.isNull(roleId)||roleId.size()==0
                ?
                null
                :
                MapperFactoryUtil.mapperList(permissionMapper.findRoleByEmployeeId(roleId), EmployeeRoleResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午3:31
     *@Description: 查询所有角色
     */
    @Override
    public List<RoleAllResponseDTO> roleAll() {

        return MapperFactoryUtil.mapperList(permissionMapper.findRoleAll(), RoleAllResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午4:46
     *@Description: 查询所有菜单信息，返回树形结构
     */
    @Override
    public List<LoginMenuResponseDTO> menuAll() {

        List<Menu> allMenu = permissionMapper.findMenuAll();

        List<LoginMenuResponseDTO> resultMenuTree = new ArrayList<LoginMenuResponseDTO>();

        allMenu.stream()
                .filter(menu -> menu.isRoot()&&StringUtils.isEmpty(menu.getParentId())).collect(Collectors.toList())
                .stream().forEach(menu -> {

            resultMenuTree.add(new LoginMenuResponseDTO()
                    .setId(menu.getId())
                    .setMenuType(menu.getMenuType())
                    .setName(menu.getName())
                    .setRoot(menu.isRoot())
                    .setUrl(menu.getUrl())
                    .setParentId(menu.getParentId())
                    .setSort(menu.getSort())
                    .setCreateTime(menu.getCreateTime())
                    .setModifyTime(menu.getModifyTime())
                    .setCreateUser(menu.getCreateUser())
                    .setModifyUser(menu.getModifyUser())
                    .setChildMenus(getChild(allMenu, menu.getId())));

        });

        return this.menuSort(resultMenuTree);
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午4:38
     *@Description: 所有角色菜单信息，返回菜单树
     */
    @Override
    public List<RoleAllMenuResponseDTO> roleAllMenu() {

        List<RoleAllMenuResponseDTO> result = new ArrayList<RoleAllMenuResponseDTO>();

        permissionMapper.findRoleAll().stream().forEach(role -> {

            RoleAllMenuResponseDTO roleAllMenuResponseDTO = new RoleAllMenuResponseDTO()
                    .setRoleId(role.getId())
                    .setRoleName(role.getName());

            List<RoleMenuRelation> roleMenuRelation =
                    permissionMapper.findRoleMenuRelationByRoleId(Stream.of(role.getId()).collect(Collectors.toList()));

            if (Objects.nonNull(roleMenuRelation)&&roleMenuRelation.size()>0){

                roleAllMenuResponseDTO.setMenuTree(
                        this.confMenus(
                                permissionMapper.findMenuByMenuId(
                                        roleMenuRelation.stream().map(RoleMenuRelation::getMenuId).collect(Collectors.toList())), permissionMapper.findMenuAll()));
            }

            result.add(roleAllMenuResponseDTO);

        });

        result.stream().forEach(roleAllMenuResponseDTO -> {

            this.menuSort(roleAllMenuResponseDTO.getMenuTree());
        });

        return result;
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午6:04
     *@Description: 设置角色菜单
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void confRoleMenu(PackagingConfRoleMenuRequestDTO packagingConfRoleMenuRequestDTO, String loginEmployeeId) {

        if (packagingConfRoleMenuRequestDTO.getRoleMenus().size()==0){

            throw exceptionUtil.throwCustomException("PERMISSION_CONF_ROLE_MENU_003");
        }

        packagingConfRoleMenuRequestDTO.getRoleMenus().stream().forEach(confRoleMenuRequestDTO -> {

            if (Objects.isNull(confRoleMenuRequestDTO.getMenuIds())||confRoleMenuRequestDTO.getMenuIds().size()==0){

                throw exceptionUtil.throwCustomException("PERMISSION_CONF_ROLE_MENU_002");
            }

            if (StringUtils.isEmpty(confRoleMenuRequestDTO.getRoleId())){

                throw exceptionUtil.throwCustomException("PERMISSION_CONF_ROLE_MENU_001");
            }
        });

        List<ConfRoleMenuRequestDTO> confRoleMenuRequestDTOs = packagingConfRoleMenuRequestDTO.getRoleMenus();

        //删除原角色菜单
        permissionMapper.removeRoleMenuRelationByRoleId(
                confRoleMenuRequestDTOs.stream().map(ConfRoleMenuRequestDTO::getRoleId).collect(Collectors.toList()));

        //设置角色菜单
        List<RoleMenuRelation> roleMenuRelations = new ArrayList<RoleMenuRelation>();

        confRoleMenuRequestDTOs.stream().forEach(confRoleMenuRequestDTO -> {

            confRoleMenuRequestDTO.getMenuIds().stream().forEach(menuId -> {

                roleMenuRelations.add(
                        new RoleMenuRelation()
                                .setId(UuidUtil.randomUUID())
                                .setRoleId(confRoleMenuRequestDTO.getRoleId())
                                .setMenuId(menuId)
                                .setCreateUser(loginEmployeeId)
                                .setModifyUser(loginEmployeeId)
                                .setCreateTime(LocalDateTime.now())
                                .setModifyTime(LocalDateTime.now()));
            });
        });

        permissionMapper.saveRoleMenuRelation(roleMenuRelations);

    }

    /**
     *@Author:Fly Created in 2018/7/5 下午2:12
     *@Description: 添加角色信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRole(String roleName, String loginEmployeeId) {

        permissionMapper.saveRole(
                new Role()
                        .setId(UuidUtil.randomUUID())
                        .setName(roleName)
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午5:57
     *@Description: 某一角色菜单
     */
    @Override
    public List<RoleAllMenuResponseDTO> roleMenu(String id) {

        return this.roleAllMenu().stream().filter(roleAllMenuResponseDTO -> roleAllMenuResponseDTO.getRoleId().equals(id)).collect(Collectors.toList());
    }

    /**
     *@Author:Fly Created in 2018/6/28 上午12:22
     *@Description: 配置菜单，将获取的父级菜单进行子级菜单查询，并组装成树形结构
     */
    private List<LoginMenuResponseDTO> confMenus(List<Menu> permissionMenus, List<Menu> menuAll){

        //找出父级菜单
        List<Menu> parent = permissionMenus.stream().filter(menu -> menu.isRoot()).collect(Collectors.toList());

        //找出非父级菜单，并且添加父级菜单的所有子级菜单
        List<Menu> child =
                permissionMenus.stream().filter(menu -> !menu.isRoot()).collect(Collectors.toList());

        if (Objects.nonNull(parent)&&parent.size()>0){

            child.addAll(this.filterChildMenu(menuAll,parent));
        }

        child = child.stream().distinct().filter(menu -> !menu.isRoot()).collect(Collectors.toList());

        parent.addAll(permissionMapper.findMenuByMenuId(child.stream().map(Menu::getParentId).collect(Collectors.toList())));

        return this.loginMenu(parent.stream().distinct().collect(Collectors.toList()), child);
    }

    /**
     *@Author:Fly Created in 2018/6/28 上午2:11
     *@Description: 筛选父级菜单所有的子级菜单，并且拍平
     */
    private List<Menu> filterChildMenu(List<Menu> menuAll, List<Menu> parent){

        List<LoginMenuResponseDTO> parents = new ArrayList<>();

        parent.stream().forEach(menu -> {

            parents.add(new LoginMenuResponseDTO()
                    .setId(menu.getId())
                    .setMenuType(menu.getMenuType())
                    .setName(menu.getName())
                    .setRoot(menu.isRoot())
                    .setUrl(menu.getUrl())
                    .setSort(menu.getSort())
                    .setParentId(menu.getParentId())
                    .setCreateTime(menu.getCreateTime())
                    .setModifyTime(menu.getModifyTime())
                    .setCreateUser(menu.getCreateUser())
                    .setModifyUser(menu.getModifyUser())
                    .setChildMenus(getChild(menuAll, menu.getId())));

        });

        return this.patDown(parents);
    }

    /**
     *@Author:Fly Created in 2018/6/28 下午2:05
     *@Description: 递归查询所有子菜单
     */
    private List<LoginMenuResponseDTO> getChild(List<Menu> rootMenu, String menuId){

        List<LoginMenuResponseDTO> childs = new ArrayList<LoginMenuResponseDTO>();

        rootMenu.stream().forEach(menu -> {

            if (menuId.equals(menu.getParentId())){

                childs.add(new LoginMenuResponseDTO()
                        .setId(menu.getId())
                        .setMenuType(menu.getMenuType())
                        .setName(menu.getName())
                        .setRoot(menu.isRoot())
                        .setUrl(menu.getUrl())
                        .setSort(menu.getSort())
                        .setParentId(menu.getParentId())
                        .setCreateTime(menu.getCreateTime())
                        .setModifyTime(menu.getModifyTime())
                        .setCreateUser(menu.getCreateUser())
                        .setModifyUser(menu.getModifyUser()));
            }
        });

        childs.stream().forEach(child -> {

            if (child.isRoot()){

                child.setChildMenus(this.getChild(rootMenu, child.getId()));
            }
        });

        if (childs.size() == 0){

            return null;
        }

        return childs;
    }

    /**
     *@Author:Fly Created in 2018/6/29 上午1:56
     *@Description: 将菜单树拍平
     */
    private List<Menu> patDown(List<LoginMenuResponseDTO> menuTree){

        List<LoginMenuResponseDTO> result = new ArrayList<LoginMenuResponseDTO>();

        result.addAll(this.recursivePatDown(menuTree));

        return result.stream().map(loginMenuResponseDTO ->

                new Menu(
                        loginMenuResponseDTO.getId(),
                        loginMenuResponseDTO.getName(),
                        loginMenuResponseDTO.isRoot(),
                        loginMenuResponseDTO.getParentId(),
                        loginMenuResponseDTO.getMenuType(),
                        loginMenuResponseDTO.getUrl(),
                        loginMenuResponseDTO.getSort(),
                        loginMenuResponseDTO.getCreateTime(),
                        loginMenuResponseDTO.getModifyTime(),
                        loginMenuResponseDTO.getCreateUser(),
                        loginMenuResponseDTO.getModifyUser())

        ).filter(loginMenuResponseDTO -> !loginMenuResponseDTO.isRoot()).collect(Collectors.toList());
    }

    /**
     *@Author:Fly Created in 2018/6/28 下午2:11
     *@Description: 递归将菜单树拍平
     */
    private List<LoginMenuResponseDTO> recursivePatDown(List<LoginMenuResponseDTO> menuTree){

        List<LoginMenuResponseDTO> result = new ArrayList<LoginMenuResponseDTO>();

        menuTree.stream().forEach(menu -> {

            result.add(menu);

            if (Objects.nonNull(menu.getChildMenus())&&menu.getChildMenus().size()>0){

                result.addAll(this.recursivePatDown(menu.getChildMenus()));
            }
        });

        return result;
    }

    /**
     *@Author:Fly Created in 2018/6/29 上午2:24
     *@Description: 筛选所有子菜单的父菜单，并且将拍平的菜单生成树形结构
     */
    private List<LoginMenuResponseDTO> loginMenu(List<Menu> parent, List<Menu> child){

        List<LoginMenuResponseDTO> result = new ArrayList<LoginMenuResponseDTO>();

        //给所有的父级菜单添加子集菜单
        parent.stream().forEach(parentMenu -> {

            LoginMenuResponseDTO par = new LoginMenuResponseDTO()
                    .setId(parentMenu.getId())
                    .setMenuType(parentMenu.getMenuType())
                    .setName(parentMenu.getName())
                    .setRoot(parentMenu.isRoot())
                    .setUrl(parentMenu.getUrl())
                    .setSort(parentMenu.getSort())
                    .setParentId(parentMenu.getParentId())
                    .setCreateTime(parentMenu.getCreateTime())
                    .setModifyTime(parentMenu.getModifyTime())
                    .setCreateUser(parentMenu.getCreateUser())
                    .setModifyUser(parentMenu.getModifyUser());

            child.stream().forEach(childMenu -> {

                if (childMenu.getParentId().equals(parentMenu.getId())){

                    par.getChildMenus().add(new LoginMenuResponseDTO()
                            .setId(childMenu.getId())
                            .setMenuType(childMenu.getMenuType())
                            .setName(childMenu.getName())
                            .setRoot(childMenu.isRoot())
                            .setUrl(childMenu.getUrl())
                            .setSort(childMenu.getSort())
                            .setParentId(childMenu.getParentId())
                            .setCreateTime(childMenu.getCreateTime())
                            .setModifyTime(childMenu.getModifyTime())
                            .setCreateUser(childMenu.getCreateUser())
                            .setModifyUser(childMenu.getModifyUser()));
                }
            });

            result.add(par);
        });

        //给父级菜单寻找父级菜单
        result.stream().forEach(menuOne -> {

            result.stream().forEach(menuTown -> {

                if (!StringUtils.isEmpty(menuTown.getParentId())&&menuOne.getId().equals(menuTown.getParentId())){

                    menuOne.getChildMenus().add(menuTown);
                }
            });
        });

        return result.stream().filter(menuResult -> StringUtils.isEmpty(menuResult.getParentId())).distinct().collect(Collectors.toList());
    }

    /**
     *@Author:Fly Created in 2018/7/26 下午7:17
     *@Description: 菜单排序
     */
    private List<LoginMenuResponseDTO> menuSort(List<LoginMenuResponseDTO> loginMenuResponseDTOS){

        if (Objects.isNull(loginMenuResponseDTOS)||loginMenuResponseDTOS.size()==0){

            return loginMenuResponseDTOS;
        }

        Collections.sort(loginMenuResponseDTOS);

        return loginMenuResponseDTOS;
    }

}
