package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:部门信息 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class DeptParams {
    /**
     * 部门名称
     */
    private String name;
    /**
     * 机构ID
     */
    private Integer orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 联系人
     */
    private String userName;
    /**
     * 联系电话
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
