package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:区划信息 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class AreaParams {
    /**
     * 父编码
     */
    private String parentCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;

}
