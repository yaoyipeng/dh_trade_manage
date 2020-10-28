package com.giao.ssm.service;

import com.giao.ssm.domain.ContractProductC;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品明细service接口
 */
public interface ContractProductCService {
    /**
     * 根据contractId查询货物
     * @param contractId
     * @return
     */
    List<ContractProductC> findAllByContractId(String contractId);
    /**
     * 添加货物
     * @param contractProductC
     * @return
     */
    void insertContractProductC(ContractProductC contractProductC);
    /**
     * 删除货物
     * 级联删除
     * @param contractProductId
     * @param contractId
     * @return
     */
    void deleteContractProductCById(String contractProductId);

    /**
     * 根据id查询一个
     * @return
     */
    ContractProductC findContractProductCById(String contractProductId);
    /**
     * 修改货物
     * @param contractProductC
     * @return
     */
    void updateContractProductC(ContractProductC contractProductC);
}
