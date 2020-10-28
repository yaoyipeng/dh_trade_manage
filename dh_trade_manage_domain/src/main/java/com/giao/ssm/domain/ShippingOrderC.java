package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 委托单实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShippingOrderC extends CreateUser implements Serializable {

    private String shippingOrderId;     // SHIPPING_ORDER_ID 主键
    private String packingListId;       // PACKING_LIST_ID 外键
    private String orderType;           // 海运/空运 （0海运/1空运）
    private String shipper;             // 货主
    private String consignee;           // 提单抬头
    private String notifyParty;         // 正本通知人
    private String lcNo;                // 信用证
    private String portOfLoading;       // 装运港
    private String portOfTrans;         // 转船港
    private String portOfDischarge;     // 卸货港
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loadingDate;           // 装期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date limitDate;             // 效期
    private String isBatch;             // 是否分批 (0是1否)
    private String isTrans;             // 是否转船 (0是1否)
    private String copyNum;             // 份数
    private String cnote;               // 扼要说明
    private String specialCondition;    // 运输要求
    private String freight;             // 运费
    private String checkBy;             // 复核人

    private PackingListC packingListC;
}
