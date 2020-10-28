package com.giao.ssm.domain;

import com.giao.ssm.extend.ContractCExpand;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author 影耀子
 * 购销合同实体类
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractC extends ContractCExpand implements Serializable {

    private String contractId;          // 主键
    private String offeror;             // 收购方
    private String contractNo;          // 合同号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signingDate;           // 签单日期
    private String inputBy;             // 制单人
    private String checkBy;             // 审单人
    private String inspector;           // 验货员
    private Double totalAmount;         // 总金额
    private String request;             // 要求
    private String customName;          // 客户名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shipTime;              // 船期
    private Integer importNum;          // 重要程度  打印时标识几个星,对应说明中的内容 1,2,3分别对应1，2，3颗星
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;        // 交货期限
    private String remark;              // 说明
    private String printStyle;          // 打印版式 宽2:一页两个货物  窄1:一页一个货物
    private Integer oldState;           // 归档前状态 归档前状态, 方便回退 0，1
    private Integer state;              // 状态 0归档 1草稿 2待报运 归档后, 其他选择合同的地方均去除. 表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况
    private Integer outState;           // 走货状态 0未走货 1部分 2全部归档后, 其他选择合同的地方均去除.表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况

    private String tradeTerms;          // 贸易条款

    private List<ContractProductC> contractProductCS;   // 对应多个合同商品明细(货物)

}
