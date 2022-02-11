package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:资源信息 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class ResParams {

    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 资源类型,0视图,1请求,2权限按钮
     */
    private Integer type;
    /**
     * 级别,0系统,1普通
     */
    private Integer levels;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;

}
