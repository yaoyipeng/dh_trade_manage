package com.giao.ssm.dao;

import com.giao.ssm.domain.ExtEproductC;
import org.apache.ibatis.annotations.Insert;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 22:32
 * 报运商品附件dao
 **/
public interface ExtEproductCDao {

    /**
     * 添加报运商品附件
     * @param extep
     */
    @Insert("insert into EXT_EPRODUCT_C(EXT_EPRODUCT_ID,FACTORY_ID,EXPORT_PRODUCT_ID,CONTRACT_PRODUCT_ID,CTYPE," +
            "PRODUCT_NAME,PRODUCT_NO,PRODUCT_IMAGE,PRODUCT_DESC,LOADING_RATE," +
            "PACKING_UNIT,CNUMBER,OUT_NUMBER,FINISHED,GROSS_WEIGHT," +
            "NET_WEIGHT,SIZE_LENGHT,SIZE_WIDTH,SIZE_HEIGHT,PRODUCT_REQUEST," +
            "FACTORY,PRICE,AMOUNT,CUNIT,BOX_NUM," +
            "EX_PRICE,EX_UNIT,NO_TAX,TAX,COST_PRICE," +
            "COST_TAX,ACCESSORIES,ORDER_NO) " +
            "values(#{extEproductId,jdbcType=VARCHAR},#{factoryId,jdbcType=VARCHAR},#{exportProductId,jdbcType=VARCHAR},#{contractProductId,jdbcType=VARCHAR},#{ctype,jdbcType=VARCHAR}," +
            "#{productName,jdbcType=VARCHAR},#{productNo,jdbcType=VARCHAR},#{productImage,jdbcType=VARCHAR},#{productDesc,jdbcType=VARCHAR},#{loadingRate,jdbcType=VARCHAR}," +
            "#{packingUnit,jdbcType=VARCHAR},#{cnumber,jdbcType=INTEGER},#{outNumber,jdbcType=INTEGER},#{finished,jdbcType=INTEGER},#{grossWeight,jdbcType=DOUBLE}," +
            "#{netWeight,jdbcType=DOUBLE},#{sizeLenght,jdbcType=DOUBLE},#{sizeWidth,jdbcType=DOUBLE},#{sizeHeight,jdbcType=DOUBLE},#{productRequest,jdbcType=VARCHAR}," +
            "#{factory,jdbcType=VARCHAR},#{price,jdbcType=DOUBLE},#{amount,jdbcType=DOUBLE},#{cunit,jdbcType=VARCHAR},#{boxNum,jdbcType=INTEGER}," +
            "#{exPrice,jdbcType=DOUBLE},#{exUnit,jdbcType=VARCHAR},#{noTax,jdbcType=DOUBLE},#{tax,jdbcType=DOUBLE},#{costPrice,jdbcType=DOUBLE}," +
            "#{costTax,jdbcType=DOUBLE},#{accessories,jdbcType=INTEGER},#{orderNo,jdbcType=INTEGER})")
    void insert(ExtEproductC extep);
}
