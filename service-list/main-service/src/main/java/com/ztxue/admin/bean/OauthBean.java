package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:Oauth2信息 返回实体
 * @date:2021-08-13
 */
@Setter
@Getter
public class OauthBean {

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expiration;

}
