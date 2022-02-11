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
 * @description:附件信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_file")
public class SysFile extends Model<SysFile> implements Serializable {

    private static final long serialVersionUID = -202105211018390060L;

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
     * 文件类型
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`content_type`", jdbcType = JdbcType.VARCHAR)
    private String contentType;
    /**
     * 文件URL
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`url`", jdbcType = JdbcType.VARCHAR)
    private String url;
    /**
     * 外键关联UUID
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`pid`", jdbcType = JdbcType.VARCHAR)
    private String pid;
}
