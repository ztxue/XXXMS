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

/**
 * @author:sunping
 * @description:模板信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_template")
public class SysTemplate extends Model<SysTemplate> implements Serializable {

    private static final long serialVersionUID = -202105211018390066L;

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
     * 模板地址
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`url`", jdbcType = JdbcType.VARCHAR)
    private String url;
    /**
     * 描述
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 40)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
}
