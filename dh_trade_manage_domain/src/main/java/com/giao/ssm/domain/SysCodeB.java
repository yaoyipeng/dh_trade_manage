package com.giao.ssm.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 分类表实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysCodeB implements Serializable {

    private String sysCodeId;
    private String name;
    private String parentId;
    private String parentName;
    private Integer layerNum;
    private Integer isLeaf;
    private Integer quoteNum;
    private String cnote;
    private String ico;
    private Integer orderNo;
    private String state;
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    private String updatedBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime;



}
