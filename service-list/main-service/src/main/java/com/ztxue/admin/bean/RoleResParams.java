package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author:sunping
 * @description:角色与资源关联请求实体对象
 * @date:2021/4/27
 */
@Setter
@Getter
public class RoleResParams<T> {
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 资源ID数组
     */
    private Set<T> resIds;
}
