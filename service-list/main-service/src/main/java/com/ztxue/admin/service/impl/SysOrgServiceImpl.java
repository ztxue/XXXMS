package com.ztxue.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztxue.admin.bean.OrgParams;
import com.ztxue.admin.entity.SysOrg;
import com.ztxue.admin.service.ISysOrgService;
import com.ztxue.admin.mapper.SysOrgMapper;
import com.ztxue.admin.mapper.SysUserMapper;
import com.ztxue.core.exception.HttpRuntimeException;
import com.ztxue.core.result.PageBean;
import com.ztxue.core.result.ResultEnum;
import com.ztxue.core.result.ResultList;
import com.ztxue.core.utils.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author:sunping
 * @description:组织机构信息 ServiceImpl
 * @date:2021-02-02
 */
@Slf4j
@Service("sysOrgServiceImpl")
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {

    private final SysOrgMapper sysOrgMapper;
    private final SysUserMapper sysUserMapper;

    public SysOrgServiceImpl(SysOrgMapper sysOrgMapper, SysUserMapper sysUserMapper) {
        this.sysOrgMapper = sysOrgMapper;
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    @Override
    public ResultList<SysOrg> list(OrgParams params) {
        if (params == null) {
            params = new OrgParams();
        }
        Integer currentPage = params.getCurrentPage();
        Integer pageSize = params.getPageSize();
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        Page<SysOrg> page = new Page<>(currentPage, pageSize);
        IPage<SysOrg> iPage = sysOrgMapper.selectList(params, page);
        ResultList<SysOrg> resultList = new ResultList<>();
        resultList.setList(iPage.getRecords());
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(iPage.getCurrent());
        pageBean.setPageSize(iPage.getSize());
        pageBean.setAllRows(iPage.getTotal());
        pageBean.setAllPages(iPage.getPages());
        resultList.setPage(pageBean);
        return resultList;
    }

    @Override
    public List<SysOrg> allList(Integer parentId, Integer type) {
        return selectRecursion(parentId, type, 0);
    }

    private List<SysOrg> selectRecursion(Integer parentId, Integer type, int n) {
        List<SysOrg> tempList = null;
        int m = n;
        m++;
        List<SysOrg> list = null;

        List<TreeNode> nodes = sysOrgMapper.selectTree(parentId, type);
        list = getOrgList(nodes);

        if (list == null || list.isEmpty()) {
            return tempList;
        }
        List<SysOrg> depts = new ArrayList<>();
        for (int i = 0, j = list.size(); i < j; i++) {
            SysOrg org = list.get(i);
            List<SysOrg> children = getChildren(org.getChildrenCount(), org.getId(), type, m);
            org.setChildren(children);
            depts.add(org);
        }
        return depts;
    }

    private List<SysOrg> getOrgList(List<TreeNode> nodes) {
        List<SysOrg> tempList = null;
        if (nodes.isEmpty()) {
            return tempList;
        }
        List<SysOrg> list = new ArrayList<>(0);
        for (TreeNode node : nodes) {
            SysOrg org = new SysOrg();
            org.setId((Integer) node.getId());
            org.setName(node.getName());
            org.setChildrenCount(node.getChildrenCount());
            list.add(org);
        }
        return list;
    }

    private List<SysOrg> getChildren(int childrenCount, Integer parentId, Integer type, int m) {
        List<SysOrg> tempList = null;
        if (childrenCount > 0) {
            List<SysOrg> children = selectRecursion(parentId, type, m);
            if (!children.isEmpty()) {
                return children;
            }
        }
        return tempList;
    }

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    @Override
    public int add(SysOrg entity) {
        if (!StringUtils.isBlank(entity.getContent())) {
            entity.setContent(StringEscapeUtils.unescapeHtml4(entity.getContent()));
        }
        if (entity.getParentId() == null) {
            entity.setParentId(0);
        }
        entity.setCreateTime(new Date());
        sysOrgMapper.insert(entity);
        return entity.getId();
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysOrg entity) {
        if (entity.getId() == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        if (!StringUtils.isBlank(entity.getContent())) {
            entity.setContent(StringEscapeUtils.unescapeHtml4(entity.getContent()));
        }
        if (entity.getParentId() == null) {
            entity.setParentId(0);
        }
        SysOrg org = sysOrgMapper.selectById(entity.getId());
        if (!entity.getName().equals(org.getName())) {
            sysUserMapper.updateOrgName(entity.getId(), entity.getName());
        }
        return sysOrgMapper.updateById(entity);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public SysOrg show(Integer id) {
        if (id == null) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysOrgMapper.selectById(id);
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    public int delete(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new HttpRuntimeException(ResultEnum.IDNULL.getCode(), ResultEnum.IDNULL.getDesc());
        }
        return sysOrgMapper.delete(ids);
    }

    @Override
    public List<TreeNode> tree(Integer parentId, Integer type) {
        if (parentId == null) {
            parentId = 0;
        }
        List<TreeNode> list = sysOrgMapper.selectTree(parentId, type);

        List<TreeNode> tempList = new ArrayList<>(0);
        for (TreeNode node : list) {
            if (node.getChildrenCount() > 0) {
                node.setIsParent(true);
            }
            tempList.add(node);
        }
        return tempList;

    }

    @Override
    public int checkExist(String name, Integer id) {
        if (StringUtils.isBlank(name)) {
            throw new HttpRuntimeException(ResultEnum.FAIL500.getCode(), "名称不能为空!");
        }
        return sysOrgMapper.selectCountExist(name, id);
    }

}
