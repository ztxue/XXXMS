package com.ztxue.admin.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:按钮权限 返回实体
 * @date:2021-05-19
 */
@Setter
@Getter
public class ResultPermission {

    /**
     * 路由标识
     */
    @JSONField(ordinal = 1)
    private String id;

    /**
     * 权限标识
     */
    @JSONField(ordinal = 2)
    private List<String> operation;

}
