package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:批量更新区划 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class AddsAreaParams {
    /**
     * 编码
     */
    private String code;
    /**
     * 区划地址
     */
    private String url;
    /**
     * 线程数,默认1
     */
    private Integer thread;
    /**
     * 覆盖数据,默认false不删除,true删除
     */
    private Boolean cover;


}
