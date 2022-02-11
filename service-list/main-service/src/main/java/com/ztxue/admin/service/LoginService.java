package com.ztxue.admin.service;

import com.ztxue.admin.bean.ResultUser;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/2/10 17:56
 * @describe
 */

public interface LoginService {

    /**
     * 登录
     */
    ResultUser login(String userName, String password);
}
