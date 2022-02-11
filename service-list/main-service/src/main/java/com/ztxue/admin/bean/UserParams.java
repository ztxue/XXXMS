package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:人员信息 参数类
 * @date:2021-02-02
 */
@Setter
@Getter
public class UserParams {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 机构类型,0平台,1企业
     */
    private Integer type;
    /**
     * 组织id
     */
    private Integer orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 电话
     */
    private String tel;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}
