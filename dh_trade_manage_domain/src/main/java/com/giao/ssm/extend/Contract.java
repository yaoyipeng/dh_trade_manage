package com.giao.ssm.extend;

import lombok.*;

/**
 * @author 影耀子
 * 合同表的公共字段
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contract {

    private String productName;             // 产品名称
    private String productNo;               // 货号
    private String productImage;            // 货物照片
    private String productDesc;             // 货物描述
    private String loadingRate;             // 装率 （x/y）
    private String packingUnit;             // 包装单位（PCS/SETS）
    private Integer cnumber;                // 数量
    private Integer outNumber;              // 实际出货数量
    private Integer finished;               // 是否出货完毕（0是1否）
    private Double grossWeight;             // 毛重
    private Double netWeight;               // 净重
    private Double sizeLenght;              // 尺寸长
    private Double sizeWidth;               // 尺寸宽
    private Double sizeHeight;              // 尺寸高
    private String productRequest;          // 要求
    private String factory;                 // 厂家
    private Double price;                   // 单价
    private Double amount;                  // 总金额 （自动计算: 数量x单价）
    private String cunit;                   // EL单位
    private Integer boxNum;                 // 箱数
    private Double exPrice;                 // 出口单价
    private String exUnit;                  // 价格单位（$/￥）
    private Double noTax;                   // 不含税（收购单价）
    private Double tax;                     // 含税 （收购单价）
    private Double costPrice;               // 收购成本金额 （自动计算=数量x含税/1.17标准值）
    private Double costTax;                 // 收购成本税金 （自动计算=数量x含税-收购成本金额）
    private Integer accessories;            // 是否是附件 （0是1否）
    private Integer orderNo;                // 排序号
}
