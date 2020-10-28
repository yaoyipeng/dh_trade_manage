package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 产品实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemsC extends CreateUser implements Serializable {

    private String itemsId;                     // ITEMS_ID 主键
    private String itemNo;                      // 编号
    private String itemImage;                   // 照片
    private String description;                 // 描述
    private String factoryId;                   // FACTORY_ID 外键
    private String factory;                     // 厂家简称
    private Double price;                       // 市场价
    private Double sizeLenght;                  // 尺寸长
    private Double sizeWidth;                   // 尺寸宽
    private Double sizeHeight;                  // 尺寸高
    private String color;                       // 颜色 (会写很多内容)
    private String packing;                     // 包装
    private String packingUnit;                 // 包装单位 (PCS/SETS)
    private Double type20;                      // 集装箱类别20
    private Double type40;                      // 集装箱类别40
    private Double type40hc;                    // 集装箱类别40HC
    private Integer qty;                        // 数量
    private Double cbm;                         // 体积
    private Double mpsizeLenght;                // 大箱尺寸长
    private Double mpsizeWidth;                 // 大箱尺寸宽
    private Double mpsizeHeight;                // 大箱尺寸高
    private String cnote;                       // 备注 (NOTE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;                     // 录入时间 (createdate)

    public FactoryC factoryC;
}
