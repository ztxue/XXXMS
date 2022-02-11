package com.ztxue.admin.bean;


import com.ztxue.admin.entity.SysFile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:sunping
 * @description:文件 参数类
 * @date:2021-04-30
 */
@Setter
@Getter
public class FilesParams {

    /**
     * 名称
     */
    private String pid;
    /**
     * 文件列表
     */
    private List<SysFile> files;

}
