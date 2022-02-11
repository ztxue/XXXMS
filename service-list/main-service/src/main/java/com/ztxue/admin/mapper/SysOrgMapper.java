package com.ztxue.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztxue.admin.bean.OrgParams;
import com.ztxue.admin.entity.SysOrg;
import com.ztxue.core.utils.TreeNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author:sunping
 * @description:组织机构信息 Mapper
 * @date:2021-02-02
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrg> {
    /**
     * 列表
     *
     * @param params
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " t.id" +
            " ,t.name" +
            " ,t.org_code" +
            " ,t.type" +
            " ,t.user_name" +
            " ,t.tel" +
            " ,t.email" +
            " ,t.address" +
            " ,t.sort" +
            " ,t.usable " +
            " FROM sys_org t " +
            "<where>" +
            " t.`deleted`=0" +
            " <if test=\"params.name!=null and params.name!=''\">" +
            " AND t.name LIKE concat('%',#{params.name,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.orgCode!=null and params.orgCode!=''\">" +
            " AND t.org_code LIKE concat('%',#{params.orgCode,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.type!=null\">" +
            " AND t.type=#{params.type,jdbcType=INTEGER}" +
            " </if>" +
            " <if test=\"params.userName!=null and params.userName!=''\">" +
            " AND t.user_name LIKE concat('%',#{params.userName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.tel!=null and params.tel!=''\">" +
            " AND t.tel LIKE concat('%',#{params.tel,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"params.parentId!=null\">" +
            " AND t.parent_id=#{params.parentId,jdbcType=INTEGER}" +
            " </if>" +
            "</where>" +
            " ORDER BY t.sort ASC,t.id ASC" +
            "</script>")
    IPage<SysOrg> selectList(@Param("params") OrgParams params, @Param("page") Page<SysOrg> page);

    /**
     * 是否存在
     *
     * @param name name
     * @param id   主键
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " count(*) " +
            " FROM sys_org t" +
            "<where>" +
            " t.`deleted`=0" +
            " <if test=\"name!=null and name!=''\">" +
            " AND t.name=#{name,jdbcType=VARCHAR}" +
            " </if>" +
            " <if test=\"id!=null\">" +
            " AND t.id<![CDATA[ < ]]>#{id,jdbcType=INTEGER} " +
            " AND t.id<![CDATA[ > ]]>#{id,jdbcType=INTEGER} " +
            " </if>" +
            "</where>" +
            "</script>")
    int selectCountExist(@Param("name") String name, @Param("id") Integer id);

    /**
     * 根据父级Id查询
     *
     * @param parentId
     * @param type
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`name`" +
            " ,(SELECT count(*) AS `children` FROM sys_org o WHERE o.`deleted`=0 AND o.`parent_id`=t.`id`" +
            " <if test=\"type!=null\">" +
            " AND o.type=#{type,jdbcType=INTEGER} " +
            " </if>" +
            ") AS `childrenCount`" +
            " FROM sys_org t" +
            "<where>" +
            " t.`deleted`=0" +
            " AND t.parent_id=#{parentId,jdbcType=INTEGER}" +
            " <if test=\"type!=null\">" +
            " AND t.type=#{type,jdbcType=INTEGER} " +
            " </if>" +
            "</where>" +
            " ORDER BY t.sort ASC,t.id ASC" +
            "</script>")
    List<TreeNode> selectTree(@Param("parentId") Integer parentId, @Param("type") Integer type);

    /**
     * 删除组织机构
     *
     * @param ids
     * @return
     */
    @Update("<script>" +
            "UPDATE sys_org SET deleted=1 " +
            "<where>" +
            " id IN " +
            " <foreach index=\"index\" collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\">" +
            " #{id,jdbcType=INTEGER}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int delete(@Param("ids") Set<Integer> ids);

}
