package com.giao.ssm.service.impl;

import com.giao.ssm.dao.OutProductDao;
import com.giao.ssm.service.OutProductService;
import com.giao.ssm.vo.OutProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-02 16:00
 * 打印出货表serviceImpl
 **/
@Service
public class OutProductServiceImpl implements OutProductService {

    @Autowired
    private OutProductDao outProductDao;
    /**
     * 按船期查询某个月的购销合同统计
     * @param inputDate
     * @return
     */
    @Override
    public List<OutProductVO> findContractCByShipTime(String inputDate) {
        /*Map paraMap = new HashMap();
        //按条件查询，船期
        paraMap.put("inputDate", inputDate);
        System.out.println(paraMap);
        System.out.println(String.valueOf(paraMap));*/
        return outProductDao.findContractCByShipTime(inputDate);
    }
}
