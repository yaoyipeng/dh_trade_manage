package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ContractProductCDao;
import com.giao.ssm.dao.ExtCproductCDao;
import com.giao.ssm.dao.FactoryCDao;
import com.giao.ssm.domain.ContractC;
import com.giao.ssm.domain.ContractProductC;
import com.giao.ssm.domain.ExtCproductC;
import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品明细serviceImpl
 */
@Service
public class ContractProductCServiceImpl implements ContractProductCService {

    @Autowired
    private ContractProductCDao contractProductCDao;
    @Autowired
    private FactoryCDao factoryCDao;

    @Autowired
    private ExtCproductCDao extCproductCDao;
    /**
     * 根据contractId查询货物
     * @param contractId
     * @return
     */
    @Override
    public List<ContractProductC> findAllByContractId(String contractId) {
        return contractProductCDao.findAllByContractId(contractId);
    }
    /**
     * 添加货物
     * @param contractProductC
     * @return
     */
    @Override
    public void insertContractProductC(ContractProductC contractProductC) {
//        System.out.println((contractProductC.getCnumber())*(contractProductC.getPrice()));
//        System.out.println(UuidUtil.getUuid());
//        System.out.println(contractProductC.getContractId());
        contractProductC.setContractProductId(UuidUtil.getUuid());
        FactoryC factoryc = factoryCDao.findFactorycById(contractProductC.getFactoryId());
        contractProductC.setFactory(factoryc.getFullName());
        if (contractProductC.getCnumber()!=null&&contractProductC.getPrice()!=null){
            contractProductC.setAmount((contractProductC.getCnumber())*(contractProductC.getPrice()));
        }
        contractProductCDao.insertContractProductC(contractProductC);
    }
    /**
     * 删除货物
     * @param contractProductId
     * @param contractId
     * @return
     */
    @Override
    public void deleteContractProductCById(String contractProductId) {
        if (extCproductCDao.findMultipleExtCproductCById(contractProductId)!=null){
            // 删除多个，级联删除
            extCproductCDao.deleteMultipleExtCproductCByContractProductId(contractProductId);
        }
        contractProductCDao.deleteContractProductCById(contractProductId);
    }

    /**
     * 根据id查询一个
     * @return
     */
    @Override
    public ContractProductC findContractProductCById(String contractProductId) {
        return contractProductCDao.findContractProductCById(contractProductId);
    }
    /**
     * 修改货物
     * @param contractProductC
     * @return
     */
    @Override
    public void updateContractProductC(ContractProductC contractProductC) {
        FactoryC factoryc = factoryCDao.findFactorycById(contractProductC.getFactoryId());
        contractProductC.setFactory(factoryc.getFullName());
        if (contractProductC.getCnumber()!=null&&contractProductC.getPrice()!=null){
            contractProductC.setAmount((contractProductC.getCnumber())*(contractProductC.getPrice()));
        }
        contractProductCDao.updateContractProductC(contractProductC);
    }

}
