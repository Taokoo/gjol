package com.taokoo.www.domain.po.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Apply  
 * @Description: 申请表
 * @author Taokoo
 * @date 2020-7-28
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
//    private String value;
    
    @ManyToOne
    private UserRole userRole;//申请的用户角色

    private String message;//申请留言
    
    @ManyToOne
    private Recruit recruit;//申请的招募表
    
    private Integer status;//状态  1：已发出申请    2：已同意申请     3：已拒绝申请
}
