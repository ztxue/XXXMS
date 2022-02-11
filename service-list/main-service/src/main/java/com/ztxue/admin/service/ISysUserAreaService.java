package com.ztxue.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztxue.admin.entity.SysUserArea;

import java.util.List;

/**
 * @author:sunping
 * @description:人员区划关系 Service接口
 * @date:2021-07-28
 */
public interface ISysUserAreaService extends IService<SysUserArea> {
    /**
     * 根据人员查询区划
     *
     * @param userId
     * @return
     */
    List<SysUserArea> areaList(Integer userId);

    /**
     * 根据人员查询区划
     *
     * @param userId
     * @return
     */
    List<String> codeList(Integer userId);

    /**
     * 人员区划关系
     *
     * @param userId
     * @param areas
     * @return
     */
    int update(Integer userId, List<SysUserArea> areas);
}
