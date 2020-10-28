package com.giao.ssm.dao;

import com.giao.ssm.domain.SysCodeB;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 影耀子
 * sys分类表dao
 */
public interface SysCodeBDao {
    /**
     * 查询全部分类表
     * @return
     */
    @Select("select * from SYS_CODE_B")
    @Results(id = "sysCodeBMap", value = {
            @Result(id = true,column = "SYS_CODE_ID",property = "sysCodeId"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "PARENT_ID",property = "parentId"),
            @Result(column = "PARENT_NAME",property = "parentName"),
            @Result(column = "LAYER_NUM",property = "layerNum"),
            @Result(column = "IS_LEAF",property = "isLeaf"),
            @Result(column = "QUOTE_NUM",property = "quoteNum"),
            @Result(column = "CNOTE",property = "cnote"),
            @Result(column = "ICO",property = "ico"),
            @Result(column = "ORDER_NO",property = "orderNo"),
            @Result(column = "STATE",property = "state"),
            @Result(column = "CREATED_BY",property = "createdBy"),
            @Result(column = "CREATED_TIME",property = "createdTime"),
            @Result(column = "UPDATED_BY",property = "updatedBy"),
            @Result(column = "UPDATED_TIME",property = "updatedTime")
    })
    List<SysCodeB> findSysCodeBAll();
}
