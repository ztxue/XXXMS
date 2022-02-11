package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:菜单信息 返回实体
 * @date:2021-05-19
 */
@Setter
@Getter
public class MenuBean {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * /**
     * 图标
     */
    private String iconCls;
    /**
     * 是否显示,0显示,1隐藏
     */
    private Integer invisible;
    /**
     * url
     */
    private String url;
    /**
     * 页面路径
     */
    private String page;
    /**
     * 子节点
     */
    private Integer children;

    /**
     * 权限按钮数量
     */
    private Integer permissions;
}
