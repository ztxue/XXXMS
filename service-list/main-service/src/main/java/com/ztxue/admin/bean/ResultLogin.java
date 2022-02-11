package com.ztxue.admin.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:登录信息返回实体
 * @date:2021-07-28
 */
@Setter
@Getter
public class ResultLogin {


    /**
     * 人员信息
     */
    @JSONField(ordinal = 1)
    private ResultUser user;
    /**
     * 权限按钮
     */
    @JSONField(ordinal = 5)
    private List<ResultPermission> permissions;
    /**
     * 凭证信息
     */
    @JSONField(ordinal = 2)
    private OauthBean oauth;

}
