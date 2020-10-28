package com.giao.ssm.domain;

import com.giao.ssm.extend.CreateUser;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 影耀子
 * 意见反馈实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeedbackC extends CreateUser implements Serializable {

    private String feedbackId;      // FEEDBACK_ID 主键
    private String inputBy;         // 提出人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;         // 提出时间
    private String title;           // 标题
    private String content;         // 内容
    private String classType;       // 分类 （1管理2安全3建议4其他）
    private String tel;             // 联系电话
    private String answerBy;        // 解决人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date answerTime;        // 解决时间
    private String solveMethod;     // 解决办法
    private String resolution;      // 解决方式 （1已修改2无需修改3重复问题4描述不完整5无法再现6其他）
    private String difficulty;      // 解决难度 （1极难2比较难3有难度4一般）
    private String isShare;         // 是否公开 （0不公开1公开）
    private Integer state;          // 状态 （0未处理1已处理）
}
