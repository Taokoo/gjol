package com.taokoo.www.domain.po.team;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.user.User;
import com.taokoo.www.domain.po.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Activity  
 * @Description: 活动
 * @author Taokoo
 * @date 2020-7-24
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
//    private String name;
    
    private Date createDate;
    
    private String theme;//主题
    
    private String descInfo;//活动内容描述
    
    private Integer teamId;//活动所属公会id，这里手动添加
    
    @ManyToOne
    private User leader;//发起人
    
    @OneToMany
    List<UserRole> roles;//参与角色
}
