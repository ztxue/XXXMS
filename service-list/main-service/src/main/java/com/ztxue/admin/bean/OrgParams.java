package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:组织机构信息 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class OrgParams {
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构编码
     */
    private String orgCode;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 类别,0平台,1企业,默认0
     */
    private Integer type;
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
