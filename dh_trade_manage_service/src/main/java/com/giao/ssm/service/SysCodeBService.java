package com.giao.ssm.service;

import com.giao.ssm.domain.SysCodeB;

import java.util.List;

/**
 * @author 影耀子
 * sys分类表service接口
 */
public interface SysCodeBService {
    /**
     * 查询全部分类表
     * @return
     */
    List<SysCodeB> findSysCodeBAll();
}
