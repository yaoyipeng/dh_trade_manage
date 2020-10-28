package com.giao.ssm.service;

import com.giao.ssm.domain.ContractC;
import com.giao.ssm.domain.ExportC;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 20:36
 * 报运单service接口
 **/
public interface ExportCService {

    List<ExportC> find(int page,int size);			//查询报运单
    List<ContractC> getContractCList();             // 获取购销合同列表（已上报）
    void insert(String[] contractIds);          // 插入数据
    ExportC findById(String exportId);          // 根据exportId主键查询一个，多用于修改
    String  getMrecordData(String exportId);     // 拼接js串
    // 修改，用实体做参数
    void updateExportC(ExportC exportC, String[] mr_id, Integer[] mr_orderNo, Integer[] mr_cnumber, Double[] mr_grossWeight, Double[] mr_netWeight, Double[] mr_sizeLength, Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_changed);
    void submit(String[] exportId);             // 批量上报state=1
    void cancel(String[] exportId);             // 批量取消state=0
}
