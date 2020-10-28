package com.giao.ssm.domain;

import com.giao.ssm.extend.Contract;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * 报运商品明细实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExportProductC extends Contract implements Serializable {

    private String exportProductId;         // EXPORT_PRODUCT_ID 主键
    private String contractProductId;       // CONTRACT_PRODUCT_ID （标识从哪个合同货物而来）
    private String exportId;                // EXPORT_ID 外键
    private String factoryId;               // FACTORY_ID 外键
    private String contractId;              // CONTRACT_ID
    private String contractNo;              // 合同号

    private ExportC exportC;
    private FactoryC factoryC;
}
