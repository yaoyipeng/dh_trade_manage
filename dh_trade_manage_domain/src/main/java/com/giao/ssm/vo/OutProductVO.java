package com.giao.ssm.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-02 15:24
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutProductVO {

    private String customName;          // 客户名称
    private String contractNo;          // 合同号
    private String productNo;           // 货号
    private String cnumber;             // 数量
    private String factory;             // 厂家
    private String deliveryPeriod;      // 交货期限
    private String shipTime;            // 船期
    private String tradeTerms;          // 贸易条款


}
