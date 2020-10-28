package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * 发票实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceC extends CreateUser implements Serializable {

    private String invoiceId;       // INVOICE_ID 主键
    private String packingListId;   // PACKING_LIST_ID  外键
    private String scNo;            // SC_NO
    private String blNo;            // BL_NO
    private String tradeTerms;      // 贸易条款
    private String descriptions;    // 描述

    private PackingListC packingListC;

}
