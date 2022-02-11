package com.ztxue.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztxue.admin.bean.MenuBean;
import com.ztxue.admin.entity.SysRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:sunping
 * @description:资源菜单 Mapper
 * @date:2021-05-19
 */
@Mapper
public interface MenuMapper extends BaseMapper<SysRes> {
    /**
     * 资源菜单
     *
     * @param parentId
     * @param userId
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " DISTINCT" +
            " r.id" +
            " ,r.`name`" +
            " ,r.`invisible`" +
            " ,r.icon_cls" +
            " ,r.url" +
            " ,r.page" +
            " ,r.sort" +
            ",(SELECT COUNT(*) FROM sys_res sr,sys_role_res srr,sys_user_role sur WHERE sr.id=srr.res_id AND sr.parent_id=r.id AND sr.type=0 AND srr.role_id=sur.role_id AND sur.user_id=ur.user_id) AS `children`" +
            " FROM sys_res r,sys_role_res ro,sys_user_role ur" +
            "<where>" +
            " r.id=ro.res_id" +
            " AND r.parent_id=#{parentId,jdbcType=INTEGER}" +
            " AND r.type=0 " +
            " AND ro.role_id=ur.role_id" +
            " AND ur.user_id=#{userId,jdbcType=INTEGER}" +
            "</where>" +
            " ORDER BY r.sort ASC,r.id ASC" +
            "</script>")
    List<MenuBean> selectMenuList(@Param("parentId") Integer parentId, @Param("userId") Integer userId);

    /**
     * 权限按钮
     *
     * @param userId
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " DISTINCT" +
            " r.`id`" +
            " ,r.`code`" +
            " ,r.`type`" +
            " ,r.`parent_id`" +
            " ,r.`sort`" +
            " FROM sys_res r,sys_role_res ro,sys_user_role ur" +
            "<where>" +
            " r.id=ro.res_id" +
            " AND ro.role_id=ur.role_id" +
            " AND ur.user_id=#{userId,jdbcType=INTEGER}" +
            "</where>" +
            " ORDER BY r.sort ASC,r.id ASC" +
            "</script>")
    List<SysRes> selectPermissions(@Param("userId") Integer userId);

}
