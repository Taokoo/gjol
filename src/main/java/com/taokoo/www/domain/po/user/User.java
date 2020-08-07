package com.taokoo.www.domain.po.user;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.enumData.Sex;
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

    @ManyToOne
    private Sex sex;
    
    private String qq; 
    
    private String wx;
    
    private String mail;
    
    private String phone;
    
    private String signature;//签名
    
    private String HeadPortrait;//头像
    
    private Integer active;//在线状态 0：离线   1：在线

    @ManyToOne
    private AccountType accountType;//账号类型

    @ManyToOne
    private AccountStatus status;//账号状态
    
    @JsonIgnore
    private Date createTime;//创建时间
}