package com.giao.ssm.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 用户模板表实体类
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTempB implements Serializable {

    private String userTempId;          // 主键
    private String keyClass;            // 分类
    private String keyName;             // 关键字
    private String keyContent;          // 内容
    private Integer state;              // 状态 （0停用1启用）
    private Integer orderNo;            // 排序号
    private String cnote;               // 说明
    private String updateBy;            // 修改人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;            // 修改日期

}
