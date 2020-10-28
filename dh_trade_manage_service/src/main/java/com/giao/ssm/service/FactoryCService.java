package com.giao.ssm.service;

import com.giao.ssm.domain.FactoryC;

import java.util.List;

/**
 * @author 影耀子
 * 生产工厂service接口
 */
public interface FactoryCService {
    /**
     * 查询全部生产厂家
     * @return
     */
    List<FactoryC> findFactorycAll();

    /**
     * 添加生产厂家
     * @param factoryC
     */
    void insertFactoryc(FactoryC factoryC);

    /**
     * 查询一个
     * @param factoryId
     * @return
     */
    FactoryC findFactorycById(String factoryId);

    /**
     * 修改生产工厂
     * @param factoryC
     */
    void UpdateFactoryc(FactoryC factoryC);

    /**
     * 根据id删除生产厂家
     * @param factoryId
     */
    void deleteFactorycByFactoryId(String factoryId);

    /**
     * 停用生产厂家
     * @param id
     */
    void stopFactoryc(String id);

    /**
     * 启用生产厂家
     * @param id
     */
    void startFactoryc(String id);
}
