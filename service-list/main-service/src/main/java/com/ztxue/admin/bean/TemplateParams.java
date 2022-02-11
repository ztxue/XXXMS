package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:模板 参数类
 * @date:2021-05-17
 */
@Setter
@Getter
public class TemplateParams {

    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String descr;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;

}
