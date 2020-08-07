package com.taokoo.www.domain.po.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName: AccountType
 * @Description: 账号类型  1:普通用户   2： vip用户  66：管理员  99：超级管理员
 * @author Taokoo
 * @date 2020-8-7
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;
}