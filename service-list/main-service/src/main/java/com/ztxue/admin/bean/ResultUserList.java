package com.ztxue.admin.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:人员信息返回实体
 * @date:2021-05-18
 */
@Setter
@Getter
public class ResultUserList {


    /**
     * 主键ID
     */
    @JSONField(ordinal = 1)
    private Integer id;
    /**
     * 用户名
     */
    @JSONField(ordinal = 2)
    private String userName;
    /**
     * 真实姓名
     */
    @JSONField(ordinal = 3)
    private String realName;

}
