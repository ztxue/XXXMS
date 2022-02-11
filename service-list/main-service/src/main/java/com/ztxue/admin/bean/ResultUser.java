package com.ztxue.admin.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:人员信息返回实体
 * @date:2021-05-18
 */
@Setter
@Getter
public class ResultUser {


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
     * 头像地址
     */
    @JSONField(ordinal = 3)
    private String headImg;
    /**
     * 组织id
     */
    @JSONField(ordinal = 4)
    private Integer orgId;
    /**
     * 机构名称
     */
    @JSONField(ordinal = 5)
    private String orgName;
    /**
     * 部门ID
     */
    @JSONField(ordinal = 6)
    private Integer deptId;
    /**
     * 部门名称
     */
    @JSONField(ordinal = 7)
    private String deptName;
    /**
     * 姓名
     */
    @JSONField(ordinal = 8)
    private String realName;
    /**
     * 年龄
     */
    @JSONField(ordinal = 9)
    private Integer age;
    /**
     * 性别1表男,2表女
     */
    @JSONField(ordinal = 10)
    private Integer sex;
    /**
     * 邮箱
     */
    @JSONField(ordinal = 11)
    private String email;
    /**
     * 电话
     */
    @JSONField(ordinal = 12)
    private String tel;
    /**
     * 地址
     */
    @JSONField(ordinal = 13)
    private String address;
    /**
     * 描述
     */
    @JSONField(ordinal = 14)
    private String descr;


    /**
     * 组织机构区划
     */
    @JSONField(ordinal = 15)
    private String orgArea;
    /**
     * 区划
     */
    @JSONField(ordinal = 16)
    private List<String> areas;

}
