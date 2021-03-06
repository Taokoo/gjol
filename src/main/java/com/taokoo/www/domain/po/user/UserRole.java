package com.taokoo.www.domain.po.user;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.team.Team;
import com.taokoo.www.domain.po.enumData.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ClassName: UserRole
 * @Description: 角色
 * @author Taokoo
 * @date 2020-7-20
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    private Integer equipLv;//装等
    
    private Integer type;//1：大号   2：小号
    
    private Boolean isPublic;//是否公开信息（不公开则无法在广场上看到）

    private Boolean isTeamMember;//是否固定团成员（方便搜索用的）
    
    private Boolean isLeader;//是否团长

    @ManyToOne
    private Shape shape;//体型

    @ManyToOne
    private Camp camp;//阵营

    @ManyToOne
    private Mastery mastery;//专精

    @ManyToOne
    private Profession profession;//门派

    @ManyToOne
    private Region region;//区服

    @ManyToOne
    private Team team;//固定团

    @ManyToOne
    private User user;//账号

//    @JsonIgnore
    private Date createTime;//创建时间
    
}
