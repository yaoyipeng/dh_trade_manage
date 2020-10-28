package com.giao.ssm.dao;

import com.giao.ssm.domain.ContractC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * @author 影耀子
 * 购销合同dao
 */
public interface ContractCDao {


    /**
     * 根据id删除
     */
    @Delete("delete from CONTRACT_C where CONTRACT_ID=#{contractId}")
    void deleteContractCById(String contractId);
    /**
     * 查询全部
     * @return
     */
    @Select("select   (select count(*) from CONTRACT_PRODUCT_C  where CONTRACT_ID=c.CONTRACT_ID) " +
            " as CPNUM,  (select count(*) from EXT_CPRODUCT_C      " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_C where CONTRACT_ID=c.CONTRACT_ID)   " +
            "   ) as EXTNUM, " +
            " (       nvl((select sum(CNUMBER*PRICE) as cptotal from CONTRACT_PRODUCT_C      where CONTRACT_ID =c.CONTRACT_ID),0) " +
            "     +      nvl(      (select sum(CNUMBER*PRICE) as exttotal from EXT_CPRODUCT_C   " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_C where CONTRACT_ID=c.CONTRACT_ID))    " +
            "   ,0)  ) as TOTAL_AMOUNT_VIRTUAL," +
            " c.* from CONTRACT_C c")
    @Results(id="ContractCMap",value = {
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
//            @Result(property = "contractProductCS",column = "CONTRACT_ID",many = @Many(select = "com.giao.ssm.dao.ContractProductCDao.findAllByContractId",fetchType = FetchType.LAZY))
    })
    List<ContractC> findContractCAll();
    /**
     * 添加
     */
    @Insert("insert into CONTRACT_C(CONTRACT_ID,OFFEROR,CONTRACT_NO,SIGNING_DATE,INPUT_BY," +
            "CHECK_BY,INSPECTOR,TOTAL_AMOUNT,REQUEST,CUSTOM_NAME," +
            "SHIP_TIME,IMPORT_NUM,DELIVERY_PERIOD,REMARK,PRINT_STYLE," +
            "OLD_STATE,STATE,OUT_STATE,CREATE_BY,CREATE_DEPT,CREATE_TIME,TRADE_TERMS) " +
            "values(#{contractId},#{offeror,jdbcType=VARCHAR},#{contractNo,jdbcType=VARCHAR},#{signingDate},#{inputBy,jdbcType=VARCHAR}," +
            "#{checkBy,jdbcType=VARCHAR},#{inspector,jdbcType=VARCHAR},#{totalAmount,jdbcType=DOUBLE},#{request,jdbcType=VARCHAR},#{customName,jdbcType=VARCHAR}," +
            "#{shipTime},#{importNum,jdbcType=INTEGER},#{deliveryPeriod},#{remark,jdbcType=VARCHAR},#{printStyle,jdbcType=VARCHAR}," +
            "#{oldState,jdbcType=INTEGER},#{state,jdbcType=INTEGER},#{outState,jdbcType=INTEGER},#{createBy,jdbcType=VARCHAR},#{createDept,jdbcType=VARCHAR},#{createTime}," +
            "#{tradeTerms,jdbcType=VARCHAR})")
    void insertContractC(ContractC contractC);
    /**
     * 根据id查询一个，多用于修改
     */
    @Select("select * from CONTRACT_C where CONTRACT_ID=#{contractId}")
    @ResultMap("ContractCMap")
    ContractC findContractCById(String contractId);
    /**
     * 根据id修改
     */
    @Update({
            "<script>",
            "update CONTRACT_C " +
                    "<set>" +
                        "<if test='offeror!=null'>OFFEROR=#{offeror,jdbcType=VARCHAR},</if> " +
                        "<if test='contractNo!=null'>CONTRACT_NO=#{contractNo,jdbcType=VARCHAR},</if> " +
                        "<if test='signingDate!=null'>SIGNING_DATE=#{signingDate},</if> " +
                        "<if test='inputBy!=null'>INPUT_BY=#{inputBy,jdbcType=VARCHAR},</if> " +
                        "<if test='checkBy!=null'>CHECK_BY=#{checkBy,jdbcType=VARCHAR},</if> " +
                        "<if test='inspector!=null'>INSPECTOR=#{inspector,jdbcType=VARCHAR},</if> " +
                        "<if test='totalAmount!=null'>TOTAL_AMOUNT=#{totalAmount,jdbcType=DOUBLE},</if> " +
                        "<if test='request!=null'>REQUEST=#{request,jdbcType=VARCHAR},</if> " +
                        "<if test='customName!=null'>CUSTOM_NAME=#{customName,jdbcType=VARCHAR},</if> " +
                        "<if test='shipTime!=null'>SHIP_TIME=#{shipTime},</if> " +
                        "<if test='importNum!=null'>IMPORT_NUM=#{importNum,jdbcType=INTEGER},</if> " +
                        "<if test='deliveryPeriod!=null'>DELIVERY_PERIOD=#{deliveryPeriod},</if> " +
                        "<if test='remark!=null'>REMARK=#{remark,jdbcType=VARCHAR},</if> " +
                        "<if test='printStyle!=null'>PRINT_STYLE=#{printStyle,jdbcType=VARCHAR},</if> " +
                        "<if test='oldState!=null'>OLD_STATE=#{oldState,jdbcType=INTEGER},</if> " +
                        "<if test='state!=null'>STATE=#{state,jdbcType=INTEGER},</if> " +
                        "<if test='outState!=null'>OUT_STATE=#{outState,jdbcType=INTEGER},</if> " +
                        "<if test='createBy!=null'>CREATE_BY=#{createBy,jdbcType=VARCHAR},</if> " +
                        "<if test='createDept!=null'>CREATE_DEPT=#{createDept,jdbcType=VARCHAR},</if> " +
                        "<if test='tradeTerms!=null'>TRADE_TERMS=#{tradeTerms,jdbcType=VARCHAR},</if> " +
                    "</set>" +
                    " where CONTRACT_ID=#{contractId}",
            "</script>"
    })
    void updateContractCById(ContractC contractC);

    /**
     * 上报合同
     * @param contractId
     */
    @Update("update CONTRACT_C set STATE=1 where CONTRACT_ID=#{contractId}")
    void updateContractCState(String contractId);
    /**
     * 取消上报合同
     * @param contractId
     */
    @Update("update CONTRACT_C set STATE=0 where CONTRACT_ID=#{contractId}")
    void updateCancelStateById(String contractId);

    /**
     *打印
     * @param contractId
     * @return
     */
    @Select("select c.contract_id,c.offeror,c.contract_no,c.signing_date,c.input_by,c.check_by," +
            "c.inspector,c.total_amount,c.import_num,c.request,c.custom_name,c.delivery_period," +
            "c.ship_time,c.trade_terms,c.remark,c.print_style,c.old_state,c.state,c.out_state," +
            "c.create_by,c.create_dept,c.create_time," +
            "t.contract_product_id,t.product_no,t.product_image,t.product_desc,t.cnumber,t.out_number," +
            "t.loading_rate,t.box_num,t.packing_unit,t.price,t.amount,t.finished,t.ex_unit,t.order_no," +
            "t.factory_id,t.full_name,t.factory_name,t.contactor,t.phone,t.ext_cproduct_id,t.ctype," +
            "t.ext_product_no,t.ext_product_image,t.ext_product_desc,t.ext_cnumber,t.ext_packing_unit," +
            "t.ext_price,t.ext_amount,t.product_request,t.ext_order_no,t.ext_factory_id,t.ext_full_name," +
            "t.ext_factory_name,t.ext_contactor,t.ext_phone from (" +
            "select contract_id,offeror,contract_no,signing_date,input_by,check_by,inspector,total_amount," +
            "import_num,request,custom_name,delivery_period,ship_time,trade_terms,remark,print_style," +
            "old_state,state,out_state,create_by,create_dept,create_time from contract_c) c left join (" +
            "select cp.contract_product_id,cp.contract_id,cp.product_no,cp.product_image,cp.product_desc," +
            "cp.cnumber,cp.out_number,cp.loading_rate,cp.box_num,cp.packing_unit,cp.price,cp.amount," +
            "cp.finished,cp.ex_unit,cp.order_no,cp.factory_id,cp.full_name,cp.factory_name,cp.contactor," +
            "cp.phone,ext.ext_cproduct_id,ext.ctype,ext.product_no as ext_product_no,ext.product_image as ext_product_image," +
            "ext.product_desc as ext_product_desc,ext.cnumber as ext_cnumber,ext.packing_unit as ext_packing_unit," +
            "ext.price as ext_price,ext.amount as ext_amount,ext.product_request,ext.order_no as ext_order_no," +
            "ext.factory_id as ext_factory_id,ext.full_name as ext_full_name,ext.factory_name as ext_factory_name," +
            "ext.contactor as ext_contactor,ext.phone as ext_phone from (select cp.contract_product_id,cp.contract_id," +
            "cp.product_no,cp.product_image,cp.product_desc,cp.cnumber,cp.out_number,cp.loading_rate,cp.box_num," +
            "cp.packing_unit,cp.price,cp.amount,cp.finished,cp.ex_unit,cp.order_no,f.factory_id,f.full_name," +
            "f.factory_name,f.contactor,f.phone from " +
            "(select contract_product_id,contract_id,factory_id,product_no,product_image,product_desc,cnumber," +
            "out_number,loading_rate,box_num,packing_unit,price,amount,finished,ex_unit,order_no from contract_product_c)" +
            " cp left join (select factory_id,full_name,factory_name,contactor,phone from factory_c) " +
            "f on cp.factory_id=f.factory_id) cp left join " +
            "(select ext.ext_cproduct_id,ext.contract_product_id,ext.ctype,ext.product_no,ext.product_image," +
            "ext.product_desc,ext.cnumber,ext.packing_unit,ext.price,ext.amount,ext.product_request,ext.order_no," +
            "f.factory_id,f.full_name,f.factory_name,f.contactor,f.phone from " +
            "(select ext_cproduct_id,contract_product_id,factory_id,ctype,product_no,product_image," +
            "product_desc,cnumber,packing_unit,price,amount,product_request,order_no from ext_cproduct_c)" +
            " ext left join (select factory_id,full_name,factory_name,contactor,phone from factory_c) f " +
            "on ext.factory_id=f.factory_id) ext on cp.contract_product_id=ext.contract_product_id) t " +
            "on c.contract_id=t.contract_id where c.contract_id=#{contractId,jdbcType=VARCHAR}")
    @Results(value = {
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
            @Result(property = "contractProductCS",column = "CONTRACT_ID",many = @Many(select = "com.giao.ssm.dao.ContractProductCDao.findMultipleByContractId",fetchType = FetchType.LAZY))
    })
    List<ContractC> view(String contractId);

    /**
     * 根据state状态查询（0草稿 1上报）
     * @param state
     * @return
     */
    @Select("select   (select count(*) from CONTRACT_PRODUCT_C  where CONTRACT_ID=c.CONTRACT_ID) " +
            " as CPNUM,  (select count(*) from EXT_CPRODUCT_C      " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_C where CONTRACT_ID=c.CONTRACT_ID)   " +
            "   ) as EXTNUM, " +
            " (       nvl((select sum(CNUMBER*PRICE) as cptotal from CONTRACT_PRODUCT_C      where CONTRACT_ID =c.CONTRACT_ID),0) " +
            "     +      nvl(      (select sum(CNUMBER*PRICE) as exttotal from EXT_CPRODUCT_C   " +
            "    where CONTRACT_PRODUCT_ID in " +
            "(select CONTRACT_PRODUCT_ID from CONTRACT_PRODUCT_C where CONTRACT_ID=c.CONTRACT_ID))    " +
            "   ,0)  ) as TOTAL_AMOUNT_VIRTUAL," +
            " c.* from CONTRACT_C c where c.state=#{state,jdbcType=INTEGER}")
    @ResultMap("ContractCMap")
    List<ContractC> findContractCByCondition(Integer state);

}
