package com.taokoo.www.domain.po.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.team.Team;
import com.taokoo.www.domain.po.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Invitation  
 * @Description: 邀请表
 * @author Taokoo
 * @date 2020-7-28
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String value;
    
    @ManyToOne
    private UserRole userRole;//申请的用户角色
    
    @ManyToOne
    private Team team;//邀请进入的固定团
    
    @ManyToOne
    private UserRole beInvitedUserRole;//受邀的用户角色
    
    private Integer status;//状态  1：已发出邀请    2：已同意邀请     3：已拒绝邀请
}
