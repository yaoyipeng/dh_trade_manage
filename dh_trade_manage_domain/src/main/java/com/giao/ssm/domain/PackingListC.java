package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 装箱单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PackingListC extends CreateUser implements Serializable {

    private String packingListId;   // PACKING_LIST_ID 主键
    private String exportId;        // EXPORT_ID 外键
    private String seller;          // 卖方
    private String buyer;           // 买方
    private String invoiceNo;       // 发票号 (选择)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;       // 发票日期
    private String marks;           // 唛头
    private String descriptions;    // 描述
    private String exportIds;    // 储存报运的id的串
    private String exportNos;       // 储存报运号
        private Integer state;          // 状态

    private ExportC exportC;

}
