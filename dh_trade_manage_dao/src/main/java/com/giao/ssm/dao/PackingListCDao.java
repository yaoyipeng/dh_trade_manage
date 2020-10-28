package com.giao.ssm.dao;

import com.giao.ssm.domain.PackingListC;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-12 23:05
 * 装箱单dao
 **/
public interface PackingListCDao {

    /**
     * 查询全部装箱单
     * @return
     */
    @Select("select * from packing_list_c")
    @Results(id="PackingListCMap",value = {
            @Result(id=true,column = "PACKING_LIST_ID",property = "packingListId"),
            @Result(column = "EXPORT_ID",property = "exportId"),
            @Result(column = "SELLER",property = "seller"),
            @Result(column = "BUYER",property = "buyer"),
            @Result(column = "INVOICE_NO",property = "invoiceNo"),
            @Result(column = "INVOICE_DATE",property = "invoiceDate"),
            @Result(column = "MARKS",property = "marks"),
            @Result(column = "DESCRIPTIONS",property = "descriptions"),
            @Result(column = "EXPORT_NOS",property = "exportNos"),
            @Result(column = "STATE",property = "state"),
            @Result(column = "EXPORT_IDS",property = "exportIds"),
            @Result(column = "CREATE_BY",property = "createBy"),
            @Result(column = "CREATE_DEPT",property = "createDept"),
            @Result(column = "CREATE_TIME",property = "createTime")
    })
    List<PackingListC> findAllPackingListC();

    /**
     * 查询一个装箱单
     * @param packingListId
     * @return
     */
    @Select("select * from packing_list_c where PACKING_LIST_ID = #{packingListId}")
    @ResultMap("PackingListCMap")
    PackingListC findPackingListCById(String packingListId);

    /**
     * 修改装箱单
     * @param packingList
     */
    @Update({
            "<script>",
            "update PACKING_LIST_C " +
                    "<set>" +
                        "<if test='seller!=null'>SELLER=#{seller},</if> " +
                        "<if test='buyer!=null'>BUYER=#{buyer,jdbcType=VARCHAR},</if> " +
                        "<if test='invoiceNo!=null'>INVOICE_NO=#{invoiceNo,jdbcType=VARCHAR},</if> " +
                        "<if test='invoiceDate!=null'>INVOICE_DATE=#{invoiceDate},</if> " +
                        "<if test='marks!=null'>MARKS=#{marks,jdbcType=VARCHAR},</if> " +
                        "<if test='descriptions!=null'>DESCRIPTIONS=#{descriptions,jdbcType=VARCHAR},</if> " +
                        "<if test='exportIds!=null'>EXPORT_IDS=#{exportIds,jdbcType=VARCHAR},</if> " +
                        "<if test='exportNos!=null'>EXPORT_NOS=#{exportNos,jdbcType=VARCHAR},</if> " +
                        "<if test='state!=null'>STATE=#{state,jdbcType=INTEGER},</if> " +
                    "</set>" +
                    " where PACKING_LIST_ID = #{packingListId}",
            "</script>"
    })
    void updatePackingListC(PackingListC packingList);
    /**
     * 新增
     * @param packingList
     */
    @Insert("insert into packing_list_c " +
            "(PACKING_LIST_ID,SELLER,BUYER,INVOICE_NO,INVOICE_DATE," +
            "MARKS,DESCRIPTIONS,EXPORT_IDS,EXPORT_NOS,STATE," +
            "CREATE_BY,CREATE_DEPT,CREATE_TIME) " +
            "values (#{packingListId},#{seller, jdbcType=VARCHAR},#{buyer, jdbcType=VARCHAR},#{invoiceNo, jdbcType=VARCHAR},#{invoiceDate, jdbcType=TIMESTAMP}," +
            "#{marks, jdbcType=VARCHAR},#{descriptions, jdbcType=VARCHAR},#{exportIds, jdbcType=VARCHAR},#{exportNos, jdbcType=VARCHAR},#{state, jdbcType=INTEGER}," +
            "#{createBy, jdbcType=VARCHAR},#{createDept, jdbcType=VARCHAR},#{createTime, jdbcType=TIMESTAMP})")
    void insertPackingListC(PackingListC packingList);
    /**
     * 批量上报state==1
     * @param packingListIds
     */
    @Update({
            "<script>",
            "update PACKING_LIST_C set state=1 " +
                    " where PACKING_LIST_ID in " +
                    "<foreach collection='array' item='packingListId' open='(' close=')' separator=','>" +
                    "#{packingListId}" +
                    "</foreach>",
            "</script>"
    })
    void updateSubmit(String[] packingListIds);
    /**
     * 批量取消state==0
     * @param packingListIds
     */
    @Update({
            "<script>",
            "update PACKING_LIST_C set state=0 " +
                    " where PACKING_LIST_ID in " +
                    "<foreach collection='array' item='packingListId' open='(' close=')' separator=','>" +
                    "#{packingListId}" +
                    "</foreach>",
            "</script>"
    })
    void updateCancel(String[] packingListIds);
}
