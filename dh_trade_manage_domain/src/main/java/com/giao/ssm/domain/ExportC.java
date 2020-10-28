package com.giao.ssm.domain;

import com.giao.ssm.extend.ContractCExpand;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 报运单实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExportC extends ContractCExpand implements Serializable {

    private String exportId;                // EXPORT_ID 主键
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;                 // 制单日期
    private String contractIds;             // 合同编号集合(打断设计)
    private String customerContract;        // 合同或确认书号 （客户的合同号,可选择多个合同）
    private String lcno;                    // L/C NO （L/C T/T）
    private String consignee;               // 收货人及地址
    private String marks;                   // 唛头
    private String shipmentPort;            // 装运港
    private String destinationPort;         // 目的港
    private String transportMode;           // 运输方式 (SEA/AIR)
    private String priceCondition;          // 价格条件 (FBO/CIF)
    private String remark;                  // 备注
    private Integer boxNum;                 // 件数
    private Integer cnumber;                // 数量
    private String packingUnit;             // 包装单位 (PCS/SETS)
    private Double grossWeight;             // 毛重
    private Double netWeight;               // 净重
    private Double sizeLenght;              // 尺寸长
    private Double sizeWidth;               // 尺寸宽
    private Double sizeHeight;              // 尺寸高
    private Double csize;                   // 尺寸
    private Double amount;                  // 总金额 (自动计算: 数量x单价)
    private Double noTax;                   // 不含税 (收购单价)
    private Double tax;                     // 含税 (收购单价)
    private Double costPrice;               // 收购成本金额 (自动计算=数量x含税/1.17标准值)
    private Double costTax;                 // 收购成本税金 (自动计算=数量x含税-收购成本金额)
    private Integer state;                  // 状态 (0草稿 1上报)


}


