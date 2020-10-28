package com.giao.ssm.service;

import com.giao.ssm.domain.ExtCproductC;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品附件service接口
 */
public interface ExtCproductCService {
    /**
     * 根据外键contractProductId查询多个合同商品附件
     * @param contractProductId
     * @return
     */
    List<ExtCproductC> findMultipleExtCproductCById(String contractProductId);
    /**
     * 根据id删除合同商品附件
     * @param extCproductId
     * @param contractProductId
     * @return
     */
    void deleteExtCproductCById(String extCproductId);
    /**
     * 添加合同商品附件
     * @param extCproductC
     * @return
     */
    void insertExtCproductC(ExtCproductC extCproductC);

    /**
     * 根据主键extCproductId查询一个
     * @param extCproductId
     * @return
     */
    ExtCproductC findExtCproductCById(String extCproductId);
    /**
     * 修改商品附件
     * @param extCproductC
     * @return
     */
    void updateExtCproductCById(ExtCproductC extCproductC);
}
