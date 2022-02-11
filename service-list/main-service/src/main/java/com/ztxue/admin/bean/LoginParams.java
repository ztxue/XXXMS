package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:登录信息 参数类
 * @date:2021-02-02
 */
@Setter
@Getter
public class LoginParams {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
