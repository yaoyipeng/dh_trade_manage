package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ContractHisCDao;
import com.giao.ssm.domain.ContractC;
import com.giao.ssm.extend.Contract;
import com.giao.ssm.service.ContractHisCService;
import com.giao.ssm.utils.SqlDao;
import com.giao.ssm.utils.UtilFuns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-14 15:48
 * 历史合同表CONTRACT_HIS_C业务层
 **/
@Service
public class ContractHisCServiceImpl implements ContractHisCService {

    @Resource
    private SqlDao sqlDao;
    @Resource
    private ContractHisCDao contractHisDao;
    //归档
    @Override
    public void pigeinhole(String[] contractIds) {
        sqlDao.batchSQL(this.doData(contractIds, "", "_his"));
    }
    //取消归档
    @Override
    public void pigeouthole(String[] contractIds) {
        sqlDao.batchSQL(this.doData(contractIds, "_his", ""));
    }

    @Override
    public List<ContractC> findAll() {
        return contractHisDao.findAll();
    }

    @Override
    public ContractC findContractCById(String contractId) {
        return contractHisDao.findContractCById(contractId);
    }

    //处理数据：有源表向目标表复制数据，将源表数据删除
    public String[] doData(String[] contractIds, String source, String target){
        StringBuffer sBuf = new StringBuffer();
        String inStr = UtilFuns.joinStr(contractIds, "'", "'", ",");			//合同的id串 x,y ，构造成in子查询串 'x','y'

        sBuf.append("insert into contract").append(target).append("_c (select * from contract").append(source).append("_c where contract_id in (").append(inStr).append("));");
        sBuf.append("insert into contract_product").append(target).append("_c (select * from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
        sBuf.append("insert into ext_cproduct").append(target).append("_c (select * from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(")));");

        sBuf.append("delete from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
        sBuf.append("delete from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(");");
        sBuf.append("delete from contract").append(source).append("_c where contract_id in (").append(inStr).append(");");

        return sBuf.toString().split(";");
    }
}
