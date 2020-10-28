package com.giao.ssm.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-14 15:01
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginLogP implements Serializable {

    private String loginLogId;
    private String loginName;
    private String ipAddress;
    private Date loginTime;


}
