package com.giao.ssm.service;

import com.giao.ssm.domain.ContractC;

import java.util.List;

/**
 * @author 影耀子
 * 购销合同service接口
 */
public interface ContractCService {
    /**
     * 查询全部
     * @return
     */
    List<ContractC> findContractCAll();
    /**
     * 添加购销合同
     * @param contractC
     * @return
     */
    void insertContractC(ContractC contractC);
    /**
     * 删除
     * @param id
     * @return
     */
    void deleteContractCById(String contractId);
    /**
     * 批量上报
     */
    void updateStateById(String id);

    /**
     * 根据id查询一个
     * @param contractId
     * @return
     */
    ContractC findContractCById(String contractId);
    /**
     * 根据id修改
     * @param contractC
     * @return
     */
    void updateContractC(ContractC contractC);

    /**
     * 批量取消
     * @param id
     */
    void updateCancelStateById(String id);

    /**
     * 打印
     * @param id
     * @return
     */
    List<ContractC> view(String id);
}
