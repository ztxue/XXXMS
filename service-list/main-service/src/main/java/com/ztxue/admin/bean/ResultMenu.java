package com.ztxue.admin.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:菜单信息 返回实体
 * @date:2021-05-19
 */
@Setter
@Getter
public class ResultMenu {

    /**
     * 路由标识
     */
    @JSONField(ordinal = 1)
    private String router;
    /**
     * 名称
     */
    @JSONField(ordinal = 2)
    private String name;
    /**
     * 访问路径
     */
    @JSONField(ordinal = 3)
    private String path;
    /**
     * 视图路径
     */
    @JSONField(ordinal = 4)
    private String pageView;
    /**
     * 图标
     */
    @JSONField(ordinal = 5)
    private String icon;
    /**
     * 外链接
     */
    @JSONField(ordinal = 6)
    private String link;
    /**
     * 是否显示
     */
    @JSONField(ordinal = 7)
    private Boolean invisible;
    /**
     * 按钮权限
     */
    @JSONField(ordinal = 8)
    private MetaBean meta;
    /**
     * 子节点
     */
    @JSONField(ordinal = 9)
    private List<ResultMenu> children;
}
