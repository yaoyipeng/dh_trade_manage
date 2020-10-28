package com.giao.ssm.service.impl;

import com.giao.ssm.dao.FactoryCDao;
import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.service.FactoryCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 影耀子
 * 生产工厂serviceImpl
 */

@Service
@Transactional
public class FactoryCServiceImpl implements FactoryCService {

    @Autowired
    private FactoryCDao factoryCDao;

    /**
     * 查询全部生产厂家
     * @return
     */
    @Override
    public List<FactoryC> findFactorycAll(){
        return factoryCDao.findFactorycAll();
    }

    /**
     * 添加生产厂家
     * @param factoryC
     */
    @Override
    public void insertFactoryc(FactoryC factoryC) {
        String factoryId = UUID.randomUUID().toString().replace("-", "");
        System.out.println(factoryId);
        factoryC.setFactoryId(factoryId);// 主键uuid
        factoryC.setCreateTime(new Date());// 创建时间
//        factoryC.setCtype(0103);// 类型
        factoryC.setState("1");// 状态默认正常
//        factoryC.setCreateBy("yyp");// 创建人
//        factoryC.setCreateDept("1");// 创建部门;
        factoryCDao.insertFactoryc(factoryC);
    }

    /**
     * 查询一个
     * @param factoryId
     * @return
     */
    @Override
    public FactoryC findFactorycById(String factoryId) {
        return factoryCDao.findFactorycById(factoryId);
    }

    /**
     * 修改生产厂家
     * @param factoryC
     */
    @Override
    public void UpdateFactoryc(FactoryC factoryC) {
//        factoryC.setCtype(0103);// 类型
//        factoryC.setCreateBy("yyp");// 创建人
//        factoryC.setCreateDept("1");// 创建部门;
        factoryCDao.UpdateFactoryc(factoryC);
    }
    /**
     * 根据id删除生产厂家
     * @param factoryId
     */
    @Override
    public void deleteFactorycByFactoryId(String factoryId) {
        factoryCDao.deleteFactorycByFactoryId(factoryId);
    }
    /**
     * 停用生产厂家
     * @param id
     */
    @Override
    public void stopFactoryc(String id) {
        factoryCDao.stopFactoryc(id);
    }

    /**
     * 启用生产厂家
     * @param id
     */
    @Override
    public void startFactoryc(String id) {
        factoryCDao.startFactoryc(id);
    }
}
