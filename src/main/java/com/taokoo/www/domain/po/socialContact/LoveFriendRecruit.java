package com.taokoo.www.domain.po.socialContact;

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
 * @ClassName: LoveFriendRecruit
 * @Description: 情缘招募表
 * @author Taokoo
 * @date 2020-7-20
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoveFriendRecruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private UserRole userRole;//发起者

    private Integer age;

    @ManyToOne
    private Sex sex;//性别

    private String title;//标题

    private String region;// 期望区服描述

    @ManyToMany
    private List<Sects> sectsList;//期望门派

    @ManyToMany
    private List<Shape> shapeList;//期望体型

    @ManyToOne
    private Sex expectSex;//期望性别

    @OneToMany
    private List<PlayType> playTypeList;//PV?

    private String workBeginTime;//工作日在线时间起始时间

    private String workEndTime;//工作日在线时间结束时间

    private String holidayBeginTime;//假期在线时间起始时间

    private String holidayEndTime;//假期在线时间结束时间

    private Boolean isThree;//是否奔现（是否涉三）

    private String introduce;//自我介绍

    private String body;//内容描述

    private Integer status;//招募状态 ： 0：关闭  1： 开启
}
