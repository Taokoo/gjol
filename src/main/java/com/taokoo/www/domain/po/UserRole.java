package com.taokoo.www.domain.po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    
    @ManyToOne
    @JsonIgnore
    private User user;
    
    @OneToOne
    @JsonIgnore
    private Region Region;//区服
    
    @OneToOne
    @JsonIgnore
    private Camp camp;//阵营
    
    @OneToOne
    @JsonIgnore
    private Profession profession;//职业
    
    @OneToMany
    @JsonIgnore
    private List<Mastery> mastery;//专精
    
    private Integer equipLv;//装等
    
    private Integer type;//1：大号   2：小号
    
    private Boolean isPublic;//是否公开信息（不公开则无法在广场上看到）
    
    @ManyToOne
    @JsonIgnore
    private Team team;//所在固定团
    
    private Boolean isLeader;//是否团长
}
