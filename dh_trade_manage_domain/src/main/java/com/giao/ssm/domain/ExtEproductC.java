package com.giao.ssm.domain;

import com.giao.ssm.extend.Contract;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * 报运商品附件实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExtEproductC extends Contract implements Serializable {

    private String extEproductId;       // EXT_EPRODUCT_ID 主键
    private String factoryId;           // FACTORY_ID   外键（标识从哪个合同货物而来）
    private String exportProductId;     // EXPORT_PRODUCT_ID 外键
    private String contractProductId;   // CONTRACT_PRODUCT_ID
    private Integer ctype;               // 类型[系统下拉列表]

    private FactoryC factoryC;
    private ExportProductC exportProductC;
}
