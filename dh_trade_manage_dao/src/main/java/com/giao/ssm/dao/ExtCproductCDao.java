package com.giao.ssm.dao;

import com.giao.ssm.domain.ExtCproductC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品附件dao
 */
public interface ExtCproductCDao {

    /**
     * 根据外键contractProductId查询多个合同商品附件
     * @param contractProductId
     * @return
     */
    @Select("select * from EXT_CPRODUCT_C where CONTRACT_PRODUCT_ID=#{contractProductId}")
    @Results(id = "extCproductCMap", value = {
            @Result(id = true,column = "EXT_CPRODUCT_ID",property = "extCproductId"),
            @Result(column = "FACTORY_ID",property = "factoryId"),
            @Result(column = "CONTRACT_PRODUCT_ID",property = "contractProductId"),
            @Result(column = "CTYPE",property = "ctype"),
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
            @Result(property = "factoryC",column = "FACTORY_ID",one = @One(select = "com.giao.ssm.dao.FactoryCDao.findFactorycById",fetchType = FetchType.EAGER)),
            @Result(property = "contractProductC",column = "CONTRACT_PRODUCT_ID",one = @One(select = "com.giao.ssm.dao.ContractProductCDao.findContractProductCById",fetchType = FetchType.EAGER))
    })
    List<ExtCproductC> findMultipleExtCproductCById(String contractProductId);
    /**
     * 根据id删除合同商品附件
     * @param extCproductId
     * @param contractProductId
     * @return
     */
    @Delete("delete from EXT_CPRODUCT_C where EXT_CPRODUCT_ID=#{extCproductId}")
    void deleteExtCproductCById(String extCproductId);
    /**
     * 添加合同商品附件
     * @param extCproductC
     * @return
     */
    @Insert("insert into EXT_CPRODUCT_C(EXT_CPRODUCT_ID,FACTORY_ID,CONTRACT_PRODUCT_ID,CTYPE," +
            "PRODUCT_NAME,PRODUCT_NO,PRODUCT_IMAGE,PRODUCT_DESC," +
            "LOADING_RATE,PACKING_UNIT,CNUMBER,OUT_NUMBER," +
            "FINISHED,GROSS_WEIGHT,NET_WEIGHT,SIZE_LENGHT," +
            "SIZE_WIDTH,SIZE_HEIGHT,PRODUCT_REQUEST,FACTORY," +
            "PRICE,AMOUNT,CUNIT,BOX_NUM," +
            "EX_PRICE,EX_UNIT,NO_TAX,TAX," +
            "COST_PRICE,COST_TAX,ACCESSORIES,ORDER_NO)" +
            "values(#{extCproductId},#{factoryId,jdbcType=VARCHAR},#{contractProductId,jdbcType=VARCHAR},#{ctype,jdbcType=INTEGER}," +
            "#{productName,jdbcType=VARCHAR},#{productNo,jdbcType=VARCHAR},#{productImage,jdbcType=VARCHAR},#{productDesc,jdbcType=VARCHAR}," +
            "#{loadingRate,jdbcType=VARCHAR},#{packingUnit,jdbcType=VARCHAR},#{cnumber,jdbcType=INTEGER},#{outNumber,jdbcType=INTEGER}," +
            "#{finished,jdbcType=INTEGER},#{grossWeight,jdbcType=DOUBLE},#{netWeight,jdbcType=DOUBLE},#{sizeLenght,jdbcType=DOUBLE}," +
            "#{sizeWidth,jdbcType=DOUBLE},#{sizeHeight,jdbcType=DOUBLE},#{productRequest,jdbcType=VARCHAR},#{factory,jdbcType=VARCHAR}," +
            "#{price,jdbcType=DOUBLE},#{amount,jdbcType=DOUBLE},#{cunit,jdbcType=VARCHAR},#{boxNum,jdbcType=INTEGER}," +
            "#{exPrice,jdbcType=DOUBLE},#{exUnit,jdbcType=VARCHAR},#{noTax,jdbcType=DOUBLE},#{tax,jdbcType=DOUBLE}," +
            "#{costPrice,jdbcType=DOUBLE},#{costTax,jdbcType=DOUBLE},#{accessories,jdbcType=INTEGER},#{orderNo,jdbcType=INTEGER}" +
            ")")
    void insertExtCproductC(ExtCproductC extCproductC);
    /**
     * 根据主键extCproductId查询一个
     * @param extCproductId
     * @return
     */
    @Select("select * from EXT_CPRODUCT_C where EXT_CPRODUCT_ID=#{extCproductId}")
    @ResultMap("extCproductCMap")
    ExtCproductC findExtCproductCById(String extCproductId);
    /**
     * 修改商品附件
     * @param extCproductC
     * @return
     */
    @Update({
            "<script>",
            "update EXT_CPRODUCT_C " +
                    "<set>" +
                    "<if test='factoryId!=null'>FACTORY_ID=#{factoryId,jdbcType=VARCHAR},</if> " +
                    "<if test='contractProductId!=null'>CONTRACT_PRODUCT_ID=#{contractProductId,jdbcType=VARCHAR},</if> " +
                    "<if test='ctype!=null'>CTYPE=#{ctype,jdbcType=INTEGER},</if> " +
                    "<if test='productName!=null'>PRODUCT_NAME=#{productName,jdbcType=VARCHAR},</if> " +
                    "<if test='productNo!=null'>PRODUCT_NO=#{productNo,jdbcType=VARCHAR},</if> " +
                    "<if test='productImage!=null'>PRODUCT_IMAGE=#{productImage,jdbcType=VARCHAR},</if> " +
                    "<if test='productDesc!=null'>PRODUCT_DESC=#{productDesc,jdbcType=VARCHAR},</if> " +
                    "<if test='loadingRate!=null'>LOADING_RATE=#{loadingRate,jdbcType=VARCHAR},</if> " +
                    "<if test='packingUnit!=null'>PACKING_UNIT=#{packingUnit,jdbcType=VARCHAR},</if> " +
                    "<if test='cnumber!=null'>CNUMBER=#{cnumber,jdbcType=INTEGER},</if> " +
                    "<if test='outNumber!=null'>OUT_NUMBER=#{outNumber,jdbcType=INTEGER},</if> " +
                    "<if test='finished!=null'>FINISHED=#{finished,jdbcType=INTEGER},</if> " +
                    "<if test='grossWeight!=null'>GROSS_WEIGHT=#{grossWeight,jdbcType=DOUBLE},</if> " +
                    "<if test='netWeight!=null'>NET_WEIGHT=#{netWeight,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeLenght!=null'>SIZE_LENGHT=#{sizeLenght,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeWidth!=null'>SIZE_WIDTH=#{sizeWidth,jdbcType=DOUBLE},</if> " +
                    "<if test='sizeHeight!=null'>SIZE_HEIGHT=#{sizeHeight,jdbcType=DOUBLE},</if> " +
                    "<if test='productRequest!=null'>PRODUCT_REQUEST=#{productRequest,jdbcType=VARCHAR},</if> " +
                    "<if test='factory!=null'>FACTORY=#{factory,jdbcType=VARCHAR},</if> " +
                    "<if test='price!=null'>PRICE=#{price,jdbcType=DOUBLE},</if> " +
                    "<if test='amount!=null'>AMOUNT=#{amount,jdbcType=DOUBLE},</if> " +
                    "<if test='cunit!=null'>CUNIT=#{cunit,jdbcType=VARCHAR},</if> " +
                    "<if test='boxNum!=null'>BOX_NUM=#{boxNum,jdbcType=INTEGER},</if> " +
                    "<if test='exPrice!=null'>EX_PRICE=#{exPrice,jdbcType=DOUBLE},</if> " +
                    "<if test='exUnit!=null'>EX_UNIT=#{exUnit,jdbcType=VARCHAR},</if> " +
                    "<if test='noTax!=null'>NO_TAX=#{noTax,jdbcType=DOUBLE},</if> " +
                    "<if test='tax!=null'>TAX=#{tax,jdbcType=DOUBLE},</if> " +
                    "<if test='costPrice!=null'>COST_PRICE=#{costPrice,jdbcType=DOUBLE},</if> " +
                    "<if test='costTax!=null'>COST_TAX=#{costTax,jdbcType=DOUBLE},</if> " +
                    "<if test='accessories!=null'>ACCESSORIES=#{accessories,jdbcType=INTEGER},</if> " +
                    "<if test='orderNo!=null'>ORDER_NO=#{orderNo,jdbcType=INTEGER},</if> " +
                    "</set>" +
                    " where EXT_CPRODUCT_ID=#{extCproductId}",
            "</script>"
    })
    void updateExtCproductCById(ExtCproductC extCproductC);

