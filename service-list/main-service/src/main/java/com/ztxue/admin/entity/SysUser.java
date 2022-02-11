package com.ztxue.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author:sunping
 * @description:系统人员信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_user")
public class SysUser extends Model<SysUser> implements Serializable {

    private static final long serialVersionUID = -202105211029010109L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_name`", jdbcType = JdbcType.VARCHAR)
    private String userName;
    /**
     * 密码
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`password`", jdbcType = JdbcType.VARCHAR)
    private String password;
    /**
     * 头像地址
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`head_img`", jdbcType = JdbcType.VARCHAR)
    private String headImg;
    /**
     * 组织id
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`org_id`", jdbcType = JdbcType.INTEGER)
    private Integer orgId;
    /**
     * 机构名称
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`org_name`", jdbcType = JdbcType.VARCHAR)
    private String orgName;
    /**
     * 部门ID
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`dept_id`", jdbcType = JdbcType.INTEGER)
    private Integer deptId;
    /**
     * 部门名称
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`dept_name`", jdbcType = JdbcType.VARCHAR)
    private String deptName;
    /**
     * 姓名
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`real_name`", jdbcType = JdbcType.VARCHAR)
    private String realName;
    /**
     * 年龄
     */
    @JSONField(ordinal = 90)
    @TableField(value = "`age`", jdbcType = JdbcType.INTEGER)
    private Integer age;
    /**
     * 性别1表男,2表女
     */
    @JSONField(ordinal = 100)
    @TableField(value = "`sex`", jdbcType = JdbcType.SMALLINT)
    private Integer sex;
    /**
     * 邮箱
     */
    @JSONField(ordinal = 110)
    @TableField(value = "`email`", jdbcType = JdbcType.VARCHAR)
    private String email;
    /**
     * 电话
     */
    @JSONField(ordinal = 120)
    @TableField(value = "`tel`", jdbcType = JdbcType.VARCHAR)
    private String tel;
    /**
     * 级别,0系统,1普通
     */
    @JSONField(ordinal = 130)
    @TableField(value = "`levels`", jdbcType = JdbcType.SMALLINT)
    private Integer levels;
    /**
     * 地址
     */
    @JSONField(ordinal = 140)
    @TableField(value = "`address`", jdbcType = JdbcType.VARCHAR)
    private String address;
    /**
     * 排序
     */
    @JSONField(ordinal = 150)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 描述
     */
    @JSONField(ordinal = 160)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 170)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 是否删除,0未删除,1删除
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 180)
    @TableField(value = "`deleted`", jdbcType = JdbcType.SMALLINT)
    private Integer deleted;

    /**
     * 区划
     */
    @JSONField(ordinal = 190)
    @TableField(exist = false)
    private List<SysUserArea> areas;
}
