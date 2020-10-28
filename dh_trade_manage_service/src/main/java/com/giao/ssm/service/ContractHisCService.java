package com.giao.ssm.service;


import com.giao.ssm.domain.ContractC;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-14 15:47
 * 历史合同表CONTRACT_HIS_C业务层接口
 **/
public interface ContractHisCService {
    void pigeinhole(String[] contractIds);		//归档
    void pigeouthole(String[] contractIds);		//取消归档

    List<ContractC> findAll();       // 查询所有历史列表
    ContractC findContractCById(String contractId);     // 根据主键id查询一个
}
