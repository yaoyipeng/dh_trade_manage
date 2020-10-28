package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ContractCDao;
import com.giao.ssm.dao.ContractProductCDao;
import com.giao.ssm.dao.ExtCproductCDao;
import com.giao.ssm.domain.ContractC;
import com.giao.ssm.domain.ContractProductC;
import com.giao.ssm.domain.ExtCproductC;
import com.giao.ssm.service.ContractCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 影耀子
 * 购销合同serviceImpl
 */
@Service
public class ContractCServiceImpl implements ContractCService {

    @Autowired
    private ContractCDao contractCDao;

    @Autowired
    private ContractProductCDao contractProductCDao;

    @Autowired
    private ExtCproductCDao extCproductCDao;
    /**
     * 查询全部
     * @return
     */
    @Override
    public List<ContractC> findContractCAll() {
        List<ContractC> contractCAll = contractCDao.findContractCAll();
        for (ContractC contractC : contractCAll) {
            // 将修改后发生变化的总价格保存到数据库
            contractC.setTotalAmount(contractC.getTotalAmountVirtual());
            contractCDao.updateContractCById(contractC);
        }
        return contractCAll;
    }

    /**
     * 添加购销合同
     * @param contractC
     * @return
     */
    @Override
    public void insertContractC(ContractC contractC) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        contractC.setContractId(replace);
        contractC.setCreateTime(new Date());
        contractCDao.insertContractC(contractC);
    }
    /**
     * 删除
     * @param contractId
     * @return
     */
    @Override
    public void deleteContractCById(String contractId) {
        //根据contractId查询多个
        List<ContractProductC> ContractProductCAllByContractId = contractProductCDao.findAllByContractId(contractId);
        if (ContractProductCAllByContractId !=null){
            //遍历ContractProductC。拿到contractProductId
            for (ContractProductC contractProductC : ContractProductCAllByContractId) {
                String contractProductId = contractProductC.getContractProductId();
                if (extCproductCDao.findMultipleExtCproductCById(contractProductId)!=null){
                    // 删除多个，级联删除
                    extCproductCDao.deleteMultipleExtCproductCByContractProductId(contractProductId);
                }
            }
            contractProductCDao.deleteMultipleContractProductCByContractId(contractId);
        }
        contractCDao.deleteContractCById(contractId);
    }

    /**
     * 上报
     * @param id
     */
    @Override
    public void updateStateById(String id) {
        contractCDao.updateContractCState(id);
    }

    /**
     * 根据id查询一个购销合同及合同明细和合同附件
     * @param contractId
     * @return
     */
    @Override
    public ContractC findContractCById(String contractId) {
        // 根据主键id查询购销合同
        ContractC contractC = contractCDao.findContractCById(contractId);
        // 根据购销合同的主键id查询多个合同明细（货物）
        List<ContractProductC> contractProductCS = contractProductCDao.findAllByContractId(contractId);
        for (ContractProductC contractProductC : contractProductCS) {
            // 根据合同明细的主键id查询多个合同商品附件
            String contractProductId = contractProductC.getContractProductId();
            List<ExtCproductC> multipleExtCproductCById = extCproductCDao.findMultipleExtCproductCById(contractProductId);
            contractProductC.setExtCproductCS(multipleExtCproductCById);
        }
        contractC.setContractProductCS(contractProductCS);
        return contractC;
    }
    /**
     * 根据id修改
     * @param contractC
     * @return
     */
    @Override
    public void updateContractC(ContractC contractC) {
        contractCDao.updateContractCById(contractC);
    }
    /**
     * 取消上报
     * @param id
     */
    @Override
    public void updateCancelStateById(String id) {
        contractCDao.updateCancelStateById(id);
    }
    /**
     * 打印
     * @param id
     * @return
     */
    @Override
    public List<ContractC> view(String contractId) {
        return contractCDao.view(contractId);
    }
}
