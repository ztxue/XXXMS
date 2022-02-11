package com.ztxue.admin.service.impl;

import com.ztxue.admin.bean.ResultUser;
import com.ztxue.admin.mapper.SysUserMapper;
import com.ztxue.admin.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author ztxue
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    private final SysUserMapper sysUserMapper;

    public LoginServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public ResultUser login(String userName, String password) {
        return sysUserMapper.selectUser(userName, password);
    }
}
