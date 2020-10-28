package com.giao.ssm.dao;

import com.giao.ssm.domain.ExportC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 20:31
 * 报运单dao
 **/
public interface ExportCDao {

    /**
     *  查询报运单
     * @return
     */
    @Select("select " +
            "(select count(*) from export_product_c where export_id=e.export_id)  as epnum," +
            "(select count(*) from ext_eproduct_c where export_product_id in " +
            "(select export_product_id from export_product_c where export_id=e.export_id)) as extnum," +
            "e.export_id,e.input_date,e.contract_ids,e.customer_contract,e.lcno,e.consignee,e.marks," +
            "e.remark,e.shipment_port,e.destination_port,e.transport_mode,e.price_condition," +
            "e.gross_weight,e.net_weight,e.state from export_c e")
    @Results(id = "ExportCMap", value = {
            @Result(id = true,column = "EXPORT_ID",property = "exportId"),
            @Result(column = "EPNUM",property = "cpnum"),
            @Result(column = "EXTNUM",property = "extnum"),
            @Result(column = "INPUT_DATE",property = "inputDate"),
            @Result(column = "CONTRACT_IDS",property = "contractIds"),
            @Result(column = "CUSTOMER_CONTRACT",property = "customerContract"),
            @Result(column = "LCNO",property = "lcno"),
            @Result(column = "CONSIGNEE",property = "consignee"),
            @Result(column = "MARKS",property = "marks"),
            @Result(column = "REMARK",property = "remark"),
            @Result(column = "SHIPMENT_PORT",property = "shipmentPort"),
            @Result(column = "DESTINATION_PORT",property = "destinationPort"),
            @Result(column = "TRANSPORT_MODE",property = "transportMode"),
            @Result(column = "PRICE_CONDITION",property = "priceCondition"),
            @Result(column = "GROSS_WEIGHT",property = "grossWeight"),
            @Result(column = "NET_WEIGHT",property = "netWeight"),
            @Result(column = "STATE",property = "state"),
            @Result(column = "CREATE_BY",property = "createBy"),
            @Result(column = "CREATE_DEPT",property = "createDept"),
            @Result(column = "CREATE_TIME",property = "createTime")
    })
    List<ExportC> find();

    /**
     * 添加数据
     * @param export
     */
    @Insert("insert into EXPORT_C(EXPORT_ID,INPUT_DATE,CONTRACT_IDS,CUSTOMER_CONTRACT,LCNO," +
            "CONSIGNEE,MARKS,SHIPMENT_PORT,DESTINATION_PORT,TRANSPORT_MODE," +
            "PRICE_CONDITION,REMARK,BOX_NUM,CNUMBER,PACKING_UNIT," +
            "GROSS_WEIGHT,NET_WEIGHT,SIZE_LENGHT,SIZE_WIDTH,SIZE_HEIGHT," +
            "CSIZE,AMOUNT,NO_TAX,TAX,COST_PRICE," +
            "COST_TAX,STATE,CREATE_BY,CREATE_DEPT,CREATE_TIME) " +
            "values(#{exportId,jdbcType=VARCHAR},#{inputDate},#{contractIds,jdbcType=VARCHAR},#{customerContract,jdbcType=VARCHAR},#{lcno,jdbcType=VARCHAR}," +
            "#{consignee,jdbcType=VARCHAR},#{marks,jdbcType=VARCHAR},#{shipmentPort,jdbcType=VARCHAR},#{destinationPort,jdbcType=VARCHAR},#{transportMode,jdbcType=VARCHAR}," +
            "#{priceCondition,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR},#{boxNum,jdbcType=INTEGER},#{cnumber,jdbcType=INTEGER},#{packingUnit,jdbcType=VARCHAR}," +
            "#{grossWeight,jdbcType=DOUBLE},#{netWeight,jdbcType=DOUBLE},#{sizeLenght,jdbcType=DOUBLE},#{sizeWidth,jdbcType=DOUBLE},#{sizeHeight,jdbcType=DOUBLE}," +
            "#{csize,jdbcType=DOUBLE},#{amount,jdbcType=DOUBLE},#{noTax,jdbcType=DOUBLE},#{tax,jdbcType=DOUBLE},#{costPrice,jdbcType=DOUBLE}," +
            "#{costTax,jdbcType=DOUBLE},#{state,jdbcType=INTEGER},#{createBy,jdbcType=VARCHAR},#{createDept,jdbcType=VARCHAR},#{createTime})")
    void insert(ExportC export);
    /**
     * 根据exportId查询一个，多用于修改
     * @param exportId
     * @return
     */
    @Select("select * from export_c where export_id=#{exportId}")
    @Results(id = "ExportCAllMap", value = {
            @Result(id = true,column = "EXPORT_ID",property = "exportId"),
            @Result(column = "INPUT_DATE",property = "inputDate"),
            @Result(column = "CONTRACT_IDS",property = "contractIds"),
            @Result(column = "CUSTOMER_CONTRACT",property = "customerContract"),
            @Result(column = "LCNO",property = "lcno"),
            @Result(column = "CONSIGNEE",property = "consignee"),
            @Result(column = "MARKS",property = "marks"),
            @Result(column = "SHIPMENT_PORT",property = "shipmentPort"),
            @Result(column = "DESTINATION_PORT",property = "destinationPort"),
            @Result(column = "TRANSPORT_MODE",property = "transportMode"),
            @Result(column = "PRICE_CONDITION",property = "priceCondition"),
            @Result(column = "REMARK",property = "remark"),
            @Result(column = "BOX_NUM",property = "boxNum"),
            @Result(column = "CNUMBER",property = "cnumber"),
            @Result(column = "PACKING_UNIT",property = "packingUnit"),
            @Result(column = "GROSS_WEIGHT",property = "grossWeight"),
            @Result(column = "NET_WEIGHT",property = "netWeight"),
            @Result(column = "SIZE_LENGHT",property = "sizeLenght"),
            @Result(column = "SIZE_WIDTH",property = "sizeWidth"),
            @Result(column = "SIZE_HEIGHT",property = "sizeHeight"),
            @Result(column = "CSIZE",property = "csize"),
            @Result(column = "AMOUNT",property = "amount"),
            @Result(column = "NO_TAX",property = "noTax"),
            @Result(column = "TAX",property = "tax"),
            @Result(column = "COST_PRICE",property = "costPrice"),
            @Result(column = "COST_TAX",property = "costTax"),
            @Result(column = "STATE",property = "state"),
            @Result(column = "CREATE_BY",property = "createBy"),
            @Result(column = "CREATE_DEPT",property = "createDept"),
            @Result(column = "CREATE_TIME",property = "createTime")
    })
    ExportC findById(String exportId);

