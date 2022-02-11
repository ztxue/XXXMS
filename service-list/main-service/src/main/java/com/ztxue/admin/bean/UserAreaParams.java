package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author:sunping
 * @description:人员区划关系 参数类
 * @date:2021-07-28
 */
@Setter
@Getter
public class UserAreaParams<T> {
    /**
     * 人员ID
     */
    private Integer userId;
    /**
     * 区划代码数组
     */
    private Set<T> codes;
}
