package com.giao.ssm.dao;

import com.giao.ssm.domain.ContractC;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-14 16:37
 * 历史合同dao
 **/
public interface ContractHisCDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select   (select count(*) from CONTRACT_PRODUCT_HIS_C  where CONTRACT_ID=c.CONTRACT_ID) " +
            " as CPNUM,  (select count(*) from EXT_CPRODUCT_HIS_C      " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_HIS_C where CONTRACT_ID=c.CONTRACT_ID)   " +
            "   ) as EXTNUM, " +
            " (       nvl((select sum(CNUMBER*PRICE) as cptotal from CONTRACT_PRODUCT_HIS_C      where CONTRACT_ID =c.CONTRACT_ID),0) " +
            "     +      nvl(      (select sum(CNUMBER*PRICE) as exttotal from EXT_CPRODUCT_HIS_C   " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_HIS_C where CONTRACT_ID=c.CONTRACT_ID))    " +
            "   ,0)  ) as TOTAL_AMOUNT_VIRTUAL," +
            " c.* from CONTRACT_HIS_C c")
    @Results(id="contractHisCMap",value = {
            @Result(id=true,column = "CONTRACT_ID",property = "contractId"),
            @Result(column = "OFFEROR",property = "offeror"),
            @Result(column = "CONTRACT_NO",property = "contractNo"),
            @Result(column = "SIGNING_DATE",property = "signingDate"),
            @Result(column = "INPUT_BY",property = "inputBy"),
            @Result(column = "CHECK_BY",property = "checkBy"),
            @Result(column = "INSPECTOR",property = "inspector"),
            @Result(column = "TOTAL_AMOUNT",property = "totalAmount"),
            @Result(column = "REQUEST",property = "request"),
            @Result(column = "CUSTOM_NAME",property = "customName"),
            @Result(column = "SHIP_TIME",property = "shipTime"),
            @Result(column = "IMPORT_NUM",property = "importNum"),
            @Result(column = "DELIVERY_PERIOD",property = "deliveryPeriod"),
            @Result(column = "REMARK",property = "remark"),
            @Result(column = "PRINT_STYLE",property = "printStyle"),
            @Result(column = "OLD_STATE",property = "oldState"),
            @Result(column = "STATE",property = "state"),
            @Result(column = "OUT_STATE",property = "outState"),
            @Result(column = "CREATE_BY",property = "createBy"),
            @Result(column = "CREATE_DEPT",property = "createDept"),
            @Result(column = "CREATE_TIME",property = "createTime"),
            @Result(column = "TRADE_TERMS",property = "tradeTerms"),
            @Result(column = "CPNUM",property = "cpnum"),
            @Result(column = "EXTNUM",property = "extnum"),
            @Result(column = "TOTAL_AMOUNT_VIRTUAL",property = "totalAmountVirtual")
    })
    List<ContractC> findAll();

    /**
     * 根据主键查询一个
     * 多用于修改
     * @param contractId
     * @return
     */
    @Select("select * from CONTRACT_HIS_C where CONTRACT_ID = #{contractId}")
    @ResultMap("contractHisCMap")
    ContractC findContractCById(String contractId);
}
