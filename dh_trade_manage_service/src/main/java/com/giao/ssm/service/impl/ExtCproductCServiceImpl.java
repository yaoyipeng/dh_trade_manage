package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ExtCproductCDao;
import com.giao.ssm.dao.FactoryCDao;
import com.giao.ssm.domain.ExtCproductC;
import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.service.ExtCproductCService;
import com.giao.ssm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品附件serviceImpl
 */
@Service
public class ExtCproductCServiceImpl implements ExtCproductCService {


    @Autowired
    private ExtCproductCDao extCproductCDao;


    @Autowired
    private FactoryCDao factoryCDao;
    /**
     * 根据id删除合同商品附件
     * @param extCproductId
     * @return
     */
    @Override
    public void deleteExtCproductCById(String extCproductId) {
        extCproductCDao.deleteExtCproductCById(extCproductId);
    }

    /**
     * 根据外键contractProductId查询多个合同商品附件
     * @param contractProductId
     * @return
     */
    @Override
    public List<ExtCproductC> findMultipleExtCproductCById(String contractProductId) {
        return extCproductCDao.findMultipleExtCproductCById(contractProductId);
    }

    /**
     * 添加合同商品附件
     * @param extCproductC
     * @return
     */
    @Override
    public void insertExtCproductC(ExtCproductC extCproductC) {
        extCproductC.setExtCproductId(UuidUtil.getUuid());
        String fullName = factoryCDao.findFactorycById(extCproductC.getFactoryId()).getFullName();
        extCproductC.setFactory(fullName);
        if (extCproductC.getCnumber()!=null&&extCproductC.getPrice()!=null){
            extCproductC.setAmount((extCproductC.getCnumber())*(extCproductC.getPrice()));
        }
        extCproductCDao.insertExtCproductC(extCproductC);
    }
    /**
     * 根据主键extCproductId查询一个
     * @param extCproductId
     * @return
     */
    @Override
    public ExtCproductC findExtCproductCById(String extCproductId) {
        return extCproductCDao.findExtCproductCById(extCproductId);
    }
    /**
     * 修改商品附件
     * @param extCproductC
     * @return
     */
    @Override
    public void updateExtCproductCById(ExtCproductC extCproductC) {
        String fullName = factoryCDao.findFactorycById(extCproductC.getFactoryId()).getFullName();
        extCproductC.setFactory(fullName);
        if (extCproductC.getCnumber()!=null&&extCproductC.getPrice()!=null){
            extCproductC.setAmount((extCproductC.getCnumber())*(extCproductC.getPrice()));
        }
        extCproductCDao.updateExtCproductCById(extCproductC);
    }


}
