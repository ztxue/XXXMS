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
 * @description:部门信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_dept")
public class SysDept extends Model<SysDept> implements Serializable {

    private static final long serialVersionUID = -202105211018390058L;

    /**
     * 主键
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 部门名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 组织机构ID
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`org_id`", jdbcType = JdbcType.INTEGER)
    private Integer orgId;
    /**
     * 父级ID
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`parent_id`", jdbcType = JdbcType.INTEGER)
    private Integer parentId;
    /**
     * 联系人
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`user_name`", jdbcType = JdbcType.VARCHAR)
    private String userName;
    /**
     * 联系电话
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`tel`", jdbcType = JdbcType.VARCHAR)
    private String tel;
    /**
     * 排序
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 描述
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`descr`", jdbcType = JdbcType.VARCHAR)
    private String descr;
    /**
     * 删除标识,0未删除,1删除
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 80)
    @TableField(value = "`deleted`", jdbcType = JdbcType.SMALLINT)
    private Integer deleted;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 90)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 机构名称
     */
    @JSONField(ordinal = 21)
    @TableField(exist = false)
    private String orgName;
    /**
     * 子节点数
     */
    @JSONField(serialize = false, ordinal = 22)
    @TableField(exist = false)
    private Integer childrenCount;
    /**
     * 子节
     */
    @JSONField(ordinal = 23)
    @TableField(exist = false)
    private List<SysDept> children;


}
