package com.ztxue.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztxue.admin.entity.SysUserArea;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:sunping
 * @description:人员区划关系 Mapper
 * @date:2021-07-28
 */
@Mapper
public interface SysUserAreaMapper extends BaseMapper<SysUserArea> {

    /**
     * 根据人员ID查询区划
     *
     * @param userId
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " ua.area_name" +
            " FROM" +
            " sys_user_area ua" +
            "<where>" +
            " ua.user_id=#{userId,jdbcType=INTEGER}" +
            "</where>" +
            " ORDER BY ua.id ASC" +
            "</script>")
    List<String> selectCodesByUserId(@Param("userId") Integer userId);

    /**
     * 根据人员ID查询区划
     *
     * @param userId
     * @return
     */
    @Select("<script>" +
            "SELECT" +
            " ua.area_code" +
            " ,ua.area_Name" +
            " FROM" +
            " sys_user_area ua" +
            "<where>" +
            " ua.user_id=#{userId,jdbcType=INTEGER}" +
            "</where>" +
            " ORDER BY ua.id ASC" +
            "</script>")
    List<SysUserArea> selectAreasByUserId(@Param("userId") Integer userId);

    /**
     * 根据区划删除关系
     *
     * @param userId
     * @param codes
     * @return
     */
    @Delete("<script>" +
            "DELETE FROM sys_user_area ua " +
            "<where>" +
            " ua.user_id=#{userId,jdbcType=INTEGER}" +
            " AND ua.area_code IN " +
            " <foreach index=\"index\" collection=\"codes\" item=\"code\" open=\"(\" separator=\",\" close=\")\">" +
            " #{code,jdbcType=VARCHAR}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int deleteByCodes(@Param("userId") Integer userId, @Param("codes") List<String> codes);

    /**
     * 批量插入人员区划关系
     *
     * @param userId
     * @param areas
     * @return
     */
    @Insert("<script>" +
            "INSERT INTO sys_user_area (user_id,area_code,area_name) VALUES " +
            " <foreach index=\"index\" collection=\"areas\" item=\"area\" separator=\",\">" +
            " (#{userId,jdbcType=INTEGER},#{area.areaCode,jdbcType=VARCHAR},#{area.areaName,jdbcType=VARCHAR})" +
            " </foreach>" +
            "</script>")
    int insertUserAreas(@Param("userId") Integer userId, @Param("areas") List<SysUserArea> areas);


}
