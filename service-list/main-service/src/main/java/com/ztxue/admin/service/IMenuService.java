package com.ztxue.admin.service;



import com.ztxue.admin.bean.ResultMenu;
import com.ztxue.admin.bean.ResultPermission;

import java.util.List;

/**
 * @author:sunping
 * @description:资源菜单接口
 * @date:2021-05-19
 */
public interface IMenuService {

    /**
     * 菜单列表
     *
     * @param userId
     * @return
     */
    ResultMenu menuList(Integer userId);

    /**
     * 按钮权限列表
     *
     * @param userId
     * @return
     */
    List<ResultPermission> permissionList(Integer userId);

}
