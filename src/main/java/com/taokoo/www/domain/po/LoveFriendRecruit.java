package com.taokoo.www.domain.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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

    private Integer sex;//1：男  2：女  3：0  4：1  5：不限

    private String title;//标题

    private String Region;//期望区服

    @OneToMany
    private List<Sects> SectsList;//期望门派

    private Integer expectSex;//1：男  2：女  3：0  4：1  5：不限

    @OneToMany
    private List<PlayType> playTypeList;//PV?

    private String workBeginTime;//工作日在线时间起始时间

    private String workEndTime;//工作日在线时间时间

    private String holidayBeginTime;//假期在线时间起始时间

    private String holidayEndTime;//假期在线时间时间

    private Boolean isThree;//是否奔现（是否涉三）

    private String introduce;//自我介绍

    private String body;//内容描述
}
