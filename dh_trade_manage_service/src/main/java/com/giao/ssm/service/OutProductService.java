package com.giao.ssm.service;

import com.giao.ssm.vo.OutProductVO;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-02 15:54
 * 打印出货表service接口
 **/
public interface OutProductService {

    /**
     * 带条件查询，条件可以为null，既没有条件；返回list对象集合
     * @param inputDate
     * @return
     */
    List<OutProductVO> findContractCByShipTime(String inputDate);
}
