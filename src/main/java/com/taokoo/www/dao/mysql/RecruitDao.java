package com.taokoo.www.dao.mysql;

import com.taokoo.www.domain.po.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitDao extends JpaRepository<Recruit, Integer> {

}
