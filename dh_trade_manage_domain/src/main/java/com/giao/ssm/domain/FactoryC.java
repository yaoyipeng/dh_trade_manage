package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;

import java.io.Serializable;

/**
 * @author 影耀子
 * 生产工厂实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactoryC extends CreateUser implements Serializable {

    private String factoryId;       // 主键id
    private String fullName;        // 厂家全称
    private String factoryName;     // 名称缩写
    private String contactor;       // 联系人
    private String phone;           // 电话
    private String mobile;          // 手机
    private String fax;             // 传真
    private String cnote;           // 说明
    private Integer ctype;          // 类型 (SYS_CODE_B 0103)
    private String state;           // 状态 (1正常2停止)
    private String inspector;       // 验货员
    private Integer orderNo;        // 排序号

}
