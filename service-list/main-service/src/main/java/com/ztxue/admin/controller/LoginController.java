package com.ztxue.admin.controller;

import com.ztxue.admin.bean.LoginParams;
import com.ztxue.admin.bean.ResultPermission;
import com.ztxue.admin.bean.ResultUser;
import com.ztxue.admin.entity.SysOrg;
import com.ztxue.admin.service.IMenuService;
import com.ztxue.admin.service.ISysOrgService;
import com.ztxue.admin.service.ISysUserAreaService;
import com.ztxue.admin.service.LoginService;
import com.ztxue.admin.service.impl.SysUserAreaServiceImpl;
import com.ztxue.core.result.R;
import com.ztxue.admin.service.impl.LoginServiceImpl;
import com.ztxue.core.utils.AesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/2/10 17:55
 * @describe login
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Value("${spring.encryption.key}")
    private String secretKey;


    private final LoginService service;
    private final ISysUserAreaService sysUserAreaServiceImpl;
    private final ISysOrgService sysOrgServiceImpl;
    private final IMenuService menuServiceImpl;

    public LoginController(LoginService service, ISysUserAreaService sysUserAreaServiceImpl, ISysOrgService sysOrgServiceImpl, IMenuService menuServiceImpl) {
        this.service = service;
        this.sysUserAreaServiceImpl = sysUserAreaServiceImpl;
        this.sysOrgServiceImpl = sysOrgServiceImpl;
        this.menuServiceImpl = menuServiceImpl;
    }

    @PostMapping("login")
    public R<Object> login(@RequestBody LoginParams params) {
        if (params == null) {
            return R.argsNull();
        }
        String userName = params.getUserName();
        if (StringUtils.isBlank(userName)) {
            return R.fail500("用户名不能为空!");
        }
        String password = params.getPassword();
        if (StringUtils.isBlank(password)) {
            return R.fail500("密码不能为空!");
        }
        ResultUser user = service.login(userName, AesUtil.encrypt(password, secretKey));
        if (user == null || user.getId() == null) {
            return R.fail500("用户不存在，用户名或密码错误!");
        }
        //权限按钮
        List<ResultPermission> permissions = menuServiceImpl.permissionList(user.getId());
        //区划
        List<String> areas = sysUserAreaServiceImpl.codeList(user.getId());
        //查询组织机构区划
        SysOrg org = sysOrgServiceImpl.show(user.getOrgId());
        String orgArea = null;

        if (!StringUtils.isBlank(org.getVillage())) {
            orgArea = org.getVillage();
        } else if (!StringUtils.isBlank(org.getTown())) {
            orgArea = org.getTown();
        } else if (!StringUtils.isBlank(org.getCounty())) {
            orgArea = org.getCounty();
        } else if (!StringUtils.isBlank(org.getCity())) {
            orgArea = org.getCity();
        } else if (!StringUtils.isBlank(org.getProvince())) {
            orgArea = org.getProvince();
        }
        user.setAreas(areas);
        user.setOrgArea(orgArea);





        return R.success(user);
    }

}
