package com.giao.ssm.dao;

import com.giao.ssm.domain.FactoryC;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 影耀子
 * 生产工厂dao
 */
public interface FactoryCDao {
    /**
     * 查询全部生产厂家
     * @return
     */
    @Select("select * from FACTORY_C")
    @Results(id="FactoryMap",value = {
            @Result(id=true,column = "factory_id",property = "factoryId"),
            @Result(column = "full_name",property = "fullName"),
            @Result(column = "factory_name",property = "factoryName"),
            @Result(column = "contactor",property = "contactor"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "mobile",property = "mobile"),
            @Result(column = "fax",property = "fax"),
            @Result(column = "cnote",property = "cnote"),
            @Result(column = "ctype",property = "ctype"),
            @Result(column = "state",property = "state"),
            @Result(column = "inspector",property = "inspector"),
            @Result(column = "order_no",property = "orderNo"),
            @Result(column = "create_by",property = "createBy"),
            @Result(column = "create_dept",property = "createDept"),
            @Result(column = "create_time",property = "createTime")
    })
    List<FactoryC> findFactorycAll();

    /**
     * 添加生产厂家
     * @param factoryC
     */
    @Insert("insert into FACTORY_C(factory_id,full_name,factory_name,contactor,phone," +
            "mobile,fax,cnote,ctype,state,inspector,order_no,create_by,create_dept,create_time) " +
            "values(#{factoryId},#{fullName,jdbcType=VARCHAR}," +
            "#{factoryName,jdbcType=VARCHAR},#{contactor,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR}," +
            "#{mobile,jdbcType=VARCHAR},#{fax,jdbcType=VARCHAR},#{cnote,jdbcType=VARCHAR}," +
            "#{ctype,jdbcType=INTEGER},#{state,jdbcType=VARCHAR}," +
            "#{inspector,jdbcType=VARCHAR},#{orderNo,jdbcType=INTEGER},#{createBy,jdbcType=VARCHAR}," +
            "#{createDept,jdbcType=VARCHAR},#{createTime})")
    void insertFactoryc(FactoryC factoryC);

    /**
     * 查询一个
     * @param factoryId
     * @return
     */
    @Select("select * from FACTORY_C where factory_id = #{factoryId}")
    @ResultMap("FactoryMap")
    FactoryC findFactorycById(String factoryId);

    /**
     * 修改生产厂家
     * @param factoryC
     */
    @Update({
            "<script>",
            "update FACTORY_C " +
                    "<set>" +
                        "<if test='fullName!=null'>full_name=#{fullName, jdbcType=VARCHAR},</if> " +
                        "<if test='factoryName!=null'>factory_name=#{factoryName, jdbcType=VARCHAR},</if> " +
                        "<if test='contactor!=null'>contactor=#{contactor, jdbcType=VARCHAR},</if> " +
                        "<if test='phone!=null'>phone=#{phone, jdbcType=VARCHAR},</if> " +
                        "<if test='mobile!=null'>mobile=#{mobile, jdbcType=VARCHAR},</if> " +
                        "<if test='fax!=null'>fax=#{fax, jdbcType=VARCHAR},</if> " +
                        "<if test='cnote!=null'>cnote=#{cnote, jdbcType=VARCHAR},</if> " +
                        "<if test='ctype!=null'>ctype=#{ctype, jdbcType=INTEGER},</if> " +
                        "<if test='inspector!=null'>inspector=#{inspector, jdbcType=VARCHAR},</if> " +
                        "<if test='orderNo!=null'>order_no=#{orderNo, jdbcType=INTEGER},</if> " +
                        "<if test='createBy!=null'>create_by=#{createBy, jdbcType=VARCHAR},</if> " +
                        "<if test='createDept!=null'>create_dept=#{createDept, jdbcType=VARCHAR},</if> " +
                    "</set>" +
                    " where factory_id=#{factoryId}",
            "</script>"
    })
    void UpdateFactoryc(FactoryC factoryC);

    /**
     * 根据factoryId删除一个生产厂家
     * @param factoryId
     */
    @Delete("delete from FACTORY_C where factory_id=#{factoryId}")
    void deleteFactorycByFactoryId(String factoryId);

    /**
     * 停用生产厂家
     * @param id
     */
    @Update("update FACTORY_C set state = '2' where factory_id=#{factoryId}")
    void stopFactoryc(String factoryId);

    /**
     * 启用生产厂家
     * @param id
     */
    @Update("update FACTORY_C set state = '1' where factory_id=#{factoryId}")
    void startFactoryc(String factoryId);

    /**
     * 映射起的别名
     * @param factoryId
     * @return
     */
    @Select("select * from FACTORY_C where factory_id = #{factoryId}")
    @Results(value = {
            @Result(id=true,column = "EXT_FACTORY_ID",property = "factoryId"),
            @Result(column = "EXT_FULL_NAME",property = "fullName"),
            @Result(column = "EXT_FACTORY_NAME",property = "factoryName"),
            @Result(column = "EXT_CONTACTOR",property = "contactor")
    })
    FactoryC findFactorycSById(String factoryId);
}
