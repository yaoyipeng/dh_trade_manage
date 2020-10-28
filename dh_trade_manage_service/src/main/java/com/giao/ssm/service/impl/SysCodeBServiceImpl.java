package com.giao.ssm.service.impl;

import com.giao.ssm.dao.SysCodeBDao;
import com.giao.ssm.domain.SysCodeB;
import com.giao.ssm.service.SysCodeBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 影耀子
 * Sys分类表serviceImpl
 */
@Service
public class SysCodeBServiceImpl implements SysCodeBService {

    @Autowired
    private SysCodeBDao sysCodeBDao;

    /**
     * 查询全部分类表
     * @return
     */
    @Override
    public List<SysCodeB> findSysCodeBAll() {
        return sysCodeBDao.findSysCodeBAll();
    }

}
