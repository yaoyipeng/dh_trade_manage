package com.giao.ssm.domain;

import com.giao.ssm.extend.Contract;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 影耀子
 * 合同商品明细实体类
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractProductC extends Contract implements Serializable {

    private String contractProductId;       // CONTRACT_PRODUCT_ID 主键
    private String contractId;              // CONTRACT_ID 外键
    private String factoryId;               // FACTORY_ID 外键


    private ContractC contractC;
    private FactoryC factoryC;

    private List<ExtCproductC> extCproductCS;   // 对应多个附件信息

}

