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
 * @description:资源信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_res")
public class SysRes extends Model<SysRes> implements Serializable {

    private static final long serialVersionUID = -202105211018390063L;

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
     * 访问地址
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`url`", jdbcType = JdbcType.VARCHAR)
    private String url;
    /**
     * 图标样式
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`icon_cls`", jdbcType = JdbcType.VARCHAR)
    private String iconCls;
    /**
     * 父级ID
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`parent_id`", jdbcType = JdbcType.INTEGER)
    private Integer parentId;
    /**
     * 资源类型,0视图,1请求,2权限按钮
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`type`", jdbcType = JdbcType.SMALLINT)
    private Integer type;
    /**
     * 权限按钮标识
     */
    @JSONField(ordinal = 51)
    @TableField(value = "`code`", jdbcType = JdbcType.VARCHAR)
    private String code;

    /**
     * 视图路径
     */
    @JSONField(ordinal = 52)
    @TableField(value = "`page`", jdbcType = JdbcType.VARCHAR)
    private String page;
    /**
     * 是否显示,0显示,1隐藏
     */
    @JSONField(ordinal = 55)
    @TableField(value = "`invisible`", jdbcType = JdbcType.SMALLINT)
    private Integer invisible;
    /**
     * 级别,0系统,1普通
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`levels`", jdbcType = JdbcType.SMALLINT)
    private Integer levels;
    /**
     * 排序
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 描述
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
}