    /**
     * 修改报运单
     * @param exportC
     */
    @Update({
            "<script>",
            "update EXPORT_C " +
                    "<set>" +
                    "<if test='inputDate!=null'>INPUT_DATE=#{inputDate},</if> " +
                    "<if test='lcno!=null'>LCNO=#{lcno,jdbcType=VARCHAR},</if> " +
                    "<if test='consignee!=null'>CONSIGNEE=#{consignee,jdbcType=VARCHAR},</if> " +
                    "<if test='shipmentPort!=null'>SHIPMENT_PORT=#{shipmentPort,jdbcType=VARCHAR},</if> " +
                    "<if test='destinationPort!=null'>DESTINATION_PORT=#{destinationPort,jdbcType=VARCHAR},</if> " +
                    "<if test='transportMode!=null'>TRANSPORT_MODE=#{transportMode,jdbcType=VARCHAR},</if> " +
                    "<if test='priceCondition!=null'>PRICE_CONDITION=#{priceCondition,jdbcType=VARCHAR},</if> " +
                    "<if test='marks!=null'>MARKS=#{marks,jdbcType=VARCHAR},</if> " +
                    "<if test='remark!=null'>REMARK=#{remark,jdbcType=VARCHAR},</if> " +
                    "</set>" +
                    " where EXPORT_ID=#{exportId}",
            "</script>"
    })
    void updateExportC(ExportC exportC);
    /**
     * 批量上报state=1
     * @param exportIds
     * <foreach collection='array' item='exportId' open='(' close=')' separator=','>
     */
    @Update({
            "<script>",
            "update EXPORT_C set state=1 " +
                    " where EXPORT_ID in " +
                    "<foreach collection='array' item='exportId' open='(' close=')' separator=','>" +
                        "#{exportId}" +
                    "</foreach>",
            "</script>"
    })
    void updateExportCSubmit(String[] exportIds);

    /**
     * 批量取消state=0
     * @param exportIds
     */
    @Update({
            "<script>",
            "update EXPORT_C set state=0 " +
                    " where EXPORT_ID in " +
                    "<foreach collection='array' item='exportId' open='(' close=')' separator=','>" +
                        "#{exportId}" +
                    "</foreach>",
            "</script>"
    })
    void updateExportCCancel(String[] exportIds);

    /**
     * 查询全部
     * @return
     */
    @Select("select * from export_c")
    @ResultMap("ExportCAllMap")
    List<ExportC> findAllExportC();
}
