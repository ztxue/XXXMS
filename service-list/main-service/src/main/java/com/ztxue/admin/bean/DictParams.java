package com.ztxue.admin.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:sunping
 * @description:数据字典 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class DictParams {

    /**
     * 名称
     */
    private String name;
    /**
     * 标签
     */
    private String tag;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;

}
