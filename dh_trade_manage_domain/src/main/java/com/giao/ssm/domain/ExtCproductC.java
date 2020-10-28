package com.giao.ssm.domain;

import com.giao.ssm.extend.Contract;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * 合同商品附件实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExtCproductC extends Contract implements Serializable {

    private String extCproductId;           // EXT_CPRODUCT_ID 主键
    private String factoryId;               // FACTORY_ID 外键
    private String contractProductId;       // CONTRACT_PRODUCT_ID 外键
    private Integer ctype;                  // 类型[系统下拉列表] (SYS_CODE=0104)

    private FactoryC factoryC;
    private ContractProductC contractProductC;

}
