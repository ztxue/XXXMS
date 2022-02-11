package com.ztxue.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
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
 * @description:组织机构信息 实体类
 * @date:2021-05-21
 */
@Setter
@Getter
@TableName(value = "sys_org")
public class SysOrg extends Model<SysOrg> implements Serializable {

    private static final long serialVersionUID = -202105211018390062L;

    /**
     * 主键ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 机构名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 机构编码
     */
    @JSONField(ordinal = 20)
    @TableField(value = "`org_code`", jdbcType = JdbcType.VARCHAR)
    private String orgCode;
    /**
     * LOGO图片
     */
    @JSONField(ordinal = 30)
    @TableField(value = "`logo_img`", jdbcType = JdbcType.VARCHAR)
    private String logoImg;
    /**
     * 营业执照
     */
    @JSONField(ordinal = 40)
    @TableField(value = "`license_img`", jdbcType = JdbcType.VARCHAR)
    private String licenseImg;
    /**
     * 父级ID
     */
    @JSONField(ordinal = 50)
    @TableField(value = "`parent_id`", jdbcType = JdbcType.INTEGER)
    private Integer parentId;
    /**
     * 类别,0平台,1企业,默认0
     */
    @JSONField(ordinal = 60)
    @TableField(value = "`type`", jdbcType = JdbcType.SMALLINT)
    private Integer type;
    /**
     * 联系人
     */
    @JSONField(ordinal = 70)
    @TableField(value = "`user_name`", jdbcType = JdbcType.VARCHAR)
    private String userName;
    /**
     * 联系电话
     */
    @JSONField(ordinal = 80)
    @TableField(value = "`tel`", jdbcType = JdbcType.VARCHAR)
    private String tel;
    /**
     * 邮箱
     */
    @JSONField(ordinal = 90)
    @TableField(value = "`email`", jdbcType = JdbcType.VARCHAR)
    private String email;
    /**
     * 法人
     */
    @JSONField(ordinal = 100)
    @TableField(value = "`legal_person`", jdbcType = JdbcType.VARCHAR)
    private String legalPerson;
    /**
     * 法人身份证号码
     */
    @JSONField(ordinal = 110)
    @TableField(value = "`legal_card`", jdbcType = JdbcType.VARCHAR)
    private String legalCard;
    /**
     * 省,区划代码
     */
    @JSONField(ordinal = 120)
    @TableField(value = "`province`", jdbcType = JdbcType.VARCHAR, updateStrategy = FieldStrategy.IGNORED)
    private String province;
    /**
     * 市,区划代码
     */
    @JSONField(ordinal = 130)
    @TableField(value = "`city`", jdbcType = JdbcType.VARCHAR, updateStrategy = FieldStrategy.IGNORED)
    private String city;
    /**
     * 区县,区划代码
     */
    @JSONField(ordinal = 140)
    @TableField(value = "`county`", jdbcType = JdbcType.VARCHAR, updateStrategy = FieldStrategy.IGNORED)
    private String county;
    /**
     * 街道/乡镇代码
     */
    @JSONField(ordinal = 150)
    @TableField(value = "`town`", jdbcType = JdbcType.VARCHAR, updateStrategy = FieldStrategy.IGNORED)
    private String town;
    /**
     * 社区/村代码
     */
    @JSONField(ordinal = 160)
    @TableField(value = "`village`", jdbcType = JdbcType.VARCHAR, updateStrategy = FieldStrategy.IGNORED)
    private String village;
    /**
     * 地址
     */
    @JSONField(ordinal = 180)
    @TableField(value = "`address`", jdbcType = JdbcType.VARCHAR)
    private String address;
    /**
     * 纬度
     */
    @JSONField(ordinal = 190)
    @TableField(value = "`lat`", jdbcType = JdbcType.VARCHAR)
    private String lat;
    /**
     * 经度
     */
    @JSONField(ordinal = 200)
    @TableField(value = "`lng`", jdbcType = JdbcType.VARCHAR)
    private String lng;
    /**
     * 详情
     */
    @JSONField(ordinal = 210)
    @TableField(value = "`content`", jdbcType = JdbcType.CLOB)
    private String content;
    /**
     * 排序
     */
    @JSONField(ordinal = 220)
    @TableField(value = "`sort`", jdbcType = JdbcType.INTEGER)
    private Integer sort;
    /**
     * 启用,0未启用,1启用
     */
    @JSONField(ordinal = 230)
    @TableField(value = "`usable`", jdbcType = JdbcType.SMALLINT)
    private Integer usable;
    /**
     * 删除标识,0未删除,1删除
     */
    @JSONField(deserialize = false, serialize = false, ordinal = 240)
    @TableField(value = "`deleted`", jdbcType = JdbcType.SMALLINT)
    private Integer deleted;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 260)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;

    /**
     * 子节点数
     */
    @JSONField(serialize = false, ordinal = 280)
    @TableField(exist = false)
    private Integer childrenCount;
    /**
     * 子节
     */
    @JSONField(ordinal = 290)
    @TableField(exist = false)
    private List<SysOrg> children;

}
