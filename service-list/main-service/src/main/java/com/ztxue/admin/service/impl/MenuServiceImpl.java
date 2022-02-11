package com.ztxue.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztxue.admin.bean.MenuBean;
import com.ztxue.admin.bean.MetaBean;
import com.ztxue.admin.bean.ResultMenu;
import com.ztxue.admin.bean.ResultPermission;
import com.ztxue.admin.entity.SysRes;
import com.ztxue.admin.mapper.MenuMapper;
import com.ztxue.admin.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:sunping
 * @description:资源菜单 ServiceImpl
 * @date:2021-05-19
 */
@Slf4j
@Service("menuServiceImpl")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysRes> implements IMenuService {

    private final MenuMapper menuMapper;
    /**
     * 斜杠
     */
    private static final String SLASH = "/";

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public ResultMenu menuList(Integer userId) {
        ResultMenu menu = new ResultMenu();
        menu.setRouter("root");
        List<ResultMenu> list = selectRecursion(0, userId, 0);
        menu.setChildren(list);
        return menu;
    }

    /**
     * 递归查询资源菜单
     *
     * @param parentId
     * @param userId
     * @param n
     * @return
     */
    private List<ResultMenu> selectRecursion(Integer parentId, Integer userId, int n) {
        int m = n;
        m++;
        List<ResultMenu> menus = new ArrayList<>();
        List<MenuBean> list = menuMapper.selectMenuList(parentId, userId);
        if (list.isEmpty()) {
            return menus;
        }
        for (int i = 0; i < list.size(); i++) {
            MenuBean menuBean = list.get(i);
            ResultMenu menu = new ResultMenu();
            menu.setRouter(menuBean.getId().toString());
            menu.setName(menuBean.getName());
            menu.setIcon(menuBean.getIconCls());
            String page = addSlash(menuBean.getPage());
            menu.setPageView(page);
            boolean invisible = false;
            if (menuBean.getInvisible() != null && menuBean.getInvisible() == 1) {
                invisible = true;
            }
            menu.setInvisible(invisible);
            String url = menuBean.getUrl();
            boolean isLink = !StringUtils.isBlank(url) && (url.startsWith("http://") || url.startsWith("https://"));
            if (isLink) {
                menu.setLink(url);
            } else {
                String path = addSlash(url);
                menu.setPath(path);
            }
            List<ResultMenu> children = getChildren(menuBean.getChildren(), menuBean.getId(), userId, m);
            menu.setChildren(children);
            MetaBean meta = new MetaBean();
            meta.setAuthority(menuBean.getId().toString());
            menu.setMeta(meta);
            menus.add(menu);
        }
        return menus;
    }

    /**
     * 添加斜杠
     *
     * @param url
     * @return
     */
    private String addSlash(String url) {
        if (!StringUtils.isBlank(url) && !url.startsWith(SLASH)) {
            url = SLASH + url;
        }
        return url;
    }

    private List<ResultMenu> getChildren(int childrenCount, Integer parentId, Integer userId, int m) {
        if (childrenCount > 0) {
            List<ResultMenu> children = selectRecursion(parentId, userId, m);
            if (!children.isEmpty()) {
                return children;
            }
        }
        return new ArrayList<>(0);
    }


    @Override
    public List<ResultPermission> permissionList(Integer userId) {
        List<ResultPermission> list = new ArrayList<>(0);
        List<SysRes> permissions = menuMapper.selectPermissions(userId);
        if (permissions.isEmpty()) {
            return list;
        }
        Iterator<SysRes> iterator = permissions.iterator();
        while (iterator.hasNext()) {
            SysRes res = iterator.next();
            Integer type = res.getType();
            String code = res.getCode();
            String id = res.getId().toString();
            String parentId = res.getParentId().toString();
            if (type != null && type == 0) {
                ResultPermission resultPermission = new ResultPermission();
                resultPermission.setId(id);
                List<String> permission = new ArrayList<>(0);
                resultPermission.setOperation(permission);
                list.add(resultPermission);
                continue;
            }
            if (!StringUtils.isBlank(code)) {
                addPermission(list, code, parentId);
            }
        }
        return list;
    }

    /**
     * 添加权限到集合
     *
     * @param list
     * @param code
     * @param parentId
     */
    private void addPermission(List<ResultPermission> list, String code, String parentId) {
        boolean matching = false;
        for (int i = 0, n = list.size(); i < n; i++) {
            ResultPermission resultPermission = list.get(i);
            if (resultPermission.getId().equals(parentId)) {
                List<String> permission = resultPermission.getOperation();
                permission.add(code);
                resultPermission.setOperation(permission);
                list.set(i, resultPermission);
                matching = true;
                break;
            }
        }
        if (!matching) {
            ResultPermission resultPermission = new ResultPermission();
            resultPermission.setId(parentId);
            List<String> permission = new ArrayList<>(0);
            permission.add(code);
            resultPermission.setOperation(permission);
            list.add(resultPermission);
        }
    }

}
