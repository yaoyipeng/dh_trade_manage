package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 财务报运单实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FinanceC extends CreateUser implements Serializable {

    private String financeId;       // FINANCE_ID 主键
    private String packingListId;   // PACKING_LIST_ID 外键
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;         // 制单日期
    private String inputBy;         // 制单人

    private PackingListC packingListC;

}
