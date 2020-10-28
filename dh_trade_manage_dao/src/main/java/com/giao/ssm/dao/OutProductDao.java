package com.giao.ssm.dao;

import com.giao.ssm.vo.OutProductVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-02 15:13
 * 打印出货表dao
 **/
public interface OutProductDao {

    /**
     * 按船期查询某个月的购销合同统计
     * @param inputDate
     * @return
     */
    @Select("select c.custom_name,c.contract_no,to_char(c.delivery_period,'yyyy-MM-dd') " +
            "as delivery_period,to_char(c.ship_time,'yyyy-MM-dd') " +
            "as ship_time,c.trade_terms, cp.product_no,concat(cp.cnumber,cp.packing_unit) " +
            "as cnumber,cp.factory from " +
            "(select contract_id,custom_name,contract_no,delivery_period,ship_time,trade_terms from contract_c) c " +
            "left join (select contract_id,product_no,cnumber,packing_unit,factory from contract_product_c) cp" +
            " on c.contract_id=cp.contract_id where to_char(c.ship_time,'yyyy-MM') = #{inputDate}")
    @Results(id = "outProductRM",value = {
            @Result(column = "CUSTOM_NAME",property = "customName"),
            @Result(column = "CONTRACT_NO",property = "contractNo"),
            @Result(column = "PRODUCT_NO",property = "productNo"),
            @Result(column = "CNUMBER",property = "cnumber"),
            @Result(column = "FACTORY",property = "factory"),
            @Result(column = "DELIVERY_PERIOD",property = "deliveryPeriod"),
            @Result(column = "SHIP_TIME",property = "shipTime"),
            @Result(column = "TRADE_TERMS",property = "tradeTerms")
    })
    List<OutProductVO> findContractCByShipTime(String inputDate);
}
