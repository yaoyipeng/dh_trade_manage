package com.giao.ssm.extend;

import lombok.*;

/**
 * @author 影耀子
 * 购销合同扩展类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractCExpand extends CreateUser {

    /**
     * 虚拟字段几乎全是sql语句起的别名，用来接收
     */
    private String cpnum;               // 虚拟字段（货物数）
    private String extnum;              // 虚拟字段（附件数）
    private Double totalAmountVirtual;  // 虚拟字段（总价格，未添加至数据库）

}
