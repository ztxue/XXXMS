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

import java.io.Serializable;

/**
 * @author:sunping
 * @description:人员区划关系 实体类
 * @date:2021-07-28
 */
@Setter
@Getter
@TableName(value = "sys_user_area")
public class SysUserArea extends Model<SysUserArea> implements Serializable {

    private static final long serialVersionUID = -202107281037310001L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 人员ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`user_id`", jdbcType = JdbcType.INTEGER)
    private Integer userId;
    /**
     * 区划代码
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`area_code`", jdbcType = JdbcType.VARCHAR)
    private String areaCode;
    /**
     * 区划名称
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`area_name`", jdbcType = JdbcType.VARCHAR)
    private String areaName;
}
