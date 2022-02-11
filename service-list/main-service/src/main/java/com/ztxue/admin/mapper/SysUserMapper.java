package com.ztxue.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztxue.admin.bean.ResultUser;
import com.ztxue.admin.bean.ResultUserList;
import com.ztxue.admin.bean.UserParams;
import com.ztxue.admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author:sunping
 * @description:系统人员信息 Mapper
 * @date:2021-02-02
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 人员列表
     *
     * @param params
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " u.id" +
            " ,u.user_name" +
            " ,u.org_id" +
            " ,u.org_name" +
            " ,u.dept_id" +
            " ,u.dept_name" +
            " ,u.real_name" +
            " ,u.age" +
            " ,u.sex" +
            " ,u.tel" +
            " ,u.email" +
            " ,u.levels" +
            " ,u.sort" +
            " FROM sys_user u,sys_org o " +
            "<where>" +
            " u.org_id=o.id" +
            " AND u.`deleted`=0" +
            " <if test=\"params.type!=null\">" +
            " AND o.type=#{params.type,jdbcType=INTEGER}" +
            " </if>" +
            " <if test=\"params.orgId!=null\">" +
            " AND u.org_id=#{params.orgId,jdbcType=INTEGER}" +
            " </if>" +
            " <if test=\"params.orgName!=null and params.orgName!=''\">" +
            " AND u.org_name LIKE concat('%',#{params.orgName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.deptId!=null\">" +
            " AND u.dept_id=#{params.deptId,jdbcType=INTEGER}" +
            " </if>" +
            " <if test=\"params.deptName!=null and params.deptName!=''\">" +
            " AND u.dept_name LIKE concat('%',#{params.deptName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.userName!=null and params.userName!=''\">" +
            " AND u.user_name LIKE concat('%',#{params.userName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.realName!=null and params.realName!=''\">" +
            " AND u.real_name LIKE concat('%',#{params.realName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.tel!=null and params.tel!=''\">" +
            " AND u.tel LIKE concat('%',#{params.tel,jdbcType=VARCHAR},'%')" +
            " </if>" +
            "</where>" +
            " ORDER BY u.sort ASC,u.id DESC" +
            "</script>")
    IPage<SysUser> selectList(@Param("params") UserParams params, @Param("page") Page<SysUser> page);


    /**
     * 根据机构统计人员
     *
     * @param orgIds
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " count(*) " +
            " FROM sys_user u" +
            "<where>" +
            " u.`deleted`=0" +
            " AND u.org_id IN " +
            " <foreach index=\"index\" collection=\"orgIds\" item=\"orgId\" open=\"(\" separator=\",\" close=\")\">" +
            " #{orgId,jdbcType=INTEGER}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int selectCountByOrgId(@Param("orgIds") Set<Integer> orgIds);


    /**
     * 修改人员信息
     *
     * @param orgId
     * @param oldOrgId
     * @return
     */
    @Update("<script>" +
            "UPDATE" +
            " sys_user u" +
            " ,(SELECT o.id,o.name FROM sys_org o WHERE o.id=#{orgId,jdbcType=INTEGER}) so" +
            " SET u.org_id=so.id,u.org_name=so.name" +
            "<where>" +
            " u.`deleted`=0" +
            " AND u.org_id=#{oldOrgId,jdbcType=INTEGER}" +
            "</where>" +
            "</script>")
    int updateByOrgId(@Param("orgId") Integer orgId, @Param("oldOrgId") Integer oldOrgId);

    /**
     * 是否存在
     *
     * @param userName userName
     * @param id       主键
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " count(*) " +
            " FROM sys_user u" +
            "<where>" +
            " u.deleted=0" +
            " AND u.user_name=#{userName,jdbcType=VARCHAR}" +
            " <if test=\"id!=null\">" +
            " AND u.id<![CDATA[ < ]]>#{id,jdbcType=INTEGER} " +
            " AND u.id<![CDATA[ > ]]>#{id,jdbcType=INTEGER} " +
            " </if>" +
            "</where>" +
            "</script>")
    int selectCountExist(@Param("userName") String userName, @Param("id") Integer id);

    /**
     * 删除人员
     *
     * @param ids
     * @return
     */
    @Update("<script>" +
            "UPDATE sys_user SET deleted=1 " +
            "<where>" +
            " id IN " +
            " <foreach index=\"index\" collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\">" +
            " #{id,jdbcType=INTEGER}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int delete(@Param("ids") Set<Integer> ids);

    /**
     * 根据用户名密码获取人员信息
     *
     * @param userName
     * @param password
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " u.id" +
            " ,u.head_img" +
            " ,u.user_name" +
            " ,u.real_name" +
            " ,u.org_id" +
            " ,u.org_name" +
            " ,u.dept_id" +
            " ,u.dept_name" +
            " ,u.age" +
            " ,u.sex" +
            " ,u.tel" +
            " ,u.email" +
            " ,u.address" +
            " ,u.descr" +
            " FROM sys_user u " +
            "<where>" +
            " u.`deleted`=0" +
            " AND u.user_name=#{userName,jdbcType=VARCHAR}" +
            " AND u.password=#{password,jdbcType=VARCHAR}" +
            "</where>" +
            " ORDER BY u.sort ASC,u.id DESC" +
            " LIMIT 1" +
            "</script>")
    ResultUser selectUser(@Param("userName") String userName, @Param("password") String password);

    /**
     * 修改组织机构名称
     *
     * @param orgId
     * @param orgName
     * @return
     */
    @Update("<script>" +
            "UPDATE sys_user SET org_name=#{orgName,jdbcType=VARCHAR} WHERE org_id=#{orgId,jdbcType=INTEGER}" +
            "</script>")
    int updateOrgName(@Param("orgId") Integer orgId, @Param("orgName") String orgName);

    /**
     * 修部门名称
     *
     * @param deptId
     * @param deptName
     * @return
     */
    @Update("<script>" +
            "UPDATE sys_user SET dept_name=#{deptName,jdbcType=VARCHAR} WHERE dept_id=#{deptId,jdbcType=INTEGER}" +
            "</script>")
    int updateDeptName(@Param("deptId") Integer deptId, @Param("deptName") String deptName);

    /**
     * 根据机构和部门查询人员
     *
     * @param orgId
     * @param deptId
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " u.id" +
            " ,u.user_name" +
            " ,u.real_name" +
            " FROM sys_user u,sys_org o " +
            "<where>" +
            " u.`org_id`=o.id" +
            " AND o.`type`=0" +
            " AND o.`deleted`=0" +
            " AND u.`deleted`=0" +
            " <if test=\"orgId!=null\">" +
            " AND u.org_id=#{orgId,jdbcType=INTEGER}" +
            " </if>" +
            " <if test=\"deptId!=null\">" +
            " AND u.dept_id=#{deptId,jdbcType=INTEGER}" +
            " </if>" +
            "</where>" +
            " ORDER BY u.sort ASC,u.id DESC" +
            "</script>")
    List<ResultUserList> selectAllUser(@Param("orgId") Integer orgId, @Param("deptId") Integer deptId);

}
