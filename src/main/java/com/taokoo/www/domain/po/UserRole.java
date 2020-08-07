package com.taokoo.www.domain.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    private Boolean isTeamMember;//是否固定团成员
    
    private Boolean isLeader;//是否团长

    private Integer shape;//体型    1： 成男    2：成女    3：萝莉

//    @JsonIgnore
    private Date createTime;//创建时间
    
}
