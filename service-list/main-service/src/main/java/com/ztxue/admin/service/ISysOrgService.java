package com.ztxue.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztxue.admin.bean.OrgParams;
import com.ztxue.admin.entity.SysOrg;
import com.ztxue.core.result.ResultList;
import com.ztxue.core.utils.TreeNode;

import java.util.List;
import java.util.Set;

/**
 * @author:sunping
 * @description:组织机构信息 Service接口
 * @date:2021-02-02
 */
public interface ISysOrgService extends IService<SysOrg> {
    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    ResultList<SysOrg> list(OrgParams params);

    /**
     * 查询所有组织机构
     *
     * @param parentId
     * @param type
     * @return
     */
    List<SysOrg> allList(Integer parentId, Integer type);

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    int add(SysOrg entity);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(SysOrg entity);

    /**
     * 显示
     *
     * @param id
     * @return
     */
    SysOrg show(Integer id);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    int delete(Set<Integer> ids);

    /**
     * 机构树
     *
     * @param parentId
     * @param type
     * @return
     */
    List<TreeNode> tree(Integer parentId, Integer type);

    /**
     * 检查重复
     *
     * @param name name
     * @param id   id
     * @return
     */
    int checkExist(String name, Integer id);

}
