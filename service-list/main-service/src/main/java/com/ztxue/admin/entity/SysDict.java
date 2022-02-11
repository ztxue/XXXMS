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
 * @description:数据字典 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_dict")
public class SysDict extends Model<SysDict> implements Serializable {

    private static final long serialVersionUID = -202105211018390059L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 属性值
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`code`", jdbcType = JdbcType.VARCHAR)
    private String code;
    /**
     * 属性名称
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 父级ID
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`parent_id`", jdbcType = JdbcType.INTEGER)
    private Integer parentId;
    /**
     * 级别,0系统,1普通
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`levels`", jdbcType = JdbcType.SMALLINT)
    private Integer levels;
    /**
     * 标签分组
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`tag`", jdbcType = JdbcType.VARCHAR)
    private String tag;
    /**
     * 描述
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
    /**
     * 排序
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 删除标识,0未删除,1删除
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 80)
    @TableField(value = "`deleted`", jdbcType = JdbcType.SMALLINT)
    private Integer deleted;
}
