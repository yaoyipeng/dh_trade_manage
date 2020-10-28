package com.giao.ssm.dao;

import com.giao.ssm.domain.ExportProductC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 22:32
 * 报运商品明细dao
 **/
public interface ExportProductCDao {
    /**
     * 添加报运商品明细
     * @param ep
     */
    @Insert("insert into EXPORT_PRODUCT_C(EXPORT_PRODUCT_ID,CONTRACT_PRODUCT_ID,EXPORT_ID,FACTORY_ID,CONTRACT_ID," +
            "CONTRACT_NO,PRODUCT_NAME,PRODUCT_NO,PRODUCT_IMAGE,PRODUCT_DESC," +
            "LOADING_RATE,PACKING_UNIT,CNUMBER,OUT_NUMBER,FINISHED," +
            "GROSS_WEIGHT,NET_WEIGHT,SIZE_LENGHT,SIZE_WIDTH,SIZE_HEIGHT," +
            "PRODUCT_REQUEST,FACTORY,PRICE,AMOUNT,CUNIT," +
            "BOX_NUM,EX_PRICE,EX_UNIT,NO_TAX,TAX," +
            "COST_PRICE,COST_TAX,ACCESSORIES,ORDER_NO)" +
            " values(#{exportProductId,jdbcType=VARCHAR},#{contractProductId,jdbcType=VARCHAR},#{exportId,jdbcType=VARCHAR},#{factoryId,jdbcType=VARCHAR},#{contractId,jdbcType=VARCHAR}," +
            "#{contractNo,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productNo,jdbcType=VARCHAR},#{productImage,jdbcType=VARCHAR},#{productDesc,jdbcType=VARCHAR}," +
            "#{loadingRate,jdbcType=VARCHAR},#{packingUnit,jdbcType=VARCHAR},#{cnumber,jdbcType=INTEGER},#{outNumber,jdbcType=INTEGER},#{finished,jdbcType=INTEGER}," +
            "#{grossWeight,jdbcType=DOUBLE},#{netWeight,jdbcType=DOUBLE},#{sizeLenght,jdbcType=DOUBLE},#{sizeWidth,jdbcType=DOUBLE},#{sizeHeight,jdbcType=DOUBLE}," +
            "#{productRequest,jdbcType=VARCHAR},#{factory,jdbcType=VARCHAR},#{price,jdbcType=DOUBLE},#{amount,jdbcType=DOUBLE},#{cunit,jdbcType=VARCHAR}," +
            "#{boxNum,jdbcType=INTEGER},#{exPrice,jdbcType=DOUBLE},#{exUnit,jdbcType=VARCHAR},#{noTax,jdbcType=DOUBLE},#{tax,jdbcType=DOUBLE}," +
            "#{costPrice,jdbcType=DOUBLE},#{costTax,jdbcType=DOUBLE},#{accessories,jdbcType=INTEGER},#{orderNo,jdbcType=INTEGER})")
    void insert(ExportProductC ep);

    /**
     * 根据外键查询ExportProductC（报运商品明细）
     * @param exportId
     * @return
     */
    @Select("select * from EXPORT_PRODUCT_C where EXPORT_ID = #{exportId}")
    @Results(id = "ExportProductCAllMap", value = {
            @Result(id = true,column = "EXPORT_PRODUCT_ID",property = "exportProductId"),
            @Result(column = "CONTRACT_PRODUCT_ID",property = "contractProductId"),
            @Result(column = "EXPORT_ID",property = "exportId"),
            @Result(column = "FACTORY_ID",property = "factoryId"),
            @Result(column = "CONTRACT_ID",property = "contractId"),
            @Result(column = "CONTRACT_NO",property = "contractNo"),
            @Result(column = "PRODUCT_NAME",property = "productName"),
            @Result(column = "PRODUCT_NO",property = "productNo"),
            @Result(column = "PRODUCT_IMAGE",property = "productImage"),
            @Result(column = "PRODUCT_DESC",property = "productDesc"),
            @Result(column = "LOADING_RATE",property = "loadingRate"),
            @Result(column = "PACKING_UNIT",property = "packingUnit"),
            @Result(column = "CNUMBER",property = "cnumber"),
            @Result(column = "OUT_NUMBER",property = "outNumber"),
            @Result(column = "FINISHED",property = "finished"),
            @Result(column = "GROSS_WEIGHT",property = "grossWeight"),
            @Result(column = "NET_WEIGHT",property = "netWeight"),
            @Result(column = "SIZE_LENGHT",property = "sizeLenght"),
            @Result(column = "SIZE_WIDTH",property = "sizeWidth"),
            @Result(column = "SIZE_HEIGHT",property = "sizeHeight"),
            @Result(column = "PRODUCT_REQUEST",property = "productRequest"),
            @Result(column = "FACTORY",property = "factory"),
            @Result(column = "PRICE",property = "price"),
            @Result(column = "AMOUNT",property = "amount"),
            @Result(column = "CUNIT",property = "cunit"),
            @Result(column = "BOX_NUM",property = "boxNum"),
            @Result(column = "EX_PRICE",property = "exPrice"),
            @Result(column = "EX_UNIT",property = "exUnit"),
            @Result(column = "NO_TAX",property = "noTax"),
            @Result(column = "TAX",property = "tax"),
            @Result(column = "COST_PRICE",property = "costPrice"),
            @Result(column = "COST_TAX",property = "costTax"),
            @Result(column = "ACCESSORIES",property = "accessories"),
            @Result(column = "ORDER_NO",property = "orderNo"),
            @Result(property = "exportC",column = "EXPORT_ID",one = @One(select = "com.giao.ssm.dao.ExportCDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "factoryC",column = "FACTORY_ID",one = @One(select = "com.giao.ssm.dao.FactoryCDao.findFactorycById",fetchType = FetchType.EAGER)),
    })
    List<ExportProductC> findByExportId(String exportId);

    /**
     * 根据主键查询一个
     * @param s
     * @return
     */
    @Select("select * from EXPORT_PRODUCT_C where EXPORT_PRODUCT_ID = #{exportProductId}")
    @ResultMap("ExportProductCAllMap")
    ExportProductC findById(String exportProductId);

    /**
     * 修改报运商品明细(货物信息)
     * @param ep
     */
    @Update({
            "<script>",
            "update EXPORT_PRODUCT_C " +
                    "<set>" +
                    "<if test='orderNo!=null'>ORDER_NO=#{orderNo,jdbcType=INTEGER},</if> " +
                    "<if test='cnumber!=null'>CNUMBER=#{cnumber,jdbcType=INTEGER},</if> " +
                    "<if test='grossWeight!=null'>GROSS_WEIGHT=#{grossWeight,jdbcType=DOUBLE},</if> " +
                    "<if test='netWeight!=null'>NET_WEIGHT=#{netWeight,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeLenght!=null'>SIZE_LENGHT=#{sizeLenght,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeWidth!=null'>SIZE_WIDTH=#{sizeWidth,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeHeight!=null'>SIZE_HEIGHT=#{sizeHeight,jdbcType=DOUBLE},</if> " +
                    "<if test='exPrice!=null'>EX_PRICE=#{exPrice,jdbcType=DOUBLE},</if> " +
                    "<if test='tax!=null'>TAX=#{tax,jdbcType=DOUBLE},</if> " +
                    "</set>" +
                    " where EXPORT_PRODUCT_ID=#{exportProductId}",
            "</script>"
    })
    void updateExportProductC(ExportProductC ep);
}
