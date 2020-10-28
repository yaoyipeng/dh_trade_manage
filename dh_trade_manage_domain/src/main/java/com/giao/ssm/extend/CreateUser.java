package com.giao.ssm.extend;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 每张表的创建人，部门，时间，的实体类，用到时继承这个实体类即可
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUser {

    private String createBy;        // 创建人
    private String createDept;      // 创建部门
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;        // 创建日期

}
