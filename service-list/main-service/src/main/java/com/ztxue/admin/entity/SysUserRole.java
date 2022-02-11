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
 * @description:人员角色关联 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_user_role")
public class SysUserRole extends Model<SysUserRole> implements Serializable {

    private static final long serialVersionUID = -202105211029010110L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色ID
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`role_id`", jdbcType = JdbcType.INTEGER)
    private Integer roleId;
    /**
     * 人员ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`user_id`", jdbcType = JdbcType.INTEGER)
    private Integer userId;
}
