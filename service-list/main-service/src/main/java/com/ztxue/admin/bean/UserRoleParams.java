package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author:sunping
 * @description:人员与角色关联请求实体对象
 * @date:2021/4/30
 */
@Setter
@Getter
public class UserRoleParams<T> {
    /**
     * 人员ID
     */
    private Integer userId;
    /**
     * 角色ID数组
     */
    private Set<T> roleIds;
}
