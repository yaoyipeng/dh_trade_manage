package com.giao.ssm.service;

import com.giao.ssm.domain.PackingListC;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-12 23:06
 * 装箱单service
 **/
public interface PackingListCService {

    List<PackingListC> findAllPackingListC();       // 查询全部装箱单
    List<PackingListC> findPage(Page page);	        //分页查询
    PackingListC findPackingListCById(String packingListId);		//查询一个装箱单，多用于修改
    String getDivDataCreate(String[] exportId);	            //获取div在新增页面展示数据

    void insertPackingListC(PackingListC packingList);      // 新增装箱单

    void updateSubmit(String[] packingListId);              // 批量上报state==1

    void updateCancel(String[] packingListId);              // 批量取消state==0
    String getDivDataUpdate(String[] exportIds, String[] exportNos); // 获取div在修改页面展示数据
    void update(PackingListC packingListC);                 // 修改装箱单
    String getDivDataView(String[] exportNos);              // 获取div在查看页面展示数据

}
