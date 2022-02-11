package com.ztxue.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztxue.admin.entity.SysUserArea;
import com.ztxue.admin.mapper.SysUserAreaMapper;
import com.ztxue.admin.service.ISysUserAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:sunping
 * @description:人员区划关系 ServiceImpl
 * @date:2021-07-28
 */
@Slf4j
@Service
public class SysUserAreaServiceImpl extends ServiceImpl<SysUserAreaMapper, SysUserArea> implements ISysUserAreaService {

    private final SysUserAreaMapper sysUserAreaMapper;

    public SysUserAreaServiceImpl(SysUserAreaMapper sysUserAreaMapper) {
        this.sysUserAreaMapper = sysUserAreaMapper;
    }


    @Override
    public List<SysUserArea> areaList(Integer userId) {
        return sysUserAreaMapper.selectAreasByUserId(userId);
    }

    @Override
    public List<String> codeList(Integer userId) {
        return sysUserAreaMapper.selectCodesByUserId(userId);
    }

    @Override
    public int update(Integer userId, List<SysUserArea> areas) {
        List<String> codes = new ArrayList<>(0);
        if (areas != null && !areas.isEmpty()) {
            for (SysUserArea area : areas) {
                codes.add(area.getAreaCode());
            }
        }
        List<String> list = sysUserAreaMapper.selectCodesByUserId(userId);
        //删除多余区划
        List<String> deleteCodes = new ArrayList<>(list);
        deleteCodes.removeAll(codes);

        //新增区划
        List<String> addCodes = new ArrayList<>(codes);
        addCodes.removeAll(list);
        int count = 0;
        //删除多余区划
        if (!deleteCodes.isEmpty()) {
            count = sysUserAreaMapper.deleteByCodes(userId, deleteCodes);
        }
        //新增区划
        if (!addCodes.isEmpty()) {
            List<SysUserArea> addAreas = new ArrayList<>(0);
            for (SysUserArea area : areas) {
                for (String code : addCodes) {
                    if (code.equals(area.getAreaCode())) {
                        addAreas.add(area);
                        break;
                    }
                }
            }
            count = sysUserAreaMapper.insertUserAreas(userId, addAreas);
        }
        return count;
    }
}
