package com.giao.ssm.dao;

import com.giao.ssm.domain.ContractProductC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品明细dao接口
 */
public interface ContractProductCDao {
    /**
     * 根据contractId查询货物
     * @param contractId
     * @return
     */
    @Select("select * from CONTRACT_PRODUCT_C where CONTRACT_ID=#{contractId}")
    @Results(id="contractProductCMap",value = {
            @Result(id=true,column = "CONTRACT_PRODUCT_ID",property = "contractProductId"),
            @Result(column = "CONTRACT_ID",property = "contractId"),
            @Result(column = "FACTORY_ID",property = "factoryId"),
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
            @Result(property = "contractC",column = "CONTRACT_ID",one = @One(select = "com.giao.ssm.dao.ContractCDao.findContractCById",fetchType = FetchType.EAGER)),
            @Result(property = "factoryC",column = "FACTORY_ID",one = @One(select = "com.giao.ssm.dao.FactoryCDao.findFactorycById",fetchType = FetchType.EAGER))
//            @Result(property = "extCproductCS",column = "CONTRACT_PRODUCT_ID",many = @Many(select = "com.giao.ssm.dao.ExtCproductCDao.findMultipleExtCproductCById",fetchType = FetchType.LAZY))
    })
    List<ContractProductC> findAllByContractId(String contractId);
    /**
     * 添加货物
     * @param contractProductC
     * @return
     */
    @Insert("insert into CONTRACT_PRODUCT_C(CONTRACT_PRODUCT_ID,CONTRACT_ID,FACTORY_ID," +
            "PRODUCT_NAME,PRODUCT_NO,PRODUCT_IMAGE," +
            "PRODUCT_DESC,LOADING_RATE,PACKING_UNIT," +
            "CNUMBER,OUT_NUMBER,FINISHED," +
            "GROSS_WEIGHT,NET_WEIGHT,SIZE_LENGHT," +
            "SIZE_WIDTH,SIZE_HEIGHT,PRODUCT_REQUEST," +
            "FACTORY,PRICE,AMOUNT," +
            "CUNIT,BOX_NUM,EX_PRICE," +
            "EX_UNIT,NO_TAX,TAX," +
            "COST_PRICE,COST_TAX,ACCESSORIES,ORDER_NO)" +
            "values(#{contractProductId},#{contractId,jdbcType=VARCHAR},#{factoryId,jdbcType=VARCHAR}," +
            "#{productName,jdbcType=VARCHAR},#{productNo,jdbcType=VARCHAR},#{productImage,jdbcType=VARCHAR}," +
            "#{productDesc,jdbcType=VARCHAR},#{loadingRate,jdbcType=VARCHAR},#{packingUnit,jdbcType=VARCHAR}," +
            "#{cnumber,jdbcType=INTEGER},#{outNumber,jdbcType=INTEGER},#{finished,jdbcType=INTEGER}," +
            "#{grossWeight,jdbcType=DOUBLE},#{netWeight,jdbcType=DOUBLE},#{sizeLenght,jdbcType=DOUBLE}," +
            "#{sizeWidth,jdbcType=DOUBLE},#{sizeHeight,jdbcType=DOUBLE},#{productRequest,jdbcType=VARCHAR}," +
            "#{factory,jdbcType=VARCHAR},#{price,jdbcType=DOUBLE},#{amount,jdbcType=DOUBLE}," +
            "#{cunit,jdbcType=VARCHAR},#{boxNum,jdbcType=INTEGER},#{exPrice,jdbcType=DOUBLE}," +
            "#{exUnit,jdbcType=VARCHAR},#{noTax,jdbcType=DOUBLE},#{tax,jdbcType=DOUBLE}," +
            "#{costPrice,jdbcType=DOUBLE},#{costTax,jdbcType=DOUBLE},#{accessories,jdbcType=INTEGER},#{orderNo,jdbcType=INTEGER})")
    void insertContractProductC(ContractProductC contractProductC);
    /**
     * 删除货物
     * @param contractProductId
     * @param contractId
     * @return
     */
    @Delete("delete from CONTRACT_PRODUCT_C where CONTRACT_PRODUCT_ID=#{contractProductId}")
    void deleteContractProductCById(String contractProductId);

    /**
     * 根据id查询一个
     * @param contractProductId
     * @return
     */
    @Select("select * from CONTRACT_PRODUCT_C where CONTRACT_PRODUCT_ID=#{contractProductId}")
    @ResultMap("contractProductCMap")
    ContractProductC findContractProductCById(String contractProductId);
    /**
     * 修改货物
     * @param contractProductC
     * @return
     */
    @Update({
            "<script>",
            "update CONTRACT_PRODUCT_C " +
                    "<set>" +
                    "<if test='contractId!=null'>CONTRACT_ID=#{contractId,jdbcType=VARCHAR},</if> " +
                    "<if test='factoryId!=null'>FACTORY_ID=#{factoryId,jdbcType=VARCHAR},</if> " +
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
                    " where CONTRACT_PRODUCT_ID=#{contractProductId}",
            "</script>"
    })
    void updateContractProductC(ContractProductC contractProductC);

    /**
     * 根据外键contractId删除多个
     * @param contractId
     */
    @Delete("delete from CONTRACT_PRODUCT_C where CONTRACT_ID=#{contractId}")
    void deleteMultipleContractProductCByContractId(String contractId);
    /**
     * 根据contractId查询货物
     * 映射要打印的货物信息
     * @param contractId
     * @return
     */
    @Select("select * from CONTRACT_PRODUCT_C where CONTRACT_ID=#{contractId}")
    @Results(value = {
            @Result(id=true,column = "CONTRACT_PRODUCT_ID",property = "contractProductId"),
            @Result(column = "FACTORY_ID",property = "factoryId"),
            @Result(column = "PRODUCT_NO",property = "productNo"),
            @Result(column = "PRODUCT_IMAGE",property = "productImage"),
            @Result(column = "PRODUCT_DESC",property = "productDesc"),
            @Result(column = "LOADING_RATE",property = "loadingRate"),
            @Result(column = "PACKING_UNIT",property = "packingUnit"),
            @Result(column = "CNUMBER",property = "cnumber"),
            @Result(column = "OUT_NUMBER",property = "outNumber"),
            @Result(column = "FINISHED",property = "finished"),
            @Result(column = "PRICE",property = "price"),
            @Result(column = "AMOUNT",property = "amount"),
            @Result(column = "BOX_NUM",property = "boxNum"),
            @Result(column = "EX_UNIT",property = "exUnit"),
            @Result(column = "ORDER_NO",property = "orderNo"),
            @Result(property = "factoryC",column = "FACTORY_ID",one = @One(select = "com.giao.ssm.dao.FactoryCDao.findFactorycById",fetchType = FetchType.EAGER)),
            @Result(property = "extCproductCS",column = "CONTRACT_PRODUCT_ID",many = @Many(select = "com.giao.ssm.dao.ExtCproductCDao.findMultipleExtCproductCSById",fetchType = FetchType.LAZY))
    })
    List<ContractProductC> findMultipleByContractId(String contractId);

}