    /**
     * 根据contractProductId删除多个
     * 用于级联删除
     * @param contractProductId
     */
    @Delete("delete from EXT_CPRODUCT_C where CONTRACT_PRODUCT_ID=#{contractProductId}")
    void deleteMultipleExtCproductCByContractProductId(String contractProductId);

    /**
     * 避免死循环的根据id查询
     * 映射起的别名
     * @param extCproductId
     * @return
     */
    @Select("select * from EXT_CPRODUCT_C where CONTRACT_PRODUCT_ID=#{contractProductId，jdbcType=VARCHAR}")
    @Results(value = {
            @Result(id = true,column = "EXT_CPRODUCT_ID",property = "extCproductId"),
            @Result(column = "FACTORY_ID",property = "factoryId"),
            @Result(column = "CTYPE",property = "ctype"),
            @Result(column = "EXT_PRODUCT_NO",property = "productNo"),
            @Result(column = "EXT_PRODUCT_IMAGE",property = "productImage"),
            @Result(column = "EXT_PRODUCT_DESC",property = "productDesc"),
            @Result(column = "EXT_PACKING_UNIT",property = "packingUnit"),
            @Result(column = "EXT_CNUMBER",property = "cnumber"),
            @Result(column = "PRODUCT_REQUEST",property = "productRequest"),
            @Result(column = "EXT_PRICE",property = "price"),
            @Result(column = "EXT_AMOUNT",property = "amount"),
            @Result(column = "EXT_ORDER_NO",property = "orderNo"),
            @Result(property = "factoryC",column = "FACTORY_ID",one = @One(select = "com.giao.ssm.dao.FactoryCDao.findFactorycSById",fetchType = FetchType.EAGER))
    })
    ExtCproductC findMultipleExtCproductCSById(String contractProductId);
}



