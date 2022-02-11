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
 * @description:角色信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_role")
public class SysRole extends Model<SysRole> implements Serializable {

    private static final long serialVersionUID = -202105211018390064L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 级别,0系统,1普通
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`levels`", jdbcType = JdbcType.SMALLINT)
    private Integer levels;
    /**
     * 排序
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 描述
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
    /**
     * 是否选中
     */
    @JSONField(ordinal = 50)
    @TableField(exist = false)
    private Boolean checked;
}
