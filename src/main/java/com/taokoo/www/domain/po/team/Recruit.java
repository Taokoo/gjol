package com.taokoo.www.domain.po.team;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.taokoo.www.domain.po.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Recruit  
 * @Description: 招募表
 * @author Taokoo
 * @date 2020-7-28
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;//标题

    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String body;//内容
    
    @OneToOne
    private Team team;//所属固定团
    
    private Integer status;//状态  1：招募中   2：关闭招募
}
