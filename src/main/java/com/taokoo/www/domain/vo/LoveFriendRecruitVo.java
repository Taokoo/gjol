package com.taokoo.www.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taokoo.www.domain.po.enumData.PlayType;
import com.taokoo.www.domain.po.enumData.Sects;
import com.taokoo.www.domain.po.enumData.Sex;
import com.taokoo.www.domain.po.enumData.Shape;
import com.taokoo.www.domain.po.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: LoveFriendRecruitVo
 * @Description: 情缘招募表VO
 * @author Taokoo
 * @date 2020-7-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoveFriendRecruitVo {

    private Integer userRoleId;//发起者

    private Integer age;

    private Integer sex;//性别ID

    private String title;//标题

    private String Region;// 期望区服描述

    private String SectsList;//期望门派列表,多个选择用逗号分隔

    private String shapeList;//期望体型,多个选择用逗号分隔

    private Integer expectSex;//期望性别

    private String playTypeList;//PV? ,多个选择用逗号分隔

    private String workBeginTime;//工作日在线时间起始时间

    private String workEndTime;//工作日在线时间时间

    private String holidayBeginTime;//假期在线时间起始时间

    private String holidayEndTime;//假期在线时间时间

    private Boolean isThree;//是否奔现（是否涉三）

    private String introduce;//自我介绍

    private String body;//内容描述

}
