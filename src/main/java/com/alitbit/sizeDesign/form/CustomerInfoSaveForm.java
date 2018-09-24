package com.alitbit.sizeDesign.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoSaveForm {

    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "淘宝名不能为空")
    private String tbName; //淘宝名
    @NotBlank(message = "平时尺寸不能为空")
    private String smallSize; //淘宝上尺寸
    @NotNull(message = "身高不能为空")
    private BigDecimal height; //身高
    @NotNull(message = "颈侧点-膝盖不能为空")
    private BigDecimal neckKnee; //颈侧点-膝盖
    @NotNull(message = "1/2肩宽+袖长不能为空")
    private BigDecimal shoulderSleeve; //1/2肩宽+袖长
    @NotNull(message = "胸围不能为空")
    private BigDecimal chest; //胸围
    @NotNull(message = "腰围不能为空")
    private BigDecimal waist; //腰围
    @NotNull(message = "臀围不能为空")
    private BigDecimal ass; //臀围
    @NotNull(message = "袖肥不能为空")
    private BigDecimal sleeveFat; //袖肥
    private BigDecimal neck; //颈围
    private BigDecimal shoulder; //肩宽
    private BigDecimal chestDistance; //胸距
    private BigDecimal chestUp; //上胸围
    private BigDecimal chestFront; //前胸宽
    private BigDecimal backWidth; //后背宽
    private BigDecimal backLength; //背长
    private BigDecimal armLength; //臂长
    private BigDecimal armUpLength; //上臂长
    private BigDecimal sleeveLength; //袖长
    private BigDecimal armWidth; //臂围
    private BigDecimal sleeveWidth; //袖笼围
    private BigDecimal elbowWidth; //肘围
    private BigDecimal wristWidth; //手腕围
    private BigDecimal pants; //通档
    private BigDecimal bigLagWidth; //大腿根围
    private BigDecimal kneeWidth; //膝围
    private BigDecimal smallLagWidth; //小腿围
    private BigDecimal ankleWidth; //脚踝围
    private BigDecimal chestHeight; //胸高
    private BigDecimal wristHeight; //腰高
    private BigDecimal backMidLength; //后中长
    private BigDecimal wristKnee; //中腰-膝盖距离
    private BigDecimal seventhLag; //第七颈椎点-大腿跟围

}
