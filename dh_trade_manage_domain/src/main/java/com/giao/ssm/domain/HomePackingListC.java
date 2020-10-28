package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * HOME装箱单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomePackingListC extends CreateUser implements Serializable {

    private String homePackingListId;       // HOME_PACKING_LIST_ID 主键
    private String exportId;                // EXPORT_ID 外键
    private String seller;                  // 卖方
    private String buyer;                   // 买方
    private String marks;                   // 唛头
    private String descriptions;            // 描述

    private ExportC exportC;

}
