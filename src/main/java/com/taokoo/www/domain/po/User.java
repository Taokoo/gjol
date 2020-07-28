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
 * @ClassName: User  
 * @Description: 账号
 * @author Taokoo
 * @date 2020-7-20
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String username;
    
    @JsonIgnore
    private String password;
    
    private String nickname;//昵称
    
    private Integer age;
    
    private Integer sex;//1：男  2：女
    
    private String qq; 
    
    private String wx;
    
    private String mail;
    
    private String phone;
    
    private String signature;//签名
    
    private String HeadPortrait;//头像
    
    private Integer active;//在线状态 0：离线   1：在线
    
    private Integer type;//账号类型: 1:普通用户   2： vip用户  66：管理员  99：超级管理员
    
    private Integer status;//账号状态 1:正常   99：封禁
    
    @JsonIgnore
    private Date createTime;//创建时间
}